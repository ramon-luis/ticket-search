
package seatGeekPortal.EventAPIClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class EventData {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("events")
    @Expose
    private List<SeatGeekEvent> events = new ArrayList<SeatGeekEvent>();

    /**
     * 
     * @return
     *     The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * 
     * @param meta
     *     The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     * 
     * @return
     *     The events
     */
    public List<SeatGeekEvent> getEvents() {
        return events;
    }

    /**
     * 
     * @param events
     *     The events
     */
    public void setEvents(List<SeatGeekEvent> events) {
        this.events = events;
    }

}
