import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CandidateCode {
	/*
	 * Complete the function below.
	 */
	public static HashMap<String, Boolean> mem = new HashMap<>();

	public static int appearanceCount(int input1,int input2,String input3,String input4)
	    {
		//Write code here
		 int count=0;
		 if(input1 >0 && input1 < 3001 && input2 >= input1 && input2 < 3000001){
			 if(input3.length() == input1 && input4.length() == input2){
				 mem = new HashMap<>();
				 char[] tem3 = input3.toCharArray();				
				 Arrays.sort(tem3);
				 input3=new String(tem3);				 
				 for(;input2>=input1;input2--){
					 String tem4 = input4.substring(input2-input1, input2);	
					 if(mem.containsKey(tem4)){
						 if(mem.get(tem4)){
							 count++;
						 }
					 }else{
						 tem3 = tem4.toCharArray();
						 Arrays.sort(tem3);
						 tem4=new String(tem3);
						 if(tem4.equals(input3)){
							count++;
						 	mem.put(input4.substring(input2-input1, input2), true);
						 } else {
							 mem.put(input4.substring(input2-input1, input2), false);
						 }
					 }	
				 }
			 }
		 }
		 mem.clear();
		 return count;
		 
	    }

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int output = 0;
		int ip1 = Integer.parseInt(in.nextLine().trim());
		int ip2 = Integer.parseInt(in.nextLine().trim());
		String ip3 = in.nextLine().trim();
		String ip4 = in.nextLine().trim();
		output = appearanceCount(ip1, ip2, ip3, ip4);
		System.out.println(String.valueOf(output));
	}
}