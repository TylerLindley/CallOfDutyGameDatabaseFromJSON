package JSON;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class GameInfo {
    @SerializedName("Title")
    private String title;

    @SerializedName("Publisher")
    private String publisher;

    @SerializedName("ReleaseDate")
    private String releaseDate;

    @SerializedName("GrossRevenue")
    private BigDecimal grossRevenue;

    @SerializedName("Rating")
    private int rating;

    public GameInfo(String title, String publisher, String releaseDate, BigDecimal grossRevenue, int rating) {
        this.title = title;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.grossRevenue = grossRevenue;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BigDecimal getGrossRevenue() {
        return grossRevenue;
    }

    public void setGrossRevenue(BigDecimal grossRevenue) {
        this.grossRevenue = grossRevenue;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String toString() {
        return getTitle();
    }
}
