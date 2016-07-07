package seatGeekPortal;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.concurrent.*;


/**
 * Created by RAM0N on 7/6/16.
 */
public class CaptureWebDriver {

    public static void main(String[] args) {
        ExecutorService exService = Executors.newSingleThreadExecutor();
        FutureTask<ArrayList<Event>> futureTask= new FutureTask<ArrayList<Event>>(new GetEventsCallable());
        exService.execute(futureTask);
//        //checks if task done
//        System.out.println(futureTask.isDone());
//        //checks if task canceled
//        System.out.println(futureTask.isCancelled());
        //fetches result and waits if not ready
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


    }
}

class GetEventsCallable implements Callable<ArrayList<Event>> {
    private static final String HTTP_SERVICES_SEAT_GEEK_CHICAGO_CUBS = "https://api.seatgeek.com/2/events?q=chicago+cubs&sort=score.desc&per_page=10";
    public ArrayList<Event> call() {

        String str = null;
        try {
            str = JsonParser.sendGet(HTTP_SERVICES_SEAT_GEEK_CHICAGO_CUBS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str == null){
            System.out.println("Sorry, I couldn't find your data");
        }

        //Event eventData = new Gson().fromJson(str, Event.class);
        EventData eventData = new Gson().fromJson(str, EventData.class);
        //EventData eventData = eventData.getEvents();
        ArrayList<Event> eventsList = new ArrayList<>(eventData.getEvents());


        return eventsList;
    }
}