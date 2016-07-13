package seatGeekPortal;

import seatGeekPortal.EventAPIClasses.SeatGeekEvent;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * creates and runs a runnable task (EventDataQuery) to get data from the SeatGeek API
 */
class SeatGeekTask {

    // instance variables
    private String sQuery;
    private ArrayList<SeatGeekEvent> events;

    // constructor
    SeatGeekTask(String sQuery) {
        this.sQuery = sQuery.replaceAll("\\s", "+");  // transform for an HTML String query
        events = new ArrayList<>();
    }


    // call this method to get the events from a new SeatGeekTask
    ArrayList<SeatGeekEvent> getEvents() {
        // create an executor service, a runnable task, and execute the task
        ExecutorService exService = Executors.newSingleThreadExecutor();
        FutureTask<ArrayList<SeatGeekEvent>> futureTaskEventsData = new FutureTask<>(new EventsDataQuery(sQuery));
        exService.execute(futureTaskEventsData);

        // try to get the data and add to event list
        try {
            events.addAll(futureTaskEventsData.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("There was an error getting the events in the SeatGeekTask: ");
            System.out.println("  " + e);
        }

        // shut down the executor service
        exService.shutdownNow();

        // return the list of events
        return events;
    }


}
