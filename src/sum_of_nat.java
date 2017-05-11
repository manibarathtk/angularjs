/*
 * Multiples of 3 and 5
Problem 1
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
sum of n natural numbers = n*(n+1)/2

 */
public class sum_of_nat {
	public static void main (String ... ar){
		int i= 1000;
		int sum=0;
		int three=999/3;
		int five=999/5;
		int fifteen=999/15;
		sum = (3*(three*(three+1))/2)+(5*(five*(five+1)/2))-(15*(fifteen*(fifteen+1)/2));
		System.out.println(three + " -- "+five +" -- "+fifteen+" -- "+sum);
		sum=0;
		for(int x=0;x<i;x++){
			if(x%3 == 0 || x%5 ==0){
				sum+=x;
			}
		}
		System.out.println(sum);
	}
}


