package Controllers;

import JSON.GameInfo;
import Utilities.GameJSONReader;
import Utilities.SceneChanger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    @FXML
    private void viewGameInformation(ActionEvent event) throws IOException {
        if(databaseListView.getSelectionModel().isEmpty()) {
                Utilities.SceneChanger.changeScene(event, "/Views/gameInformationView.fxml", "");

        }
        else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Views/gameInformationView.fxml"));
            Parent gameInformationParent = loader.load();

            Scene gameInformationScene = new Scene(gameInformationParent);

            //access the controller and game the method.
            GameInformationController controller = loader.getController();
            controller.initData(databaseListView.getSelectionModel().getSelectedItem());
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(gameInformationScene);
            window.show();
        }
    }

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
    }

    private void updateLabels() {
        gamesFoundLabel.setText("Rows Returned: " + databaseListView.getItems().size());
        databaseListView.refresh();
    }

    private void textFieldContent() {
    }

}
