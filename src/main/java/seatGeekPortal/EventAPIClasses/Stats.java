
package seatGeekPortal.EventAPIClasses;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Stats {

    @SerializedName("listing_count")
    @Expose
    private Object listingCount;
    @SerializedName("average_price")
    @Expose
    private Object averagePrice;
    @SerializedName("lowest_price_good_deals")
    @Expose
    private Object lowestPriceGoodDeals;
    @SerializedName("lowest_price")
    @Expose
    private Object lowestPrice;
    @SerializedName("highest_price")
    @Expose
    private Object highestPrice;

    /**
     * 
     * @return
     *     The listingCount
     */
    public Object getListingCount() {
        return listingCount;
    }

    /**
     * 
     * @param listingCount
     *     The listing_count
     */
    public void setListingCount(Object listingCount) {
        this.listingCount = listingCount;
    }

    /**
     * 
     * @return
     *     The averagePrice
     */
    public Object getAveragePrice() {
        return averagePrice;
    }

    /**
     * 
     * @param averagePrice
     *     The average_price
     */
    public void setAveragePrice(Object averagePrice) {
        this.averagePrice = averagePrice;
    }

    /**
     * 
     * @return
     *     The lowestPriceGoodDeals
     */
    public Object getLowestPriceGoodDeals() {
        return lowestPriceGoodDeals;
    }

    /**
     * 
     * @param lowestPriceGoodDeals
     *     The lowest_price_good_deals
     */
    public void setLowestPriceGoodDeals(Object lowestPriceGoodDeals) {
        this.lowestPriceGoodDeals = lowestPriceGoodDeals;
    }

    /**
     * 
     * @return
     *     The lowestPrice
     */
    public Object getLowestPrice() {
        return lowestPrice;
    }

    /**
     * 
     * @param lowestPrice
     *     The lowest_price
     */
    public void setLowestPrice(Object lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    /**
     * 
     * @return
     *     The highestPrice
     */
    public Object getHighestPrice() {
        return highestPrice;
    }

    /**
     * 
     * @param highestPrice
     *     The highest_price
     */
    public void setHighestPrice(Object highestPrice) {
        this.highestPrice = highestPrice;
    }

}
