import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;
import java.util.stream.IntStream;

public class test12 {
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
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        ESieve((int)Math.pow(10, 6));
	        if(t>0 && t <=Math.pow(10, 4)){	        	
		        for(int a0 = 0; a0 < t; a0++){
		            int n = in.nextInt();	 
		            if(n>0 && n<= Math.pow(10, 6)){
		            	System.out.println(Arrays.stream(primNum).filter(i -> i<=n).sum());
		            }		        	
		        }
		    }
	 }
	
}
