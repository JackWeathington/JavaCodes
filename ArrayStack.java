//Question 3
public class ArrayStack {
	int[] stack;
	int[] mins;
	int topIndex=-1;
	int minStackIndex=0;
	
	public ArrayStack(int maxSize){
		stack=new int[maxSize];
		mins=new int[maxSize];
		mins[0]=Integer.MAX_VALUE; //prevents a null pointer exception
	}
	
	public void push(int element){
		if(!isFull()){
			topIndex++;
			stack[topIndex]=element;
			if(element <= mins[minStackIndex]){
				minStackIndex++;
				mins[minStackIndex]=(int)element;
			}
			
		}
		else{
			throw new StackOverflowError("");
		}
	}
	
	public boolean isFull(){
		if(topIndex==stack.length)
			return true;
		else
			return false;
	}
	
	public void pop(){
		if(!isEmpty()){
			if((int)stack[topIndex]==mins[minStackIndex]){
				//mins[minStackIndex]= (Integer) null;
				minStackIndex--;
			}
			//stack[topIndex]=(Integer) null;
			topIndex--;
		}
		
	}

	private boolean isEmpty() {
		// TODO Auto-generated method stub
		if(topIndex<0)
			return true;
		else
			return false;
	}
	
	public int top(){
		int topOfStack = 0;
		if(!isEmpty())
			topOfStack=stack[topIndex];
		return topOfStack;
	}
	
	public int findMinimum(){
		int min=mins[minStackIndex];
		return min;
	}
}


	
