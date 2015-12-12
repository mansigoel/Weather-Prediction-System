package com.iiitd.ap.lab10;
/**
 * @author Divam Gupta, 2014038
 * 		   Mansi Goel, 2014062
 *
 */
public class RandomGen {
	
	static Double n = 35.0,a=1.0,b=1.0,c=1.0,sum,d,j,k,m=35.0;
	static int p;
	int q;
	
	public static Double getRnd()
	{
		n = m;
		a = a/(a+b+c);
		b = b/(b+c+a);
		c = c/(c+b+a);
		if(a<1)
			a*=10;
		if(b<1)
			b*=10;
		if(c<1)
			c*=10;
		String newn;
	    int af = Integer.parseInt(Double.toString(a).substring(0, 1));
	    int bf = Integer.parseInt(Double.toString(b).substring(0, 1));
	    int cf = Integer.parseInt(Double.toString(c).substring(0, 1));
	    if (af%3==0){
	    	if(bf%2==0){
	    		newn = af+"."+bf+cf;
	    	}
	    	else
	    		newn = af+"."+cf+bf;
	    }
	    else if(bf%3==0){
	    	if(cf%2==0){
	    		newn = bf+"."+cf+af;
	    	}
	    	else
	    		newn = bf+"."+af+cf;
	    }
	    else{
	    	if(af%2==0)
	    		newn = cf+"."+af+bf;
	    	else
	    		newn = cf+"."+bf+af;
	    }
	    System.out.println(newn);
	    k = Double.parseDouble(newn);
	    if(k>=5)
	    	k/=2;
	    p = k.intValue();
	    if(p%2==0)
	    	m = m+k;
	    else
	    	m = m-k;
	    
	    if(m<(-5))
	    	m = (double) 0;
	    else if(m>45)
	    	m = 35.0;
		return n;
	}

}
