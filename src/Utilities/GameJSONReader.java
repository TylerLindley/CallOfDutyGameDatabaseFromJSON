package Utilities;

import JSON.GameJSONResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class GameJSONReader {

    public static GameJSONResponse getGameJSON() {
        GameJSONResponse gameResponse = null;
        try(
                FileReader fileReader = new FileReader("./src/JSON/callOfDutyGames.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            Gson gson = new Gson();
            gameResponse = gson.fromJson(jsonReader, GameJSONResponse.class);
            System.out.println();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return gameResponse;
    }
}
