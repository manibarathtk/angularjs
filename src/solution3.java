/*
 * A palindromic number reads the same both ways. The smallest 6 digit palindrome made from the product of two 3-digit numbers is . 

Find the largest palindrome made from the product of two 3-digit numbers which is less than .

Input Format

First line contains  that denotes the number of test cases. This is followed by  lines, each containing an integer, .
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class solution3 {
    private static ArrayList<Integer> pali = new ArrayList<Integer>();
	static void palindrome(){
		//ArrayList<Integer> pali = new ArrayList<Integer>();
		for(int i=999;i>99;i--){
			for(int j=i;j>99;j--){
				Integer num = i*j;
				
				if(Integer.parseInt(new StringBuilder(num.toString()).reverse().toString()) == num){
					pali.add(num);
					//System.out.println(num);
				}
			}
		}
		Collections.sort(pali);
		Collections.reverse(pali);
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        if(t>0 && t <=100){
            palindrome();
            for(int a0 = 0; a0 < t; a0++){
                int n = in.nextInt();
                if(n > 101101 && n <1000000){
                    System.out.println(pali.stream().filter(p -> p< n).findFirst().get());
                }
            }
        }
    }
}
