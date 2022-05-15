package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Scenes.LastWindow;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import mobs.Bullet;
import mobs.FirstEnemy;
import mobs.Player;

public class GameWindow extends Group{ 
	int width=700;
	int height=700;
	Rectangle mainRent;
	public Player player;
	FirstEnemy first;
	ArrayList<FirstEnemy> enemys;
	ArrayList<Bullet> bullets;
	int tiksEnemy=0;
	int tiksBullet=0;
	boolean endGame=false;
	int point=0;
	int stage=0;
	TextField points;
	TextField stages;
	int frequencyEnemy=200;
	Stage stageLast;
	int speedCost;
	int damageCost;
	double speed;
	int damage;
	int money;
	int record;
	public GameWindow(ActionEvent e) throws NumberFormatException, IOException{
		ReadData read = new ReadData();
		Bullet.speed = read.returnSpeed();
		Bullet.damage = read.returnDamage(); 
		speed=read.returnSpeed();
		damage=read.returnDamage(); 
		speedCost=read.returnCostSpeed();
		damageCost=read.returnCostDamage();
		money=read.returnMoney();
		record=read.returnRecord();
		//System.out.println(read.returnSpeed());
		stageLast =(Stage)((Node)e.getSource()).getScene().getWindow();
		player = new Player();
		first = new FirstEnemy();
		enemys = new ArrayList<FirstEnemy>();
		bullets = new ArrayList<Bullet>();
		enemys.add(first);
		setMainRent();
		this.getChildren().add(player);
		this.getChildren().add(first);
		setPointFiled();
		setStageFiled();
		Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(0.01), ev -> {
			if(endGame==false) {
				checkColision();
				checkBolletsEnd();
				addMobs();
				checkEnd();
				moveMobs();
				if(point==50) {
					stage+=1;
					stages.setText(String.valueOf(stage));
					point=0;
					points.setText(String.valueOf(point));
					frequencyEnemy*=0.8;
					FirstEnemy.speed*=1.5;
					FirstEnemy.basehp+=10;
				}
			}
		}));
		timeLine.setCycleCount(Animation.INDEFINITE);
		timeLine.play();
	}
	void setPointFiled() {
		points = new TextField();
		points.setText(String.valueOf(point));
		points.setPrefHeight(50);
		points.setPrefWidth(100);
		points.setFont(new Font(20));
		points.setLayoutX(0);
		points.setLayoutY(0);
		points.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		points.setFocusTraversable(false);
		points.setAlignment(Pos.CENTER);
		points.setStyle("-fx-text-fill: yellow;");
		this.getChildren().add(points);
	}
	void setStageFiled() {
		stages = new TextField();
		stages.setText(String.valueOf(stage));
		stages.setPrefHeight(50);
		stages.setPrefWidth(100);
		stages.setFont(new Font(20));
		stages.setLayoutX(600);
		stages.setLayoutY(0);
		stages.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		stages.setFocusTraversable(false);
		stages.setAlignment(Pos.CENTER);
		stages.setStyle("-fx-text-fill: yellow;");
		this.getChildren().add(stages);
	}
	void setMainRent() {
		mainRent = new Rectangle();
		mainRent.setWidth(width);
		mainRent.setHeight(height);
		mainRent.setFill(Color.BLACK);
		this.getChildren().add(mainRent);
	}
	void checkBolletsEnd() {
		for (int i=0;i<bullets.size();i++) {
			if(bullets.get(i).getY()<=0) {
				this.getChildren().remove(bullets.get(i));
				bullets.remove(i);
			}
		}
	}
	void moveMobs() {
		if(endGame==false) {
			for(int i=0;i<enemys.size();i++) {
				enemys.get(i).moveDown();
			}
		}
		else {
			try {
				boolean recordGame=false;
				SaveData save = new SaveData();
				if(((stage*50)+point)>record) {
					save.saveMoneyRecord(money+(stage*50)+point,(stage*50)+point);
					recordGame=true;
				}
				else {
					save.saveMoneyRecord((money+(stage*50)+point),record);
				}
				//System.out.println(recordGame);
				LastWindow last = new LastWindow(recordGame);
				save.saveStats(speedCost,damageCost,damage,speed);
				Stage primarySatge = stageLast;
				Scene scene = new Scene(last);
				primarySatge.setScene(scene);
				primarySatge.show();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		for (int i=0;i<bullets.size();i++) {
			bullets.get(i).moveUp();
		}
	}
	void checkEnd() {
		for(int i=0;i<enemys.size();i++) {
			if(enemys.get(i).endGame==true) {
				endGame=true;
			}
		}
	}
	void addMobs() {
		if(tiksEnemy==frequencyEnemy) {
			tiksEnemy=0;
			addEnemy();
		}
		else {
			tiksEnemy+=1;
		}
		if(tiksBullet==10) {
			addBullet();
			tiksBullet=0;
		}
		else {
			tiksBullet+=1;
		}
	}
	void checkColision() {
		ArrayList<Integer> bulletsDelet = new ArrayList<Integer>();
		ArrayList<Integer> enemysDelet = new ArrayList<Integer>();
		for (int i=0;i<enemys.size();i++) {
			FirstEnemy e = enemys.get(i);
			for (int j=0;j<bullets.size();j++) {
				Bullet b = bullets.get(j);
				double bulletX=b.getX();
				double enemyX=e.getX();
				if(bulletX>enemyX-5&&bulletX<enemyX+10) {
					double bulletY=b.getY();
					double enemyY=e.getY();
					if(bulletY<enemyY+10&&bulletY>enemyY) {
						bulletsDelet.add(j);
						enemysDelet.add(i);
					}
				}
			}
		}
		for (int i=0;i<bulletsDelet.size();i++) {
			this.getChildren().remove(bullets.get(bulletsDelet.get(i)));
			bullets.remove(bullets.get(bulletsDelet.get(i)));
		}
		for (int i=0;i<enemysDelet.size();i++) {
			enemys.get(enemysDelet.get(i)).reduceHP(Bullet.damage);
			if(enemys.get(enemysDelet.get(i)).returnHP()<=0) {
				this.getChildren().remove(enemys.get(enemysDelet.get(i)));
				enemys.remove(enemys.get(enemysDelet.get(i)));
				//System.out.println(enemys.size());
				point+=1;
				points.setText(String.valueOf(point));
			}
		}
	}
	void addEnemy() {
		FirstEnemy e = new FirstEnemy(); 
		enemys.add(e);
		this.getChildren().add(e);
	}
	void addBullet() {
		Bullet e = new Bullet(player.getX()+2.5); 
		this.getChildren().add(e);
		bullets.add(e);
	}
}
