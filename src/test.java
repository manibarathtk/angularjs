import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author manibarath.k
 *
 */
public class test {
	
	private IntStream somest(int max){
		IntStream in;
		int one=1,two=2;		
		for(;;){
			
		}		
	}
	static int getSqu(int x){
		System.out.println(x+" -- "+(int) Math.sqrt(x));
		return (int) Math.pow(x,2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(IntStream.range(1, 5)  
	    .filter(i -> i % 2 == 0).sum()
	    );
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();  
		int[] sum = IntStream.range(1, t).limit(50).filter(i -> i%2 == 0).toArray();
		//System.out.println(sum);	
		//Arrays.stream(sum).forEach(System.out::println);
       /* int t1 = in.nextInt();
        for(int a0 = 0; a0 < t1; a0++){
            long n = in.nextLong();
        }*/
		int sq[]=IntStream.range(1, t).map(test::getSqu).toArray();
		int sqm=getSqu(IntStream.range(1, t+1).sum()) - IntStream.range(1, t+1).map(test::getSqu).sum();
		System.out.println(sqm);
		Arrays.stream(sq).forEach(System.out::println);
		
	}

}
	