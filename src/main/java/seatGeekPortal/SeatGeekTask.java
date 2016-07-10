package seatGeekPortal;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by RAM0N on 7/9/16.
 */
public class SeatGeekTask {

    private String sQuery;
    private ArrayList<Event> events;

    public SeatGeekTask(String sQuery) {
        this.sQuery = sQuery.replaceAll("\\s", "+");;
        events = new ArrayList<>();
    }


    public ArrayList<Event> getEvents() {

        ExecutorService exService = Executors.newSingleThreadExecutor();
        FutureTask<ArrayList<Event>> futureTaskEventsData = new FutureTask<>(new EventsDataQuery(sQuery));
        exService.execute(futureTaskEventsData);

        try {
            events.addAll(futureTaskEventsData.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        exService.shutdownNow();

        return events;
    }

    public ArrayList<String> getStringsListFromEvents() {
        ArrayList<String> eventStrings = new ArrayList<>();
        for (Event event : events) {
            eventStrings.add(event.getTitle() + " | " + event.getVenue() + " | " + event.getDatetimeLocal());
        }
        return eventStrings;
    }


}
