
package seatGeekPortal;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Stats_ {

    @SerializedName("event_count")
    @Expose
    private Integer eventCount;

    /**
     * 
     * @return
     *     The eventCount
     */
    public Integer getEventCount() {
        return eventCount;
    }

    /**
     * 
     * @param eventCount
     *     The event_count
     */
    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

}
