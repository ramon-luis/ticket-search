
package seatGeekPortal.EventAPIClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Images {

    @SerializedName("huge")
    @Expose
    private String huge;

    /**
     * 
     * @return
     *     The huge
     */
    public String getHuge() {
        return huge;
    }

    /**
     * 
     * @param huge
     *     The huge
     */
    public void setHuge(String huge) {
        this.huge = huge;
    }

}
