/*
 * Project Euler #2: sum of Even Fibonacci numbers
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class solution1 {
    
	static long  evenFibSum(long limit)
	{
	    if (limit < 2)
	        return 0l;
	 
	    // Initialize first two even prime numbers
	    // and their sum
	    long  ef1 = 0, ef2 = 2;
	    long  sum = ef1 + ef2;
	 
	    // calculating sum of even Fibonacci value
	    while (ef2 <= limit)
	    {
	        // get next even value of Fibonacci sequence
	        long ef3 = 4*ef2 + ef1;
	 
	        // If we go beyond limit, we break loop
	        if (ef3 > limit)
	            break;
	 
	        // Move to next even number and update sum
	        ef1 = ef2;
	        ef2 = ef3;
	        sum += ef2;
	    }
	 
	    return sum;
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        if(t>0 && t <= Math.pow(10, 5))
        for(int a0 = 0; a0 < t ; a0++){
            long n = in.nextLong();
            if(n>9 && n <= (4* Math.pow(10, 16))){
            	System.out.println(evenFibSum(n));
            }
        }
    }
}
