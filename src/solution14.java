import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class solution14 {

	static TreeMap<Long, Long> coll = new TreeMap<Long, Long>();

	
	public static long collat(long n){
		long s = 0;
		if(coll.containsKey(n)){
			return coll.get(n);
		}else{
			if(n%2 == 0){
				s +=1; 
                s+=collat(n/2);
			}else{
				s +=1; 
                s+=collat((3*n)+1);
			}
			coll.put(n, s);
			
			return s;
		}
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		coll.put(1l, 0l);
        int t = in.nextInt();       
        if(t<10001 && t>0){
        	while(t>0){
        	int n = in.nextInt();
        	if(n>0 && n<5000001){
        		long som = collat(n), max = n;
        		for(int i =1;i<n;i++){
        			long isom = collat(i);
        			if(som < isom){
        				som = isom;
        				max = i;
        			}if(som == isom && max <i){
        				max=i;
        			}
        		}
                System.out.println(max);
                //System.out.println(coll);
        	}
        	t--;
        	}
        }
	   
        in.close();
	}

}
