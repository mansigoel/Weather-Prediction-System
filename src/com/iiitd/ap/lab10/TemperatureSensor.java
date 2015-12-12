package com.iiitd.ap.lab10;
/**
 * @author Divam Gupta, 2014038
 * 		   Mansi Goel, 2014062
 *
 */
import java.util.*;

public class TemperatureSensor {
	 private List<Observer> observers = new ArrayList<Observer>();
	 
	 public void registerObserver(Observer observer){
	      observers.add(observer);		
	 }
	 
	 public void unregisterObserver(Observer observer){
	     // observers.add(observer);		
	 }
	 
	 public void notifyAllObservers( TemperatureLog t  ){
	      for (Observer observer : observers) {
	         observer.newTemprature(t);
	      }
	} 
	 
	 
}
