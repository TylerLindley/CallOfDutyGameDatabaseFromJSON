package JSON;

import com.google.gson.annotations.SerializedName;

public class GameInfo {
    @SerializedName("Title")
    private String title;

    @SerializedName("Publisher")
    private String publisher;

    @SerializedName("ReleaseDate")
    private String releaseDate;

    @SerializedName("GrossRevenue")
    private long grossRevenue;

    @SerializedName("Rating")
    private int rating;

    public GameInfo(String title, String publisher, String releaseDate, long grossRevenue, int rating) {
        setTitle(title);
        setPublisher(publisher);
        setReleaseDate(releaseDate);
        setGrossRevenue(grossRevenue);
        setRating(rating);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.contains("1")) {
            this.title = title;
        }
        else {
            throw new IllegalArgumentException("Game is not a valid Call of Duty game, please try again.");
        }
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if (publisher.equalsIgnoreCase("Infinity Ward") || publisher.equalsIgnoreCase("Sledgehammer Games") || publisher.equalsIgnoreCase("Treyarch")) {
            this.publisher = publisher;
        }
        else
        {
            throw new IllegalArgumentException("Invalid publisher, please make sure it's correct.");
        }
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        if(releaseDate.startsWith("1")) {
            throw new IllegalArgumentException("Call of Duty was not released until 2003");
        }
        else {
            this.releaseDate = releaseDate;
        }
    }

    public long getGrossRevenue() {
        return grossRevenue;
    }

    public void setGrossRevenue(long grossRevenue) {
        if(grossRevenue >=0) {
            this.grossRevenue = grossRevenue;
        }
        else {
            throw new IllegalArgumentException("Revenue must be greater than or equal to 0.");
        }
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating >=0) {
            this.rating = rating;
        }
        else {
            throw new IllegalArgumentException("Rating cannot be lower than 0! (even though sometimes we want it to be!)");
        }
    }

    public String toString() {
            return getTitle();
    }
}
