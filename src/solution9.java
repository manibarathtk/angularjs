import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class solution9 {
	
	  private static HashMap<Integer, Integer> phHashMap = new HashMap<>();
		static void pha(){
			int a = 0, b = 0, c = 0;
			for(int s=1;s<=3000;s++){
			for (a = 1; a < s / 3; a++) {
			    for (b = a; b < s / 2; b++) {
			        c = s - a - b;
			 
			        if (a * a + b * b == c * c) {
			           // System.out.println(s+" - "+a +" + "+b+" + "+c);
			            if(phHashMap.containsKey(s)){
			            	if(phHashMap.get(s)<a*b*c)
			            	phHashMap.put(s, a*b*c);
			            }else{
			            	phHashMap.put(s, a*b*c);
			            }
			        }
			    }
			 
			    
			}
			}
			
		}
	    public static void main(String[] args) {
	    	
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        if(t>0 && t <3001){
	            pha();
	            for(int a0 = 0; a0 < t; a0++){
	                int n = in.nextInt();
	                if(n > 0 && n <3001 ){
	                	if(phHashMap.containsKey(n)){
			            	System.out.println(phHashMap.get(n));
			            	
			            }else{
			            	System.out.println(-1);
			            }
	                    
	                }
	            }
	        }
	    }
}
