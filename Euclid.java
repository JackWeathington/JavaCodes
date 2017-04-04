import java.util.Scanner;

public class Euclid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb=new Scanner(System.in);
		while(true){
			System.out.println("Input integers:");
			int m=kb.nextInt();
			int n=kb.nextInt();
			System.out.println("The greatest common divisor of "+m+" and "+n+" is "+gcd(m,n)+"\n\n");
		}
	}
	
	static int gcd(int m, int n){
		if(m<n){
			int temp=m;
			m=n;
			n=temp;
		}
		if(m%n==0){
			return n;
		}else{
			return gcd(n, m%n);
		}
	}

}
