import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();        
            int[] sum = new int[t];
            for(int a0=0;a0<t;a0++){
            	if(t>=(int)Math.pow(10,5)){
            		break;
            	}
                int n = in.nextInt();
                if(n>0 || n<= (int)Math.pow(10,9)){
                    int three = (n-1)/3, five = (n-1)/5, fin = (n-1)/15;
                    sum[a0] = (3*(three*(three+1)/2))+(5*(five*(five+1)/2))-(15*(fin*(fin+1)/2));                    
                }                
            }
            Arrays.stream(sum).forEach(System.out::println);
        
        in.close();
    }
}
