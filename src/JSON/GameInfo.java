package JSON;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

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
        setTitle(title);
        setPublisher(publisher);
        setReleaseDate(releaseDate);
        setGrossRevenue(grossRevenue);
        setRating(rating);
    }

    public void validateVariables() {
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
        this.releaseDate = releaseDate;
        //if (releaseDate.isAfter(LocalDate.now()))
          //  throw new IllegalArgumentException("releaseDate cannot be in the future");
        //if (Period.between(LocalDate.now(), releaseDate).getYears()>25)
          //  throw new IllegalArgumentException("Invalid release date. The first Call of Duty was released in 2003.");
    }

    public BigDecimal getGrossRevenue() {
        return grossRevenue;
    }

    public void setGrossRevenue(BigDecimal grossRevenue) {
        //if(grossRevenue >=.00) {
            this.grossRevenue = grossRevenue;
        //}
        //else {
          //  throw new IllegalArgumentException("Revenue must be greater than or equal to 0.");
        //}
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

    public boolean contains(String searchString)
    {
        searchString = searchString.toLowerCase();

        return title.toLowerCase().contains(searchString);
    }
}
