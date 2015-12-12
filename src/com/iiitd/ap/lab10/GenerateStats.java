package com.iiitd.ap.lab10;
/**
 * @author Divam Gupta, 2014038
 * 		   Mansi Goel, 2014062
 *
 */
import java.util.ArrayList;
import java.util.Collections;

public class GenerateStats  extends Observer{
	private ArrayList<TemperatureLog> Drecord = new ArrayList<TemperatureLog>();
	private ArrayList<TemperatureLog> Mrecord = new ArrayList<TemperatureLog>();
	private ArrayList<TemperatureLog> Srecord = new ArrayList<TemperatureLog>();
	
	public GenerateStats(TemperatureSensor subject){
	      this.subject = subject;
	      this.subject.registerObserver(this);
	}
	
	
	@Override
	public  void newTemprature( TemperatureLog t){
		if(t.getPlace().equals("Delhi"))
		{
			statsgen(t,Drecord);
		}
		else if(t.getPlace().equals("Mumbai"))
		{
			statsgen(t,Mrecord);
		}
		else
		{
			statsgen(t,Srecord);
		}
	}
	
	public void statsgen(TemperatureLog t, ArrayList<TemperatureLog> record)
	{
		record.add(t);
		double av,sum=0,median,max,min;
		ArrayList<Double> array = new ArrayList<Double>();
		if(record.size()>100){
			record.remove(0);
		}
		max = record.get(0).getTemprature();
		min = record.get(0).getTemprature();
		
		for(TemperatureLog p: record){
			if(p.getTemprature()>max){
				max = p.getTemprature();
			}
			if(p.getTemprature()<min){
				min = p.getTemprature();
			}
			array.add(p.getTemprature());
			sum += p.getTemprature();
		}
		av = sum/(record.size());
		
		Collections.sort(array);
		int middle = (array.size())/2;
		if(middle==0){
			median = array.get(0);
		}
		else{
			if (middle%2 == 1) {
			       median = array.get(middle);
			} else {
			      median = (array.get(middle-1) + array.get(middle)) / 2.0;
			}
		}
	    
	    System.out.println("Stats for "+t.getPlace());
		System.out.println("Mean Temperature: "+av);
		System.out.println("Median Temperature: "+median);
		System.out.println("Maximum Temperature "+max);
		System.out.println("Minimum Temperature: "+min);
		System.out.println("\n");
	}
	

}
