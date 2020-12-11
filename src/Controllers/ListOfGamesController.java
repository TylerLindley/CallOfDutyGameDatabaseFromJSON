package Controllers;

import Models.GameInfo;
import Utilities.GameJSONReader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    /**
     * This method will change the scene to the game information view (if a game is selected (displays more in-depth information about a call of duty game))
     * other wise it will switch to the scene and let the user know to go back to the previous menu and select a game.
     * @param event
     * @throws IOException
     */
    @FXML
    private void viewGameInformation(ActionEvent event) throws IOException {
        if(databaseListView.getSelectionModel().isEmpty()) {
                Utilities.SceneChanger.changeScene(event, "/Views/gameInformationView.fxml", "Detailed Information: No Game Selected");

        }
        else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Views/gameInformationView.fxml"));
            Parent gameInformationParent = loader.load();

            Scene gameInformationScene = new Scene(gameInformationParent);

            //access the controller and get useable methods.
            GameInformationController controller = loader.getController();
            controller.initData(databaseListView.getSelectionModel().getSelectedItem());
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(gameInformationScene);
            window.setTitle("Detailed Information: " + databaseListView.getSelectionModel().getSelectedItem());
            window.show();
        }
    }

    /**
     * this method trys to read all the games from the JSON file into the list view
     * if successful it will update labels and display them
     * if unsuccessful it will print the stack trace.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            GameInfo[] allGames = GameJSONReader.getGameJSON().getGames();
            databaseListView.getItems().addAll(allGames);
            updateLabels();
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
    }

    /**
     * this method will update the labels on screen to display the correct number of games in the database.
     * and refrew the list view.
     */
    private void updateLabels() {
        gamesFoundLabel.setText("Rows Returned: " + databaseListView.getItems().size());
        databaseListView.refresh();
    }
}
