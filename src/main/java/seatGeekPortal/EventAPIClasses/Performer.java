
package seatGeekPortal.EventAPIClasses;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Performer {

    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("primary")
    @Expose
    private Boolean primary;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("has_upcoming_events")
    @Expose
    private Boolean hasUpcomingEvents;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("stats")
    @Expose
    private Stats_ stats;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("taxonomies")
    @Expose
    private List<Taxonomy_> taxonomies = new ArrayList<Taxonomy_>();
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("home_venue_id")
    @Expose
    private Integer homeVenueId;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("divisions")
    @Expose
    private Object divisions;
    @SerializedName("home_team")
    @Expose
    private Boolean homeTeam;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("away_team")
    @Expose
    private Boolean awayTeam;

    /**
     * 
     * @return
     *     The image
     */
    public String getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The primary
     */
    public Boolean getPrimary() {
        return primary;
    }

    /**
     * 
     * @param primary
     *     The primary
     */
    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    /**
     * 
     * @return
     *     The images
     */
    public Images getImages() {
        return images;
    }

    /**
     * 
     * @param images
     *     The images
     */
    public void setImages(Images images) {
        this.images = images;
    }

    /**
     * 
     * @return
     *     The hasUpcomingEvents
     */
    public Boolean getHasUpcomingEvents() {
        return hasUpcomingEvents;
    }

    /**
     * 
     * @param hasUpcomingEvents
     *     The has_upcoming_events
     */
    public void setHasUpcomingEvents(Boolean hasUpcomingEvents) {
        this.hasUpcomingEvents = hasUpcomingEvents;
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
    public Stats_ getStats() {
        return stats;
    }

    /**
     * 
     * @param stats
     *     The stats
     */
    public void setStats(Stats_ stats) {
        this.stats = stats;
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
     *     The taxonomies
     */
    public List<Taxonomy_> getTaxonomies() {
        return taxonomies;
    }

    /**
     * 
     * @param taxonomies
     *     The taxonomies
     */
    public void setTaxonomies(List<Taxonomy_> taxonomies) {
        this.taxonomies = taxonomies;
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
     *     The shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 
     * @param shortName
     *     The short_name
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * 
     * @return
     *     The homeVenueId
     */
    public Integer getHomeVenueId() {
        return homeVenueId;
    }

    /**
     * 
     * @param homeVenueId
     *     The home_venue_id
     */
    public void setHomeVenueId(Integer homeVenueId) {
        this.homeVenueId = homeVenueId;
    }

    /**
     * 
     * @return
     *     The slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * 
     * @param slug
     *     The slug
     */
    public void setSlug(String slug) {
        this.slug = slug;
    }

    /**
     * 
     * @return
     *     The divisions
     */
    public Object getDivisions() {
        return divisions;
    }

    /**
     * 
     * @param divisions
     *     The divisions
     */
    public void setDivisions(Object divisions) {
        this.divisions = divisions;
    }

    /**
     * 
     * @return
     *     The homeTeam
     */
    public Boolean getHomeTeam() {
        return homeTeam;
    }

    /**
     * 
     * @param homeTeam
     *     The home_team
     */
    public void setHomeTeam(Boolean homeTeam) {
        this.homeTeam = homeTeam;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
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
     *     The awayTeam
     */
    public Boolean getAwayTeam() {
        return awayTeam;
    }

    /**
     * 
     * @param awayTeam
     *     The away_team
     */
    public void setAwayTeam(Boolean awayTeam) {
        this.awayTeam = awayTeam;
    }

}
