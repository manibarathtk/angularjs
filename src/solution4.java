/*
 * 1 <= t <=10
1 <= n<=40

              a*b
lcm(a,b) = ---------- 
            gcd(a,b)
 */
import java.util.Scanner;

public class solution4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 1; a0 <= t && t<11; a0++){
	            int N = in.nextInt();
	            if(N>=1 && N<=40 ){
	            	if(N==1){
	            		System.out.println(1);
	            	}else{
				            long start = System.nanoTime();
				    		//int N = 10;
				    		long p = 1;
				            for (int i = 2; i <= N; i++) {        	
				            	long a,x=p,y=i; 
				            	System.out.println("p -- "+p+" i --"+i);
				                while (x % y != 0) {
				                    a = y;
				                    y = x % y;
				                    x = a;
				                }
				                p = (p * i) / y;
				                System.out.println("p -- "+p+" i --"+i);
				            }
				            long stop = System.nanoTime();
				            //System.out.println("\tTime: " + (stop - start) / 1000 + " microseconds");
				            System.out.println(p);
				        }
	            	}
	        }
		
	}

}
