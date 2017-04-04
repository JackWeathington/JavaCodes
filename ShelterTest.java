
public class ShelterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComboQueue shelter=new ComboQueue();
		shelter.enqueue(new Cat("Calvin"));
		shelter.enqueue(new Cat("Garfell"));
		shelter.enqueue(new Dog("Fuzzy"));
		shelter.enqueue(new Cat("Muffins"));
		shelter.enqueue(new Dog("Doggy McDog"));
		
		try {
			Animal a=shelter.dequeueAny();
			System.out.println(a.name);
			
			Animal b=shelter.dequeueDog();
			System.out.println(b.name);
			
			Animal c=shelter.dequeueCat();
			System.out.println(c.name);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
