package Controllers;

import JSON.GameInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameInformationController implements Initializable {

    private GameInfo selectedGame;

    @FXML
    private Label gameTitleLabel;

    @FXML
    private Label publisherLabel;

    @FXML
    private Label releaseDateLabel;

    @FXML
    private Label totalRevenueLabel;

    @FXML
    private Label ratingLabel;

    @FXML
    private Label noGameSelectedLabel;

    @FXML
    private Button backButton;

    Image callOfDutyLogo = new Image("/images/CoDLogo.jfif");

    public void initData(GameInfo game) {
        if(game.getTitle().contains("Call of Duty")) {
            selectedGame = game;
            gameTitleLabel.setText(selectedGame.getTitle());
            publisherLabel.setText(selectedGame.getPublisher());
            releaseDateLabel.setText(selectedGame.getReleaseDate());
            totalRevenueLabel.setText("$" + String.valueOf(selectedGame.getGrossRevenue()));
            ratingLabel.setText(String.valueOf(selectedGame.getRating()) + "/10");
            noGameSelectedLabel.setText("");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void viewListOfGames(ActionEvent event) throws IOException {
        Utilities.SceneChanger.changeScene(event, "/Views/listOfGamesView.fxml", "List of Games");
    }
}
