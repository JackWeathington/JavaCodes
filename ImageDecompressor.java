import java.util.*;
public class ImageDecompressor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb=new Scanner(System.in);
		System.out.println("Input number of test-cases:");
		int cases=kb.nextInt();
		kb.nextLine();
		String[] input=new String[cases];
		for (int i=0; i<cases; i++){
			System.out.println("Input next test case:");
			input[i]=(String) kb.nextLine();
			
		}
		kb.close();
		System.out.println("Output:");
		for (int i=0; i<cases;i++){
			//System.out.println(input[i]);
			decodes(input[i]);
			System.out.println("");
		}
	}
	
	public static void decodes(String s){
		//System.out.println(s);

		if(s.length()==0){
			System.out.print(s);
		}else{
		
		
		if(s.charAt(0)=='1'){
			doesOnes(s.substring(1));	
		}	
		if(s.charAt(0)=='2'||s.charAt(0)=='3'||s.charAt(0)=='4'||s.charAt(0)=='5'||s.charAt(0)=='6'||s.charAt(0)=='7'||s.charAt(0)=='8'||s.charAt(0)=='9'){
			int value=(int)Integer.parseInt(s.substring(0,1));
			String now=s.substring(1,2);
			String rest=s.substring(2);
			
			for(int i=0; i<value;i++){
				System.out.print(now);
			}
			decodes(rest);
		}
		}
	}
		
		
		
	
	
	public static void doesOnes(String s){
		
		if(s.length()>1){//if the length is less is 1, then for it to be a valid input
						//the last letter will be a 1 and thus just close up and do nothing
		if(s.charAt(0)=='1'&&s.charAt(1)!='1'){
			decodes(s.substring(1));
		}else if(s.charAt(0)=='1'&& s.charAt(1)=='1'){
			System.out.print(1);
			doesOnes(s.substring(2));
		}else{
			System.out.print(s.charAt(0)+"");
			doesOnes(s.substring(1));
		}
	}
	}
	

}
