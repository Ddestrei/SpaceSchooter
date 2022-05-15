package Scenes;

import java.io.IOException;

import application.SaveData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mobs.Bullet;

public class StatsController {
	int ownMoney=1000;
	int speedC=10;
	int damageC=10;
	int recordT;
	@FXML
	TextField money;
	@FXML
	TextField record;
	@FXML
	TextField damegeCost;
	@FXML
	TextField speedCost;
	@FXML
	TextField bullDamage;
	@FXML
	TextField bullSpeed;
	SaveData save;
	/*StatsController(){
		money.setFocusTraversable(false);
		record.setFocusTraversable(false);
		damegeCost.setFocusTraversable(false);
		speedCost.setFocusTraversable(false);
		bullDamage.setFocusTraversable(false);
		bullSpeed.setFocusTraversable(false);
	}*/
	public void menu(ActionEvent e) throws IOException {
		save = new SaveData();
		save.saveMoneyRecord(ownMoney,recordT);
		save.saveStats(speedC, damageC, Bullet.damage, Bullet.speed);
		Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scenes/MenuGame.fxml"));
		Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene); 
			primaryStage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void buySpeed(ActionEvent e) {
		if(ownMoney>=speedC) {
			Bullet.speed+=0.2;
			ownMoney-=speedC;
			speedC+=speedC*0.5;
			money.setText(String.valueOf(ownMoney));
			speedCost.setText(String.valueOf(speedC));
			bullSpeed.setText(String.valueOf(Bullet.speed));
		}
	}
	public void buyDamage(ActionEvent e) {
		if(ownMoney>=damageC) {
			Bullet.damage+=5;
			ownMoney-=damageC;
			damageC+=damageC*0.5;
			money.setText(String.valueOf(ownMoney));
			damegeCost.setText(String.valueOf(damageC));
			bullDamage.setText(String.valueOf(Bullet.damage));
		}
	}
}
