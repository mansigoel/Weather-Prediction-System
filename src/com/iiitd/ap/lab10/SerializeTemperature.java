package com.iiitd.ap.lab10;
/**
 * @author Divam Gupta, 2014038
 * 		   Mansi Goel, 2014062
 *
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeTemperature extends Observer {
	private List<TemperatureLog> record = new ArrayList<TemperatureLog>();
	
	public SerializeTemperature(TemperatureSensor subject){
	      this.subject = subject;
	      this.subject.registerObserver(this);
	}
	
	@Override
	public  void newTemprature( TemperatureLog t){
		this.record.add(t);
		String log = t.getPlace()+","+t.getTemprature()+"\n";
		FileWriter fw;
		try {
			fw = new FileWriter("./src/data.txt", true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 bw.write(log);
			 bw.flush();
			 bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
		//System.out.println(t.getPlace());
	}

}
