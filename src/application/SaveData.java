package application;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveData {
	/*
	double costSpeed;
	int costDamage;
	double speed;
	int damage;
	int record;
	int money;
	 */
	
	FileWriter fileMoney;
	PrintWriter outputMoney;
	BufferedWriter writeMoney;
	
	FileWriter fileStats;
	PrintWriter outputStats;
	BufferedWriter writeStats;
	
	public SaveData(){
		try {
			fileMoney = new FileWriter("MoneyRecord.dat",false);
			outputMoney = new PrintWriter(fileMoney,false);
			outputMoney.flush();
			writeMoney = new BufferedWriter(fileMoney);
			
			fileStats = new FileWriter("Stats.dat",false);
			outputStats = new PrintWriter(fileStats,false);
			outputStats.flush();
			writeStats = new BufferedWriter(fileStats);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveMoneyRecord(int money,int record) throws IOException {
		//System.out.println(money+"+"+record);
		try {
			writeMoney.write(String.valueOf(record)+"\n");
			writeMoney.write(String.valueOf(money)+"\n");
			writeMoney.close();
			fileMoney.close(); 
			outputMoney.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void saveStats(int costSpeed,int costDamage,int damage,double speed) throws IOException {
		try {
			writeStats.write(String.valueOf(costSpeed)+"\n");
			writeStats.write(String.valueOf(costDamage)+"\n");
			writeStats.write(String.valueOf(speed)+"\n");
			writeStats.write(String.valueOf(damage)+"\n");
			writeStats.close();
			fileStats.close();
			outputStats.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
