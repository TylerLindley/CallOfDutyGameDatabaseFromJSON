package Models;

import com.google.gson.annotations.SerializedName;

public class GameJSONResponse {
    @SerializedName("Games")
    private GameInfo[] games;

    /**
     * this method will return the games from the JSON File.
     * @return games
     */
    public GameInfo[] getGames() {
        return games;
    }

    /**
     * this method sets the variables, could be used for validation if needed.
     * @param games
     */
    public void setGames(GameInfo[] games) {
        this.games = games;
    }

    /**
     * this method prints the toString of the game, so when it's called in my database list view, it will print the title of the game.
     * @return toString
     */
    public String toString() {
        return GameInfo.class.toString();
    }
}
