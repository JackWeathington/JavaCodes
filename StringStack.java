
public class StringStack {
		String[] stack;
		
		int topIndex=-1;
				
		public StringStack(int maxSize){
			stack=new String[maxSize];
			
		}
		
		public void push(String element){
			if(!isFull()){
				topIndex++;
				stack[topIndex]=element;
						
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
				stack[topIndex]= null;
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
		
		public String top(){
			String topOfStack="";
			if(!isEmpty())
				topOfStack=stack[topIndex];
			return topOfStack;
		}
		
}
