/*import java.util.Scanner;

public class solution11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long max=0; 
        int[][] grid = new int[20][20];
        for(int i=0; i < 20; i++){
            for(int j=0; j < 20; j++){
                grid[i][j] = in.nextInt();
                if(j>2){
                	long prod= grid[i][j]*grid[i][j-1]*grid[i][j-2]*grid[i][j-3];
                    max = prod > max?prod:max;
                    
                }
                if(i>2){
                	long prod= grid[i][j]*grid[i-1][j]*grid[i-2][j]*grid[i-3][j];
                	max = prod > max?prod:max;
                	
                	if(j>2){
                	prod = grid[i][j]*grid[i-1][j-1]*grid[i-1][j-2]*grid[i-1][j-3];
                	max = prod > max?prod:max;
                	}
                	if(j-3>17){
                	prod= grid[i-3][j+3]*grid[i-2][j+2]*grid[i-1][j+1]*grid[i][j];
                	max = prod > max?prod:max;
                	}
                }
            }
        }
        System.out.println(max);
    }
}
*/

import java.util.Scanner;

public class solution11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long max=0; 
        int[][] grid = new int[26][23];
        for(int i=0; i < 26; i++){
            for(int j=0; j < 23; j++){
                if(i > 19 || j > 19 ){
                    grid[i][j] = 0;
                }else{
                    grid[i][j] = in.nextInt();
                    if(grid[i][j] < 0 && grid[i][j] >101){
                     grid[i][j] =0;
                 }
                }   
            }
        }
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                
                	long prod= grid[i][j]*grid[i][j+1]*grid[i][j+2]*grid[i][j+3];
                    max = prod > max?prod:max;
                    
              
                
                	prod= grid[i][j]*grid[i][j-1]*grid[i][j-2]*grid[i][j-3];
                	max = prod > max?prod:max;
                	
                
                	prod = grid[i][j]*grid[i+1][j+1]*grid[i+2][j+2]*grid[i+3][j+3];
                	max = prod > max?prod:max;
                	if(i>2){
                	   prod= grid[i][j]*grid[i-1][j+1]*grid[i-2][j+2]*grid[i-3][j+3];
                        max = prod > max?prod:max;
                    }
            }
        }
        System.out.println(max);
    }
}
