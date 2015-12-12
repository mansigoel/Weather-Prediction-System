package com.iiitd.ap.lab10;
/**
 * @author Divam Gupta, 2014038
 * 		   Mansi Goel, 2014062
 *
 */
import java.io.Serializable;

public class TemperatureLog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double temprature;
	private String place;
	
	public TemperatureLog(Double temprature , String place)
	{
		this.temprature = temprature;
		this.place = place;
	}

	public Double getTemprature() {
		return temprature;
	}



	public String getPlace() {
		return place;
	}


	
	
}
