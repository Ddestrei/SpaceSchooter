package Scenes;

import java.io.IOException;

import application.GameWindow;
import application.ReadData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MenuControler { 
	public void startGame(ActionEvent e) throws NumberFormatException, IOException {
		GameWindow game = new GameWindow(e);
		Scene scene = new Scene(game);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		@Override
		public void handle(KeyEvent e) {
			switch (e.getCode()) {
			case A:
				game.player.moveA();
				break;
			case D:
				game.player.moveD();
				break;
			default:
				break;
				
				}
		}});
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
	public void exit(ActionEvent e) {
		System.exit(0);
	}
	public void stat(ActionEvent e) throws NumberFormatException, IOException {
		ReadData read = new ReadData();
		try {
			StaticScene stats = new StaticScene();
			Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scenes/Static.fxml"));
			Parent root = loader.load();
			stats.menu.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					stats.saveDataFunc();
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scenes/MenuGame.fxml"));
					try {
						Parent root = loader.load();
						primaryStage.setScene(new Scene(root));
						primaryStage.show();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			Scene scene = new Scene(stats);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}
}
