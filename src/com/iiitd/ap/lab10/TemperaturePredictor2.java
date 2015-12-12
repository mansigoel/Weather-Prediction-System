package com.iiitd.ap.lab10;
/**
 * @author Divam Gupta, 2014038
 * 		   Mansi Goel, 2014062
 *
 */
import java.util.ArrayList;

public class TemperaturePredictor2  extends Observer {
	private ArrayList<TemperatureLog> Drecord = new ArrayList<TemperatureLog>();
	private ArrayList<TemperatureLog> Mrecord = new ArrayList<TemperatureLog>();
	private ArrayList<TemperatureLog> Srecord = new ArrayList<TemperatureLog>();
	
	public TemperaturePredictor2(TemperatureSensor subject){
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
		ArrayList<Double> avd = new ArrayList<Double>();
		ArrayList<Double> diff1 = new ArrayList<Double>();
		double av = 0,sum=0,diff,k,r;
		int count=5,i=0,j=0;
		
		if(record.size()==1){
			k = t.getTemprature();
		}
		else{
			for(TemperatureLog p: record){
				if(count>0){
					sum+=p.getTemprature();
					count--;
				}
				else if(count==0)
				{
					av = sum/5.0;
					sum = 0;
					count = 5;
					avd.add(av);
				}
			}
			if(count>=0){
				av = sum/5.0;
				avd.add(av);
			}
			sum = 0;
			if(avd.size()==1)
			{
				k = av;
			}
			else{
				for(i=0;i<avd.size()-1;i++){
					sum+=Math.abs(avd.get(i+1)-avd.get(i));
					diff1.add((avd.get(i+1)-avd.get(i)));
				}
				av = sum/(diff1.size());
				sum = 0;
				for(i=diff1.size()-1;i>=0;i--){
					sum+=diff1.get(i);
				}
				
				if(sum>=0)
					k = t.getTemprature() + av;
				else
					k = t.getTemprature() - av;
			}
		}
		System.out.println("Custom Predicted temperature after 5 seconds at "+t.getPlace()+" is "+k);
	}

}
