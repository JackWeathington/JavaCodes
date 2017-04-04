import java.util.ArrayList;

public class ComboQueue{
	
	//protected ArrayList<Animal> queue;
	protected Animal[] queue;
	protected int origCap=100;
	protected int numElements=0;
	protected int front=0;
	protected int rear=-1;
	
	public ComboQueue(){
		//queue=new ArrayList<Animal>();
		queue=new Animal[origCap];
	}
	
	public void enqueue(Animal a){
		if(rear==queue.length-1){
			enlarge();
		}
		queue[rear+1]=a;
		rear++;
	}

	public Animal dequeueAny() throws Exception{
		if(isEmpty()){
			throw new Exception("Is already empty");
		}
		else{
			Animal elem=queue[0];
			this.remove(0);
			return elem;
		}
	}
	
	public Animal dequeueDog() throws Exception{
		if(isEmpty()){
			throw new Exception("Is already empty");
		}
		else{
		
		for(int i=0; i<queue.length; i++){
			if (queue[i].getClass().equals(Dog.class)){
				Animal elem=queue[i];
				this.remove(i);
				return elem;
			}
		}
		System.out.println("No dogs currently available.");	
		}
		return null;
	}
	
	public Animal dequeueCat() throws Exception{
		if(isEmpty()){
			throw new Exception("Is already empty");
		}
		else{
		
		for(int i=0; i<queue.length; i++){
			if (queue[i].getClass().equals(Cat.class)){
				Animal elem=queue[i];
				this.remove(i);
				return elem;
			}
		}
		System.out.println("No cats currently available.");	
		}
		return null;
	}

	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(queue.length==0)
			return true;
		else
			return false;
	}
	
	public void enlarge(){
		Animal[] newArr=new Animal[(int) (queue.length*1.5)];
		for(int i=0; i<queue.length; i++){
			newArr[i]=queue[i];
		}
		queue=newArr;
	}
	
	public void remove(int index){
		for(int i=index; i<queue.length-1;i++){
			queue[i]=queue[i+1];
		}
		queue[queue.length-1]=null;
	}
}
