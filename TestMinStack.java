
public class TestMinStack {
	public static void main(String[] args){
		ArrayStack stack1=new ArrayStack(10);
		stack1.push(4);
		stack1.push(6);
		stack1.push(3);
		stack1.push(7);
		stack1.pop();
		System.out.println(stack1.findMinimum());
		stack1.pop();
		System.out.println(stack1.findMinimum());
	}

}
