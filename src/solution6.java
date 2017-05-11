import java.util.ArrayList;
import java.util.Scanner;

public class solution6 {
 static ArrayList<Integer> primes =null;
	static void getPrimes(){
		int upperLimit = 10001;
		int counter = 3;
		Boolean isPrime;
		int j;
		primes= new ArrayList<Integer>();// primes = new List<int>();
		 
		primes.add(2);
		primes.add(3);
		 
		while(primes.toArray().length < upperLimit){
		    counter += 2;
		    j = 0;
		    isPrime = true;
		    while (primes.get(j)*primes.get(j) <= counter) {
		        if (counter % primes.get(j) == 0) {
		            isPrime = false;
		            break;
		        }
		        j++;
		    }
		    if (isPrime) {
		        primes.add(counter);
		    }
		}
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        if(t<=1000 && t>=1){
        	getPrimes();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            if(n>0 && n<10001){
	            	
	            	System.out.println(primes.get(n-1));
	            }
	        }
        }
  
	
}
}
