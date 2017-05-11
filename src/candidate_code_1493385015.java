
public static HashMap<String, Boolean> mem = new HashMap<>();

   public static int appearanceCount(int input1,int input2,String input3,String input4)
	    {
		//Write code here
		 int count=0;
		 if(input1 >0 && input1 < 3001 && input2 >= input1 && input2 < 3000001){
			 if(input3.length() == input1 && input4.length() == input2){
				 int min=0, max=input1;
				[] tem3 = input3.toCharArray();
				 for(;max<=input2;min++,max++){
					 String tem4 = input4.substring(min, max);					 
					[] cTem4 = tem4.toCharArray();
					 Arrays.sort(cTem4);
					 tem4=new String(cTem4);					 
					 if(mem.containsKey(tem4)){
						 if(mem.get(tem4)){
							 count++;
						 }
					 }else{
						for (char c : tem3) {							
							tem4=tem4.replaceFirst(Character.toString(c),"");
						//System.out.println(tem4);
						}
						if(tem4.length()== 0){
							count++;
							mem.put( input4.substring(min, max), true);
						}else{
							mem.put( input4.substring(min, max), false);
						}
						
					 }
				 }
			 }
		 }
		 return count;
		 
	    }