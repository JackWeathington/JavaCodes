import java.util.Scanner;
public class Staircase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb=new Scanner(System.in);
		System.out.println("Input number of steps");
		int n=kb.nextInt();
		System.out.println("There are "+steps(n)+" possible ways for the child to climb the stairs");
	}
	public static int steps(int n){
		if(n<1){//the child has reached the top step;
			return 1; //thus has finished a unique path
		}
		int x=0;
		if(n>=3){
		x+=steps(n-3);
		}
		if(n>=2){
		x+=steps(n-2);
		}
		if(n>=1){
		x+=steps(n-1);
		}
		return x;
	}

}
