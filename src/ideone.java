/*
 *  there are N employee sitting in consecutive cubicles , we have to send a few of them to onsite , but each time we send one employee onsite , his cubicle becomes empty , now the other employees from both side of that empty cubicle stops working until they are given a gift .
the gifts are given in both sides of the empty cubicle until we reach the end or found another cubicle ,
Input – number of cubicle , and index numbers of people to be sent
output- min number of gifts needed
hint: we have to find the order in which we will sent the people on site , find the index that’s in the middle or near about middle and send him out , keep doing the same for left and right sub array , there are many other ways of doing this by using binary trees .


 *  package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class ideone
{
	static int count=0;

    static void get(int[] arr,int ini,int fin){
        if(ini>fin)return;
        int min=fin-ini+1;

        int start=-1;
       int med=(ini+fin)/2;
        int m2=med+1;
       int t=-1;

        for(int i=ini;i<=fin;i++) {

            if (arr[i] != 0) {

                t = Math.abs(med - i);

                if ((fin - ini) % 2 == 0) {
                    t = Math.min(t, Math.abs(m2 - i));
                }
                if (t <=min) {
                        min = t;

                        start = i;
                    }




            }
        }

       if(start==-1)return;
          else count+=fin-ini;

         if(ini!=start)get(arr,ini,start-1);
        if(fin!=start)get(arr,start+1,fin);

       }



	public static void main (String[] args) throws java.lang.Exception
	{int[] arr=new int[20];
        arr[2]=1;
        arr[6]=1; 
        arr[14]=1;
        //given n=20 and 3,6,14 are going on trip,
    
               get(arr,0,19);
        System.out.println(ideone.count);
		// your code goes here
	}
}