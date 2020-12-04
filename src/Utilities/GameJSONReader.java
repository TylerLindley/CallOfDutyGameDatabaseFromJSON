package Utilities;

import JSON.GameJSONResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return gameResponse;
    }
}
