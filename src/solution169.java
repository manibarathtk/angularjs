import java.util.HashMap;
import java.util.Scanner;

public class solution169 {
	

	static HashMap<HashMap<Integer,Integer>,Integer> cache =  new HashMap<HashMap<Integer,Integer>,Integer>();

	static /* 
	The log2() and power() functions remain unchanged and so are omitted for brevity
	 */
	 
	 int log2(int n)
	{
	    int ret = 0;
	     int s=n;
	    while ((n = n>>1) != 0) 
	    {
	        
	        ++ret;      
	    }
	     
	    return ret;
	}
	int power(int x,int y)
	{
	    int ret=1,i=0;
	    while(i<y)
	    {
	        ret*=x;
	        i++;
	    }
	    return ret;
	}

	static int getcount(int m,int k)
	{
		System.out.println(m +" -- "+k);
		System.out.println(cache);
		HashMap<Integer,Integer> t1 = new HashMap<Integer,Integer>();
		t1.put(m, k);
	   if(cache.keySet().contains(t1)){
		   System.out.println(t1);
		   return cache.get(t1);
	   }	    
	    int count = -1;
	    if(m==0) {
	       count = 1;
	    } else if (k<0) {
	        count = 0;
	    } else if (k==0) {
	       count = 1;
	    } else if(m>=Math.pow(2,k)) {
	        count += getcount(m-(int)Math.pow(2,k),k);
	    } else {
	        count += getcount(m,k-1);
	    }
	    cache.put(t1,count);
	    
	    
	    return count;
	}
static int sum=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        if(t>0 && t <3001){
        	int k=log2(t);
	        getcount(t,k);
	        System.out.println(cache);
	        cache.values().stream().forEach(i-> sum+=i);
	        System.out.println(-sum);
	        
        }
	}

}
