package Controllers;

import JSON.GameInfo;
import Utilities.GameJSONReader;
import Utilities.SceneChanger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    private Label informationLabel;

    @FXML
    private Button gameInfoButton;

    private ArrayList<GameInfo> allGames;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            GameInfo[] allGames = GameJSONReader.getGameJSON().getGames();
            databaseListView.getItems().addAll(allGames);
            updateLabels();
            textFieldContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        databaseListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        databaseListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldGame, newGame) -> {
                    if (newGame != null) {
                        searchTextField.setText(newGame.toString());
                    }
                });

        /* //Configure the TextField with a listener to filter
        //the TableView
        searchTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue,
                                String oldString, String searchString) {
                //The big goal is to filter the TableView to only hold Student objects
                //that contain the search String
                ArrayList<GameInfo> filtered = new ArrayList<>();

                //loop over the students and check if they contain the search string
                for (GameInfo game : allGames)
                {
                    if (game.contains(searchString))
                        filtered.add(game);
                }

                //update the TableView with the filtered list
                databaseListView.getItems().clear();
                databaseListView.getItems().addAll(filtered);
            }
        }); */
    }
    private void updateLabels() {
        gamesFoundLabel.setText("Rows Returned: " + databaseListView.getItems().size());
        databaseListView.refresh();
    }
    private void textFieldContent() {
    //    searchTextField.setText("Call of Duty");
    }
    @FXML
    private void viewGameInformation(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "gameInformationView.fxml", "Current Cod game");
    }
}
