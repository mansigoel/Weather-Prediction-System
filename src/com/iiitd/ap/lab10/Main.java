package com.iiitd.ap.lab10;

/**
 * @author Divam Gupta, 2014038
 * 		   Mansi Goel, 2014062
 *
 */
class MyRunnable implements Runnable {

	 String place ;
	 TemperatureSensor t;

	 

    public MyRunnable(String place, TemperatureSensor t) {
		this.place = place;
		this.t = t;
	}



	public void run() {
        // code in the other thread, can reference "var" variable
		int i = 10;
		
		while( (i--) > 0  )
		{
			try {
			    Thread.sleep(5000);                 //1000 milliseconds is one second.
			    t.notifyAllObservers( new TemperatureLog( RandomGen.getRnd() , place ));
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}

			
		}
    }
}




public class Main {
	
	
	
	static void  startSensing( String place , TemperatureSensor t)
	{
		
	}
	
	public static void main(String[] argv)
	{
		
		TemperatureSensor t =  new TemperatureSensor();
		
		Observer o1 = new SerializeTemperature(t);
		Observer o2 = new TemperaturePredictor1(t);
		Observer o3 = new TemperaturePredictor2(t);
		Observer o4 = new GenerateStats(t);
		
		
		 MyRunnable myRunnable = new MyRunnable( "Delhi" ,  t);
	     Thread t1 = new Thread(myRunnable);
	     t1.start();
	     
	     MyRunnable myRunnable2 = new MyRunnable( "Agra" ,  t);
	     Thread t2 = new Thread(myRunnable2);
	     t2.start();
	     
	     MyRunnable myRunnable3 = new MyRunnable( "Mumbai" ,  t);
	     Thread t3 = new Thread(myRunnable3);
	     t3.start();
		
		
		
		
	
	}
	
	
	
	
	
	
	
}
