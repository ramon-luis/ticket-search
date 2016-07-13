package seatGeekPortal;

import com.google.gson.Gson;
import seatGeekPortal.EventAPIClasses.SeatGeekEvent;
import seatGeekPortal.EventAPIClasses.EventData;

import java.util.concurrent.Callable;
import java.util.ArrayList;

/**
 * Queries the SeatGeek API for event data: converts JSON to POJO via GSON
 */
 public class EventsDataQuery implements Callable<ArrayList<SeatGeekEvent>> {

    // CONSTANTS: Strings for HTTP query of SeatGeek API
    private static final String SEAT_GEEK_API_QUERY = "https://api.seatgeek.com/2/events?q=";
    private static final String RESULTS_PER_PAGE_TAG = "&per_page=25";
    private static final String SORT_TAG = "&sort=score.desc";  // sorts based on SeatGeek 'score'
    private static final String CLIENT_ID_TAG = "&client_id=NTEyODcwNnwxNDY3NzUzOTYy";

    // instance variables
    private String sQuery;
    private String sData;
    private EventData eventData;
    private ArrayList<SeatGeekEvent> events;

    // constructor -> no public access needed
    public EventsDataQuery(String sQuery) {
        this.sQuery = sQuery;
        this.sData = null;
        this.eventData = null;
        this.events = new ArrayList<>();
    }

    // callable method
    public ArrayList<SeatGeekEvent> call() {

        // get the data as a String
        // transform the data from String format into Event data class
        // get the individual event objects and add them to the event list
        try {
            sData = JsonParser.sendGet(SEAT_GEEK_API_QUERY + sQuery + SORT_TAG + RESULTS_PER_PAGE_TAG + CLIENT_ID_TAG);
            eventData = new Gson().fromJson(sData, EventData.class);
            events.addAll(eventData.getEvents());
        } catch (Exception e) {
            System.out.println("There was an error getting the data:");
            System.out.println("  " + e);
        }

        // return the list of events
        return events;
    }

}
