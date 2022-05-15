package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {
	int costSpeed;
	int costDamage;
	double speed;
	int damage;
	int record;
	int money;
	File fileStats;
	FileReader fileReaderStats;
	BufferedReader bufferStats;	
	
	File fileMoney;
	FileReader fileReaderMoney;
	BufferedReader bufferMoney;	
	
	public ReadData() throws NumberFormatException, IOException{
		try {
			fileMoney = new File("MoneyRecord.dat"); 
			if(fileMoney.exists()==true) {
				fileReaderMoney = new FileReader(fileMoney);
				bufferMoney = new BufferedReader(fileReaderMoney);
				String first=bufferMoney.readLine();
				if(first!=null) {
					//System.out.println("File isnot empty");
					record = Integer.valueOf(first);
					//System.out.println(record);
					money = Integer.valueOf(bufferMoney.readLine());
					//System.out.println(money);
				}
				else {
					record=0;
					money=100;
				}
				bufferMoney.close();
				fileReaderMoney.close();
			}
			else {
				//System.out.println("File isnot exist");
				record = 0;
				money=0;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileStats = new File("Stats.dat");
			if(fileStats.exists()==true) {
				fileReaderStats = new FileReader(fileStats);
				bufferStats = new BufferedReader(fileReaderStats);
				String first=bufferStats.readLine();
				if(first!=null) {
					costSpeed = Integer.valueOf(first);
					//System.out.println(costSpeed);
					costDamage = Integer.valueOf(bufferStats.readLine());
					//System.out.println(costDamage);
					speed = Double.valueOf(bufferStats.readLine());
					//System.out.println(speed);
					damage = Integer.valueOf(bufferStats.readLine());
					//System.out.println(damage);
				}
				else {
					//System.out.println("File isnot exist");
					costSpeed=10;
					costDamage = 10;
					speed = 1.0;
					damage = 10;
				}
				bufferStats.close();
				fileReaderStats.close();
			}
			else {
				costSpeed = 10;
				speed =1;
				costDamage =10;
				damage=10;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int returnCostSpeed() {
		return costSpeed;
	}
	public int returnCostDamage() {
		return costDamage;
	}
	public double returnSpeed() {
		return speed;
	}
	public int returnDamage() {
		return damage;
	}
	public int returnMoney() {
		return money;
	}
	public int returnRecord() {
		return record;
	}
}
