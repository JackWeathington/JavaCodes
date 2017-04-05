
public class printBack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	void printKth(LLNode node, int k){
		StringStack stack=new StringStack(Integer.MAX_VALUE);
		while(node != null){
			stack.push(node.getInfo());
			node=node.getLink();
		}
		for(int i=0; i<k-1; i++){
			stack.pop();
		}
		System.out.println(stack.top());
		
	}

}
