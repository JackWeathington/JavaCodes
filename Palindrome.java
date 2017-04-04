import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb=new Scanner(System.in);
		
		while(true){
			System.out.println("Input string:");
			String s=kb.nextLine();
			String t="";
			for(int i=0; i<s.length();i++){
				if (i==s.length()-1){
					if(isLetter(s.substring(s.length()-1))){
						t=t.concat(s.substring(s.length()));
					}
				}
				else if(isLetter(s.substring(i,i+1))){
					t=t.concat(s.substring(i,i+1));
				}
			}
			
			if(iterativePalindrome(s))
				System.out.println("By the iterative method, "+s+" is a palindrome");
			else{
				System.out.println("By the iterative method, "+s+" is not a palindrome");
			}
			if(recursivePalindrome(s)){
				System.out.println("By the recursive method, "+s+" is a palindrome");
			}
			else{
				System.out.println("By the recursive method, "+s+" is not a palindrome");
			}
		}
		
	}
	
	public static boolean iterativePalindrome(String in){
		while(in.length()>1){
			if(!in.substring(0,1).equalsIgnoreCase(in.substring(in.length()-1)))
				return false;
			in=in.substring(1,in.length()-1);
		}
		return true;
	}
	
	public static boolean recursivePalindrome(String in){
		if(in.length()<=1){
			return true;
		}
		if (recursivePalindrome(in.substring(1,in.length()-1))==false){
			return false;
		}else if (in.substring(0,1).equalsIgnoreCase(in.substring(in.length()-1)))
				return true;
		else{
			return false;
		}
	}
	
	public static boolean isLetter(String i){//checks to make sure a character, sent in the form of a string is a letter
		if(i.equalsIgnoreCase("a")||i.equalsIgnoreCase("b")||i.equalsIgnoreCase("c")||i.equalsIgnoreCase("d")||i.equalsIgnoreCase("e")||i.equalsIgnoreCase("f")||i.equalsIgnoreCase("g")||i.equalsIgnoreCase("h")||
				i.equalsIgnoreCase("i")||i.equalsIgnoreCase("j")||i.equalsIgnoreCase("k")||i.equalsIgnoreCase("l")||i.equalsIgnoreCase("m")||i.equalsIgnoreCase("n")||
				i.equalsIgnoreCase("o")||i.equalsIgnoreCase("p")||i.equalsIgnoreCase("q")||i.equalsIgnoreCase("r")||i.equalsIgnoreCase("s")||i.equalsIgnoreCase("t")||
				i.equalsIgnoreCase("u")||i.equalsIgnoreCase("v")||i.equalsIgnoreCase("w")||i.equalsIgnoreCase("x")||i.equalsIgnoreCase("y")||i.equalsIgnoreCase("z")){
			return true;
		}
		else{
			return false;
		}
	}
	
	

}
