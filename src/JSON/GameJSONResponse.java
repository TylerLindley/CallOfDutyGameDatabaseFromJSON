package JSON;

import com.google.gson.annotations.SerializedName;

public class GameJSONResponse {
    @SerializedName("Games")
    private GameInfo[] games;
}
