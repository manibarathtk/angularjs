//hint : if the prime factors of a number is a^n , b^m , c^q then the number of divisors is (n+1)(m+1)(q+1)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;
//import java.util.stream.IntStream;

public class solution12 {
	static int[] primNum = null;
	public static void ESieve(int upperLimit) {
	    int sieveBound = (int)(upperLimit - 1) / 2;
	    int upperSqrt = ((int)Math.sqrt(upperLimit) - 1) / 2;
	 
	    BitSet PrimeBits = new BitSet(sieveBound + 1);
	   PrimeBits.set(0, sieveBound + 1);
	 
	    for (int i = 1; i <= upperSqrt; i++) {
	        if (PrimeBits.get(i)) {
	            for (int j = i * 2 * (i + 1); j <= sieveBound; j += 2 * i + 1) {
	                PrimeBits.set(j, false);
	            }
	        }
	    }
	 
	    ArrayList<Integer> numbers = new ArrayList<Integer>((int)(upperLimit / (Math.log(upperLimit) - 1.08366)));
	    numbers.add(2);
	 
	    for (int i = 1; i <= sieveBound; i++) {
	        if (PrimeBits.get(i)) {
	            numbers.add(2 * i + 1);
	        }
	    }
	    primNum = numbers.stream().mapToInt(i -> i).toArray();
	   
	}	
	static void tri(int s){
		for(int i=2;true;i++){
			int MaxDiv=0;
			int n=0;
			long sum =i*(i+1)/2;
			long sumC=sum;
			for(int j=0;primNum[j]<=sum;){
				if(sumC%primNum[j]==0){
					n++;
					sumC /= primNum[j];					
				}else{
					j++;
					if(MaxDiv !=0){
						MaxDiv *=(n+1);
						n=0;
					}else{
						MaxDiv = n+1;
						n=0;
					}
				}
			}			
			if((MaxDiv-1)>=s){
				System.out.println(sum);
				break;
			}
            
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		//IntStream.range(1, 101).mapToLong(i -> IntStream.range(1, i+1).sum()).forEach(System.out::println);
		
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();       
        if(t>0 && t <11){
        	ESieve(100000000);
        	System.out.println(primNum.length);
        	//Arrays.stream(primNum).forEach(System.out::println);
        	//som.put(1, 1);
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();	 
	            if(n>0 && n< 1001){
	            	tri(n);
	            }		        	
	        }
	    }
        in.close();
	}

}
