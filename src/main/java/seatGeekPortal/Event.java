
package seatGeekPortal;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Event {

    @SerializedName("links")
    @Expose
    private List<Object> links = new ArrayList<Object>();
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("announce_date")
    @Expose
    private String announceDate;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("date_tbd")
    @Expose
    private Boolean dateTbd;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("datetime_local")
    @Expose
    private String datetimeLocal;
    @SerializedName("visible_until_utc")
    @Expose
    private String visibleUntilUtc;
    @SerializedName("time_tbd")
    @Expose
    private Boolean timeTbd;
    @SerializedName("taxonomies")
    @Expose
    private List<Taxonomy> taxonomies = new ArrayList<Taxonomy>();
    @SerializedName("performers")
    @Expose
    private List<Performer> performers = new ArrayList<Performer>();
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("venue")
    @Expose
    private Venue venue;
    @SerializedName("short_title")
    @Expose
    private String shortTitle;
    @SerializedName("datetime_utc")
    @Expose
    private String datetimeUtc;
    @SerializedName("primary_performer_id")
    @Expose
    private Integer primaryPerformerId;
    @SerializedName("datetime_tbd")
    @Expose
    private Boolean datetimeTbd;

    /**
     * 
     * @return
     *     The links
     */
    public List<Object> getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The links
     */
    public void setLinks(List<Object> links) {
        this.links = links;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The stats
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * 
     * @param stats
     *     The stats
     */
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The announceDate
     */
    public String getAnnounceDate() {
        return announceDate;
    }

    /**
     * 
     * @param announceDate
     *     The announce_date
     */
    public void setAnnounceDate(String announceDate) {
        this.announceDate = announceDate;
    }

    /**
     * 
     * @return
     *     The score
     */
    public Double getScore() {
        return score;
    }

    /**
     * 
     * @param score
     *     The score
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * 
     * @return
     *     The dateTbd
     */
    public Boolean getDateTbd() {
        return dateTbd;
    }

    /**
     * 
     * @param dateTbd
     *     The date_tbd
     */
    public void setDateTbd(Boolean dateTbd) {
        this.dateTbd = dateTbd;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The datetimeLocal
     */
    public String getDatetimeLocal() {
        return datetimeLocal;
    }

    /**
     * 
     * @param datetimeLocal
     *     The datetime_local
     */
    public void setDatetimeLocal(String datetimeLocal) {
        this.datetimeLocal = datetimeLocal;
    }

    /**
     * 
     * @return
     *     The visibleUntilUtc
     */
    public String getVisibleUntilUtc() {
        return visibleUntilUtc;
    }

    /**
     * 
     * @param visibleUntilUtc
     *     The visible_until_utc
     */
    public void setVisibleUntilUtc(String visibleUntilUtc) {
        this.visibleUntilUtc = visibleUntilUtc;
    }

    /**
     * 
     * @return
     *     The timeTbd
     */
    public Boolean getTimeTbd() {
        return timeTbd;
    }

    /**
     * 
     * @param timeTbd
     *     The time_tbd
     */
    public void setTimeTbd(Boolean timeTbd) {
        this.timeTbd = timeTbd;
    }

    /**
     * 
     * @return
     *     The taxonomies
     */
    public List<Taxonomy> getTaxonomies() {
        return taxonomies;
    }

    /**
     * 
     * @param taxonomies
     *     The taxonomies
     */
    public void setTaxonomies(List<Taxonomy> taxonomies) {
        this.taxonomies = taxonomies;
    }

    /**
     * 
     * @return
     *     The performers
     */
    public List<Performer> getPerformers() {
        return performers;
    }

    /**
     * 
     * @param performers
     *     The performers
     */
    public void setPerformers(List<Performer> performers) {
        this.performers = performers;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The venue
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * 
     * @param venue
     *     The venue
     */
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    /**
     * 
     * @return
     *     The shortTitle
     */
    public String getShortTitle() {
        return shortTitle;
    }

    /**
     * 
     * @param shortTitle
     *     The short_title
     */
    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    /**
     * 
     * @return
     *     The datetimeUtc
     */
    public String getDatetimeUtc() {
        return datetimeUtc;
    }

    /**
     * 
     * @param datetimeUtc
     *     The datetime_utc
     */
    public void setDatetimeUtc(String datetimeUtc) {
        this.datetimeUtc = datetimeUtc;
    }

    /**
     * 
     * @return
     *     The primaryPerformerId
     */
    public Integer getPrimaryPerformerId() {
        return primaryPerformerId;
    }

    /**
     * 
     * @param primaryPerformerId
     *     The primary_performer_id
     */
    public void setPrimaryPerformerId(Integer primaryPerformerId) {
        this.primaryPerformerId = primaryPerformerId;
    }

    /**
     * 
     * @return
     *     The datetimeTbd
     */
    public Boolean getDatetimeTbd() {
        return datetimeTbd;
    }

    /**
     * 
     * @param datetimeTbd
     *     The datetime_tbd
     */
    public void setDatetimeTbd(Boolean datetimeTbd) {
        this.datetimeTbd = datetimeTbd;
    }

}
