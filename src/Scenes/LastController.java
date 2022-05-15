package Scenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LastController {
	public void playAgain(ActionEvent e) {
		try {
			Stage primaryStage =  (Stage)((Node)e.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scenes/MenuGame.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene); 
			primaryStage.show();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	public void exit(ActionEvent e) {
		System.exit(0);
	}
}
