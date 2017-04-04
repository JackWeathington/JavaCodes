import java.util.Scanner;
public class Euclid2 {
	static int x;
	static int y;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb=new Scanner(System.in);
		while(true){
			System.out.println("Input integers:");
			int m=kb.nextInt();
			int n=kb.nextInt();
			//System.out.println(m +" "+n);
			int x=gcd(m,n);
			System.out.println("The greatest common divisor of "+m+" and "+n+" is "+x+"\n\n");
		}
	}

	private static int gcd(int m, int n) {
		// TODO Auto-generated method stub
		
		x=m;
		
		y=n;
		while(n>0){
			//System.out.println("In while loop");
			if(n>m){
				//System.out.println("In swap if");
				int temp=n;
				n=m;
				m=temp;
			}
			//System.out.println(""+x%y);
			if(m%n==0){
				//System.out.print("In return if");
				return n;
			}else{
				//System.out.println("in else");
				int temp=n;
				n=m%n;
				m=temp;
				//System.out.println(x+" "+y);
			}
		}
		return 1;
	}

}
