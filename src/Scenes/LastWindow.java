package Scenes;

import java.io.IOException;

import application.ReadData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LastWindow extends Group{
	int money;
	int record;
	public LastWindow(boolean newRecord) {
		readDataFunc();
		addRen();
		addImageNewRecord(newRecord);
		addImagePoints();
		addImageMoney();
		addImageYouHave();
		addImageExit();
		addImagePlay();
		addTextRecord();
		addTextMoney();
		addButtonPlay();
		addExitButton();
	}
	void addExitButton() {
		Button exit = new Button();
		exit.setPrefWidth(300);
		exit.setPrefHeight(100);
		exit.setLayoutX(390);
		exit.setLayoutY(550);
		exit.setOpacity(0);
		exit.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				try {
					System.exit(0);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		this.getChildren().add(exit);
	}
	void addButtonPlay() {
		Button play = new Button();
		play.setPrefWidth(300);
		play.setPrefHeight(100);
		play.setLayoutX(10);
		play.setLayoutY(550);
		play.setOpacity(0);
		play.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				try {
					Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scenes/MenuGame.fxml"));
					Parent root = loader.load();
					Scene scene = new Scene(root); 
					primaryStage.setScene(scene);
					primaryStage.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		this.getChildren().add(play);
	}
	void addTextRecord() {
		TextField recordText = new TextField();
		recordText.setPrefWidth(300);
		recordText.setPrefHeight(100);
		recordText.setLayoutX(10);
		recordText.setLayoutY(230);
		recordText.setText(String.valueOf(record));
		recordText.setOpacity(0.5);
		recordText.setFocusTraversable(false);
		recordText.setEditable(false);
		recordText.setAlignment(Pos.CENTER);
		recordText.setFont(new Font(30));
		this.getChildren().add(recordText);
	}
	void readDataFunc() {
		try {
			ReadData read = new ReadData();
			money=read.returnMoney();
			record=read.returnRecord();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void addTextMoney() {
		TextField moneyText = new TextField();
		moneyText.setPrefWidth(300);
		moneyText.setPrefHeight(100);
		moneyText.setLayoutX(10);
		moneyText.setLayoutY(120);
		moneyText.setText(String.valueOf(money));
		moneyText.setOpacity(0.5);
		moneyText.setFocusTraversable(false);
		moneyText.setEditable(false);
		moneyText.setAlignment(Pos.CENTER);
		moneyText.setFont(new Font(30));
		this.getChildren().add(moneyText);
	}
	void addImageExit() {
		ImageView e = new ImageView();
		e.setFitWidth(300);
		e.setFitHeight(100);
		e.setX(390);
		e.setY(550);
		e.setImage(new Image("/resources/EXIT.jpg"));
		this.getChildren().add(e);
	}
	void addImagePlay() {
		ImageView e = new ImageView();
		e.setFitWidth(300);
		e.setFitHeight(100);
		e.setX(10);
		e.setY(550);
		e.setImage(new Image("/resources/PlayAgain.jpg"));
		this.getChildren().add(e);
	}
	void addImageNewRecord(boolean record) {
		ImageView n = new ImageView();
		n.setFitWidth(100);
		n.setFitHeight(100);
		n.setX(150);
		n.setY(350);
		n.setImage(new Image("/resources/new.jpg"));
		ImageView r = new ImageView();
		r.setFitWidth(300);
		r.setFitHeight(100);
		r.setX(250);
		r.setY(350);
		r.setImage(new Image("/resources/record.jpg"));
		if(record ==true) {
			this.getChildren().add(n);
			this.getChildren().add(r);
		}
	}
	void addImagePoints() {
		ImageView e = new ImageView();
		e.setFitWidth(300);
		e.setFitHeight(100);
		e.setX(360);
		e.setY(230);
		e.setImage(new Image("/resources/Points.jpg"));
		this.getChildren().add(e);
	}
	void addImageMoney() {
		ImageView e = new ImageView();
		e.setFitWidth(300);
		e.setFitHeight(100);
		e.setX(360);
		e.setY(120);
		e.setImage(new Image("/resources/Money.jpg"));
		this.getChildren().add(e);
	}
	void addImageYouHave() {
		ImageView e = new ImageView();
		e.setFitWidth(400);
		e.setFitHeight(100);
		e.setX(150);
		e.setY(10);
		e.setImage(new Image("/resources/youEarn.jpg"));
		this.getChildren().add(e);
	}
	void addRen() {
		Rectangle e = new Rectangle();
		e.setWidth(700);
		e.setHeight(700);
		e.setX(0);
		e.setY(0);
		e.setFill(Color.BLACK);
		this.getChildren().add(e);
	}
}
