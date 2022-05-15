package mobs;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FirstEnemy extends ImageView{
	final int width=10;
	final int height=10;
	double x=350;
	double y=50;
	public static int basehp=100;
	private int hp;
	public boolean endGame=false;
	Random rand = new Random();
	public static double speed=0.2;
	public FirstEnemy(){
		x=rand.nextInt(690);
		this.setImage(new Image("/resources/Enemy.jpg"));
		this.prefWidth(width);
		this.prefHeight(height);
		this.setX(x);
		this.setY(y);
		hp=basehp;
	}
	public void moveDown() {
		if(y<=690) {
			y+=speed; 
			this.setY(y);
			//System.out.println(y);
		}
		else {
			//System.out.println(y);
			endGame=true;
		}
	}
	public void reduceHP(double x) {
		hp-=x;
	}
	public double returnHP() {
		return hp;
	}
}
