package com.iiitd.ap.lab10;
/**
 * @author Divam Gupta, 2014038
 * 		   Mansi Goel, 2014062
 *
 */
public abstract class Observer {
	protected TemperatureSensor subject;
	public abstract void newTemprature( TemperatureLog t);
	
}
