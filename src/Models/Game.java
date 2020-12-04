package Models;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class Game {
    private int gameID;
    private String title, publisher;
    private LocalDate releaseDate;
    private long grossRevenue;
    private int rating;

    /**
     * This constructor will automatically add a valid game to the
     * database
     * @param title (name)
     * @param publisher (company name)
     * @param grossRevenue (total money made)
     * @param releaseDate (the date the game was released)
     * @param rating (Average rating)
     * @throws SQLException (In case of SQL Error)
     */

    public Game(int gameID, String title, String publisher, LocalDate releaseDate, long grossRevenue, int rating) {
        setGameID(gameID);
        setTitle(title);
        setPublisher(publisher);
        setReleaseDate(releaseDate);
        setGrossRevenue(grossRevenue);
        setRating(rating);
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        if(gameID >0) {
            this.gameID = gameID;
        }
        else {
            throw new IllegalArgumentException("GameID is incorrect, must be greater than 0.");
        }
    }

    public String getTitle() {
        return title;
    }

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

    public void setPublisher(String publisher) {
        if (publisher.equalsIgnoreCase("Infinity Ward") || publisher.equalsIgnoreCase("Sledgehammer Games") || publisher.equalsIgnoreCase("Treyarch")) {
            this.publisher = publisher;
        }
        else
        {
            throw new IllegalArgumentException("Invalid publisher, please make sure it's correct.");
        }
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        if (releaseDate.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("releaseDate cannot be in the future");
        if (Period.between(LocalDate.now(), releaseDate).getYears()>25)
            throw new IllegalArgumentException("Invalid release date. The first Call of Duty was released in 2003.");
        this.releaseDate = releaseDate;
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
}
