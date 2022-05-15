package mobs;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bullet extends ImageView {
	final int width=5;
	final int height=5;
	double x;
	double y=650;
	final int baseDamage=20;
	static public int damage=20;
	static public double speed=1;
	boolean canMove=true;
	public Bullet(double x){
		this.x=x;
		this.setX(x);
		this.setY(y);
		this.prefWidth(width);
		this.prefHeight(height);
		this.setImage(new Image("/resources/bullet.jpg"));
	}
	public void moveUp() {
		if(y>0) {
			y-=speed;
			this.setY(y);
		}
		else {
			canMove=false;
		}
	}
}
