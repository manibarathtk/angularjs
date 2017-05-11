import java.util.Scanner;
import java.util.stream.LongStream;

public class solution171 {
	public static long sumofsqu(long s){
		String s1=s+"";
		System.out.println(s1);
		try {
			Double n = Math.sqrt(s1.trim().chars().mapToDouble(i -> Math.pow(Integer.parseInt(String.valueOf((char)i)),2)).sum());
			System.out.println(n.floatValue());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return s;
	}
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        if(t>=1 && t<= Math.pow(10,100)){
        	System.out.println(t);
           // LongStream.range(1, t+1).map(i -> (i+"").chars().map(p-> Integer.parseInt(String.valueOf((char)p))).sum());
        	 LongStream.range(1, t+1).map(solution171::sumofsqu);
        }
    
    }
}
