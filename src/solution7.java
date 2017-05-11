/*
 * 1<=t<=100
 * 1<=k<=7
 * k<=n<=1000
 */
import java.util.Scanner;

public class solution7 {
	static int p=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        if(t<=100 && t >0){
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            int k = in.nextInt();
	            String num = in.next();
	            if( k > 0 && k < 8 && n >=k && n<1001){
		            int leng= num.length();
		            int maxmu=0;
		            int start=0, end=k;
		            while(end <= leng){            	
		            	p=1;
		            	num.substring(start, end).chars().mapToObj(i-> Integer.parseInt(String.valueOf((char)i))).forEach(i-> p*=i);
		            	//System.out.println(p);
		            	if(maxmu <p){
		            		maxmu = p;
		            	}
		            	
		            	start++;end++;
		            }
		            System.out.println(maxmu);
		        }
	        }
	    }
        in.close();
   }
    
}
