package Models;

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

    /**
     * this is a constructor to validate the information being brought in from JSON file is correct.
     * otherwise it will use the set methods and throw exceptions.
     * @param title
     * @param publisher
     * @param releaseDate
     * @param grossRevenue
     * @param rating
     */
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

    /**
     * this method sets the title, and validates that it in fact a correct Call of Duty franchise game.
     * @param title
     */
    public void setTitle(String title) {
        if(title.contains("Call of Duty")) {
            this.title = title;
        }
        else {
            throw new IllegalArgumentException("Game is not a valid Call of Duty game, please try again.");
        }
    }

    public String getPublisher() {
        return publisher;
    }

    /**
     * this method sets the publisher, and validates that it in fact a correct Call of Duty franchise publisher.
     * @param publisher
     */
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

    /**
     * this method validates that the release date is correct, and was not created before the first call of duty game (thus being invalid)
     * @param releaseDate
     */
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

    /**
     * this method validates that the revenue is more than 0, as it's not possible to have negative revenue.
     * @param grossRevenue
     */
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

    /**
     * this method will validate that the rating is greater than or equal to 0.
     * @param rating
     */
    public void setRating(int rating) {
        if(rating >=0) {
            this.rating = rating;
        }
        else {
            throw new IllegalArgumentException("Rating cannot be lower than 0! (even though sometimes we want it to be!)");
        }
    }

    /**
     * this method will create a toString that will return the title, so when it's called into the database
     * it will display the correct title of the Call of Duty game called.
     * @return
     */
    public String toString() {
            return getTitle();
    }
}
