package Scenes;

import java.io.IOException;

import application.ReadData;
import application.SaveData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class StaticScene extends Group{
	AnchorPane main;
	int record=0;
	int money=1000;
	double speed=1.0;
	int damage=10;
	int costSpeed=10;
	int costDamage=10;
	Button menu = new Button();
	TextField moneyText;
	TextField recordText;
	TextField speedText;
	TextField damageText;
	TextField speedCostText;
	TextField damageCostText;
	
	public StaticScene(){
		readDataFunc();
		addRen();
		addImageViewMoney();
		addImageViewRecord();
		addImageViewCost();
		addImageViewShop();
		addImageViewBulletDamage();
		addImageViewBulletSpeed();
		addImageViewMenu();
		addImageViewBuyFirst();
		addImageViewBuySecond();
		addtextFiledMoney();
		addtextFiledRecord();
		addtextFiledDamage();
		addtextFiledCostDamage();
		addtextFiledSpeed();
		addtextFiledCostSpeed();
		addButtonMenu();
		addBuySpeedButton();
		addBuyDamageButton();
	}
	void addBuyDamageButton() {
		Button e = new Button();
		e.setPrefWidth(100);
		e.setPrefHeight(100);
		e.setLayoutX(430);
		e.setLayoutY(340);
		e.setOpacity(0);
		e.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(money>=costDamage) {
					damage+=10;
					money-=costDamage;
					costDamage=costDamage*2;
					damageText.setText(String.valueOf(damage));
					moneyText.setText(String.valueOf(money));
					damageCostText.setText(String.valueOf(costDamage));
				}
			}
		});
		this.getChildren().add(e);
	}
	void addBuySpeedButton() {
		Button e = new Button();
		e.setPrefWidth(100);
		e.setPrefHeight(100);
		e.setLayoutX(430);
		e.setLayoutY(450);
		e.setOpacity(0);
		e.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(money>=costSpeed) {
					speed+=0.2;
					money-=costSpeed;
					costSpeed=costSpeed*2;
					speedText.setText(String.valueOf(speed));
					moneyText.setText(String.valueOf(money));
					speedCostText.setText(String.valueOf(costSpeed));
				}
			}
		});
		this.getChildren().add(e);
	}
	void addButtonMenu() {
		menu.setPrefWidth(300);
		menu.setPrefHeight(100);
		menu.setLayoutX(200);
		menu.setLayoutY(570);
		menu.setOpacity(0);
		this.getChildren().add(menu);
	}
	void readDataFunc() {
		try {
			ReadData read = new ReadData();
			record = read.returnRecord();
			money = read.returnMoney();
			speed = read.returnSpeed();
			damage = read.returnDamage();
			costSpeed = read.returnCostSpeed();
			costDamage = read.returnCostDamage();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void saveDataFunc() {
		SaveData save = new SaveData();
		try {
			save.saveMoneyRecord(money, record);
			save.saveStats(costSpeed, costDamage, damage, speed);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void addtextFiledMoney() {
		moneyText = new TextField();
		moneyText.setPrefWidth(300);
		moneyText.setPrefHeight(100);
		moneyText.setLayoutX(315);
		moneyText.setLayoutY(120);
		moneyText.setText(String.valueOf(money));
		moneyText.setOpacity(0.5);
		moneyText.setFocusTraversable(false);
		moneyText.setAlignment(Pos.CENTER);
		moneyText.setEditable(false);
		moneyText.setFont(new Font(30));
		this.getChildren().add(moneyText);
	}
	void addtextFiledRecord() {
		recordText = new TextField();
		recordText.setPrefWidth(300);
		recordText.setPrefHeight(100);
		recordText.setLayoutX(315);
		recordText.setLayoutY(10);
		recordText.setText(String.valueOf(record));
		recordText.setOpacity(0.5);
		recordText.setFocusTraversable(false);
		recordText.setEditable(false);
		recordText.setAlignment(Pos.CENTER);
		recordText.setFont(new Font(30));
		this.getChildren().add(recordText);
	}
	void addtextFiledDamage() {
		damageText = new TextField();
		damageText.setPrefWidth(100);
		damageText.setPrefHeight(100);
		damageText.setLayoutX(320);
		damageText.setLayoutY(340);
		damageText.setText(String.valueOf(damage));
		damageText.setOpacity(0.5);
		damageText.setFocusTraversable(false);
		damageText.setEditable(false);
		damageText.setAlignment(Pos.CENTER);
		damageText.setFont(new Font(30));
		this.getChildren().add(damageText);
	}
	void addtextFiledCostDamage() {
		damageCostText = new TextField();
		damageCostText.setPrefWidth(100);
		damageCostText.setPrefHeight(100);
		damageCostText.setLayoutX(545);
		damageCostText.setLayoutY(340);
		damageCostText.setText(String.valueOf(costDamage));
		damageCostText.setOpacity(0.5);
		damageCostText.setFocusTraversable(false);
		damageText.setEditable(false);
		damageCostText.setAlignment(Pos.CENTER);
		damageCostText.setFont(new Font(30));
		this.getChildren().add(damageCostText);
	}
	void addtextFiledSpeed() {
		speedText = new TextField();
		speedText.setPrefWidth(100);
		speedText.setPrefHeight(100);
		speedText.setLayoutX(320);
		speedText.setLayoutY(450);
		speedText.setText(String.valueOf(speed));
		speedText.setOpacity(0.5);
		speedText.setFocusTraversable(false);
		speedText.setEditable(false);
		speedText.setAlignment(Pos.CENTER);
		speedText.setFont(new Font(30));
		this.getChildren().add(speedText);
	}
	void addtextFiledCostSpeed() {
		speedCostText = new TextField();
		speedCostText.setPrefWidth(100);
		speedCostText.setPrefHeight(100);
		speedCostText.setLayoutX(545);
		speedCostText.setLayoutY(450);
		speedCostText.setText(String.valueOf(costSpeed));
		speedCostText.setOpacity(0.5);
		speedCostText.setFocusTraversable(false);
		speedCostText.setAlignment(Pos.CENTER);
		speedCostText.setEditable(false);
		speedCostText.setFont(new Font(30));
		this.getChildren().add(speedCostText);
	}
	void addRen() {

		Rectangle mainRen = new Rectangle();
		mainRen.setWidth(700);
		mainRen.setHeight(700);
		mainRen.setX(0);
		mainRen.setY(0);
		mainRen.setFill(Color.BLACK);
		this.getChildren().add(mainRen);
	}
	void addImageViewMoney() {
		ImageView e = new ImageView();
		e.setFitWidth(300);
		e.setFitHeight(100);
		e.setX(10);
		e.setY(120);
		e.setImage(new Image("/resources/Money.jpg"));
		this.getChildren().add(e);
	}
	void addImageViewRecord() {
		ImageView e = new ImageView();
		e.setFitWidth(300);
		e.setFitHeight(100);
		e.setX(10);
		e.setY(10);
		e.setImage(new Image("/resources/record.jpg"));
		this.getChildren().add(e);
	}
	void addImageViewCost() {
		ImageView e = new ImageView();
		e.setFitWidth(100);
		e.setFitHeight(100);
		e.setX(545);
		e.setY(230);
		e.setImage(new Image("/resources/cost.jpg"));
		this.getChildren().add(e);
	}
	void addImageViewShop() {
		ImageView e = new ImageView();	
		e.setFitWidth(300);
		e.setFitHeight(100);
		e.setX(200);
		e.setY(230);
		e.setImage(new Image("/resources/shop.jpg"));
		this.getChildren().add(e);
	}
	void addImageViewBulletDamage() {
		ImageView e = new ImageView();	
		e.setFitWidth(300);
		e.setFitHeight(100);
		e.setX(10);
		e.setY(340);
		e.setImage(new Image("/resources/Bulltesdamege.jpg"));
		this.getChildren().add(e);
	}
	void addImageViewBulletSpeed() {
		ImageView e = new ImageView();	
		e.setFitWidth(300);
		e.setFitHeight(100);
		e.setX(10);
		e.setY(450);
		e.setImage(new Image("/resources/bulltesSpeed.jpg"));
		this.getChildren().add(e);
	}
	void addImageViewMenu() {
		ImageView e = new ImageView();
		e.setFitWidth(300);
		e.setFitHeight(100);
		e.setX(200);
		e.setY(570);
		e.setImage(new Image("/resources/Menu.jpg"));
		this.getChildren().add(e);
	}
	void addImageViewBuyFirst() {
		ImageView e = new ImageView();	
		e.setFitWidth(100);
		e.setFitHeight(100);
		e.setX(430);
		e.setY(340);
		e.setImage(new Image("/resources/buy.jpg"));
		this.getChildren().add(e);
	}
	void addImageViewBuySecond() {
		ImageView e = new ImageView();	
		e.setFitWidth(100);
		e.setFitHeight(100);
		e.setX(430);
		e.setY(450);
		e.setImage(new Image("/resources/buy.jpg"));
		this.getChildren().add(e);
	}
}
