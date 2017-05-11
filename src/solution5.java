import java.util.Scanner;
import java.util.stream.IntStream;

public class solution5 {
	static int getSqu(int x){
		System.out.println(x+" -- "+(int) Math.pow(x,2));
		return (int) Math.pow(x,2);
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        if(t>=1 && t<= Math.pow(10,4)){
            for(int a0 = 0; a0 < t; a0++){
                int n = in.nextInt();
                 if(n>=1 && n<= Math.pow(10,4)){
                	 //System.out.println(n);
                	 int sqm=getSqu(IntStream.range(1, n+1).sum()) - IntStream.range(1, n+1).map(solution5::getSqu).sum();
             		System.out.println(sqm);
                     //System.out.println(getSqu(IntStream.range(1, t+1).sum()) - IntStream.range(1, t+1).map(solution5::getSqu).sum());
                 }
            }
        }
    
    }
}
