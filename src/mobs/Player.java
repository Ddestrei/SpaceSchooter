package mobs;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends ImageView{
	double x=350;
	double y=650;
	final int width=20;
	final int length=20;
	public Player(){
		this.setImage(new Image("/resources/spaceShip.jpg"));
		this.prefWidth(10);
		this.prefHeight(10);
		this.setX(x);
		this.setY(y);
	}
	public void moveA() {
		if(x>=10) {
			x-=10;
			this.setX(x);
		}
	}	
	public void moveD() {
		if (x<=680) {
			x+=10;
			this.setX(x);
		}
	}
}
