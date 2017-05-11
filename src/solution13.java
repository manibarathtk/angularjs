import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class solution13 {
static String s="0";
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();       
        if(t>0 && t <1000){	
        	IntStream.range(0, 49).forEach(i-> s+="0");
        	BigInteger sum = BigInteger.ZERO;
        	//System.out.println(sum);
        	for(int a0 = 0; a0 < t; a0++){
        		String num = in.nextLine();
        		if(num.length()>0 && num.length()<51)
        		sum = sum.add(new BigInteger(num));
        	}
        	String sumStr = sum.toString();
        	if(sumStr.length() >= 50){
        		System.out.println(sumStr.substring(0, 10));
        	}else{        		
        		
        		StringBuilder stB=new StringBuilder(s);
        		stB.append(sumStr);
        		stB = stB.reverse();        		
        		System.out.println(new StringBuilder(stB.substring(0, 9)).reverse());
        	
        	}
	    }        
        in.close();
	}

}
