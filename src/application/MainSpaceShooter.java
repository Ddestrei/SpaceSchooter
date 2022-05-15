package application;
	
import java.io.IOException;

import Scenes.LastWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class MainSpaceShooter extends Application {
	GameWindow game;
	@Override
	public void start(Stage primaryStage) throws NumberFormatException, IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scenes/MenuGame.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root); 
			primaryStage.setTitle("SpaceShooter");
			//primaryStage.getIcons().add(new Image("/Scenes/spaceShip.ico"));
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
