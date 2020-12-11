package Utilities;

import Models.GameJSONResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class GameJSONReader {

    /**
     * This method will search through the JSON file (GameJSONResponse) and read through the data
     * and allow me to use this data for my call of duty game database.
     */
    public static GameJSONResponse getGameJSON() {
        GameJSONResponse gameResponse = null;
        try(
                FileReader fileReader = new FileReader("./src/JSON/callOfDutyGames.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            Gson gson = new Gson();
            gameResponse = gson.fromJson(jsonReader, GameJSONResponse.class);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return gameResponse;
    }
}
