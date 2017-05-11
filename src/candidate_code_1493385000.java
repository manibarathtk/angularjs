import java.io.IOException;
import java.util.Scanner;
public class candidate_code_1493385000 {
/*
     * Complete the function below.
    */
	public static int GetJump(int input1,int input2,int input3){
		int jump=0;
		if(input3 >input1){
			jump +=1;
			jump += GetJump(input1, input2, input3-input1+input2);
		}else{
			jump +=1;
		}
		return jump;
	}
	public static int GetJumpCount(int input1,int input2,int[] input3)
    {
	//Write code here
		//TreeMap<Integer, Integer> som = new TreeMap<>();
		int jump = 0;
		for (int i : input3) {
			while(true){
				if(i>input1){
					++jump;
					i = i-input1+input2;
					continue;
				}else{
					++jump;
					break;
				}
			}
					//GetJump(input1, input2, i);
		}
		return jump;
    }
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int output = 0;
        int ip1 = Integer.parseInt(in.nextLine().trim());
        int ip2 = Integer.parseInt(in.nextLine().trim());
        int ip3_size = 0;
        ip3_size = Integer.parseInt(in.nextLine().trim());
        int[] ip3 = new int[ip3_size];
        int ip3_item;
        for(int ip3_i = 0; ip3_i < ip3_size; ip3_i++) {
            ip3_item = Integer.parseInt(in.nextLine().trim());
            ip3[ip3_i] = ip3_item;
        }
        output = GetJumpCount(ip1,ip2,ip3);
        System.out.println(String.valueOf(output));
    }
	}