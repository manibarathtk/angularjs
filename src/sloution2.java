/*
 * The prime factors of  are  and .

What is the largest prime factor of a given number ?

Input Format

First line contains , the number of test cases. This is followed by  lines each containing an integer .

Constraints

Output Format

For each test case, display the largest prime factor of .
 */
import java.util.Scanner;

public class sloution2 {
	static long maxPrimeFact(long n){
		long pf1=0;
		while (n%2==0)
        {
			pf1=2;
            n /= 2;
        }
 
        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (long i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
               pf1=i;
                n /= i;
            }
        }
 
        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)
            pf1=n;
        
        return pf1;
	} 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        if(t>0 && t <= 10){
	        for(int a0 = 0; a0 < t; a0++){
	            long n = in.nextLong();
	            if(n>9 && n<= Math.pow(10, 12)){
	            	System.out.println(maxPrimeFact(n));
	            }
	        }
        }
    }
}
