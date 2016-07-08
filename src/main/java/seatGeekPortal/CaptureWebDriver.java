package seatGeekPortal;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.concurrent.*;


/**
 * Created by RAM0N on 7/6/16.
 */
public class CaptureWebDriver {

    public static void main(String[] args) {

        String sTestQuery = "Chicago Cubs";
        String sQuery = sTestQuery.replace(" ", "+");

        ExecutorService exService = Executors.newSingleThreadExecutor();
        FutureTask<ArrayList<Event>> futureTask= new FutureTask<ArrayList<Event>>(new GetEventsCallable(sQuery));
        exService.execute(futureTask);
//        //checks if task done
//        System.out.println(futureTask.isDone());
//        //checks if task canceled
//        System.out.println(futureTask.isCancelled());
//        // fetches result and waits if not ready


            try {
                ArrayList<Event> results = futureTask.get();
                for (Event result : results) {
                    System.out.println(result.getTitle() + " : " + result.getVenue().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            futureTask.cancel(true);


    }
}

class GetEventsCallable implements Callable<ArrayList<Event>> {

    // Strings for HTTP query of SeatGeek API
    private static final String SEAT_GEEK_API_QUERY = "https://api.seatgeek.com/2/events?q=";
    private static final String RESULTS_PER_PAGE_TAG = "&per_page=";
    private static final String PAGE_TAG = "&page=20";
    private static final String SORT_TAG = "&sort=score.desc";
    private static final String CLIENT_ID_TAG = "&client_id=NTEyODcwNnwxNDY3NzUzOTYy";

    private String sQuery;

    public GetEventsCallable(String sQuery) {
        this.sQuery = sQuery;
    }


    public ArrayList<Event> call() {


        int iPage = 1;
        int iTotalRecordsAvailable = -1;
        int iRecordsProcessed = 0;
        int iRecordsPerPage = 10;
        String sData = null;
        EventData eventData = null;
        ArrayList<Event> events = new ArrayList<>();

        // get number of records available
        try {
            sData = JsonParser.sendGet(SEAT_GEEK_API_QUERY + sQuery + CLIENT_ID_TAG);
            eventData = new Gson().fromJson(sData, EventData.class);
            iTotalRecordsAvailable = eventData.getMeta().getTotal();
            System.out.println("Total records avail: " + iTotalRecordsAvailable);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // increment page number and add events to list
        while (iRecordsProcessed < iTotalRecordsAvailable) {
            try {
                System.out.println("trying to add data from page: " + iPage);
                sData = JsonParser.sendGet(SEAT_GEEK_API_QUERY + sQuery + SORT_TAG + PAGE_TAG + iPage + CLIENT_ID_TAG);
                eventData = new Gson().fromJson(sData, EventData.class);
                events.addAll(eventData.getEvents());
                iRecordsProcessed = events.size();
                System.out.println("Records processed: " + iRecordsProcessed);
                iPage++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Exited Loop");
        return events;


//
//        String str = null;
//        try {
//            str = JsonParser.sendGet(SEAT_GEEK_API_QUERY + sQuery + SORT_TAG + PAGE_TAG + CLIENT_ID_TAG);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (str == null){
//            System.out.println("Sorry, I couldn't find your data");
//        }
//
//        //Event eventData = new Gson().fromJson(str, Event.class);
//        EventData eventData = new Gson().fromJson(str, EventData.class);
//        System.out.println(eventData.getMeta().getTotal());
//        //EventData eventData = eventData.getEvents();
//        ArrayList<Event> eventsList = new ArrayList<>(eventData.getEvents());
//
//
//        return eventsList;
    }
}