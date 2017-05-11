//hint : if the prime factors of a number is a^n , b^m , c^q then the number of divisors is (n+1)(m+1)(q+1)
import java.util.HashMap;
import java.util.Scanner;
//import java.util.stream.IntStream;

import org.omg.CORBA.TRANSACTION_MODE;

public class solution12A {
	
	static HashMap<Integer, Long> traingle = new HashMap<Integer,Long>();
	static long div(long n){
		if(n%2 == 0)
			n/=2;
		long count=0,d=1;
		while(n%2==0){
			count++;
			n/=2;
		}
		d=d*(count+1);
		int s=3;
		while(n!=1){
			count=0;
			while(n%s==0){
				count++;
				n/=s;				
			}
			d=d*(count+1);
			s+=2;
		}
		return d;
	}
	
	static void tri(int s){
		long n=1,l=div(n),r=div(n+1);
		//s=1;
		while(s<1001){
		while(l*r < s){
			n+=1;
			l=r;r=div(n+1);
		}
		//System.out.println(n*(n+1)/2);
		traingle.put(s, n*(n+1)/2);
		s++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		//IntStream.range(1, 101).mapToLong(i -> IntStream.range(1, i+1).sum()).forEach(System.out::println);
		
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();       
        if(t>0 && t <11){
        	tri(1);
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();	 
	            if(n>0 && n< 1001){
	            	if(traingle.containsKey(n)){
	            		System.out.println(traingle.get(n));
	            	}else{
	            		tri(n);
	            		System.out.println(traingle.get(n));
	            	}
	            }		        	
	        }
	    }
        in.close();
	}

}
