package Controllers;

import JSON.GameInfo;
import JSON.GameJSONResponse;
import Utilities.GameJSONReader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListOfGamesController implements Initializable {

    @FXML
    private Label headerLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label gamesFoundLabel;

    @FXML
    private ListView<GameInfo> databaseListView;

    @FXML
    private Button gameInfoButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            GameInfo[] allGames = GameJSONReader.getGameJSON().getGames();
            databaseListView.getItems().addAll(allGames);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
