package JSON;

import com.google.gson.annotations.SerializedName;

public class GameJSONResponse {
    @SerializedName("Games")
    private GameInfo[] games;

    public GameInfo[] getGames() {
        return games;
    }

    public void setGames(GameInfo[] games) {
        this.games = games;
    }

    public String toString() {
        return GameInfo.class.toString();
    }
}
