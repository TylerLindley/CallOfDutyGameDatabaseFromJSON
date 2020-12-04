package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ListOfGamesController {

    @FXML
    private Label headerLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label gamesFoundLabel;

    @FXML
    private ListView<?> databaseListView;

    @FXML
    private Button gameInfoButton;

}
