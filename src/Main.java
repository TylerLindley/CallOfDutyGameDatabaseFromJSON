import JSON.GameInfo;
import Utilities.GameJSONReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static Utilities.GameJSONReader.getGameJSON;

public class Main extends Application {
    Image callOfDutyLogo = new Image("/images/CoDLogo.jfif");

    public static void main(String[] args) {
        getGameJSON();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/listOfGamesView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.getIcons().add(callOfDutyLogo);
        stage.setTitle("Call of Duty: Game Database");
        stage.show();
    }
}