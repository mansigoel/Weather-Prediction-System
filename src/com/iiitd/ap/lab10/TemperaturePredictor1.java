package com.iiitd.ap.lab10;
/**
 * @author Divam Gupta, 2014038
 * 		   Mansi Goel, 2014062
 *
 */
import java.util.ArrayList;

public class TemperaturePredictor1 extends Observer {
	private ArrayList<TemperatureLog> Drecord = new ArrayList<TemperatureLog>();
	private ArrayList<TemperatureLog> Mrecord = new ArrayList<TemperatureLog>();
	private ArrayList<TemperatureLog> Srecord = new ArrayList<TemperatureLog>();
	
	public TemperaturePredictor1(TemperatureSensor subject){
	      this.subject = subject;
	      this.subject.registerObserver(this);
	}
	
	
	@Override
	public  void newTemprature( TemperatureLog t){
		if(t.getPlace().equals("Delhi"))
		{
			predictor(t,Drecord);
		}
		else if(t.getPlace().equals("Mumbai"))
		{
			predictor(t,Mrecord);
		}
		else
		{
			predictor(t,Srecord);
		}
	}
	
	public void predictor(TemperatureLog t, ArrayList<TemperatureLog> record)
	{
		record.add(t);
		double av,sum=0;
		if(record.size()>5){
			record.remove(0);
		}
		for(TemperatureLog p: record){
			sum += p.getTemprature();
		}
		av = sum/(record.size());
		System.out.println("Average Predicted temperature after 5 seconds at "+t.getPlace()+" is "+av);
	}
	

}
