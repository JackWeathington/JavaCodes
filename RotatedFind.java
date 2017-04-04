
public class RotatedFind {
	static int[] list={15, 16, 19, 20, 25, 1,3,4,5,7,10,14};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(find(20));
	}
	
	protected static int find(int target){
		int first=0;
		int last=list.length-1;
		int location;
		
		//boolean found=false;
		while(first<=last){
			location=(first+last)/2;
			if (list[location]==target)
				return location;
			if(list[first]<=list[location]){
				if(list[first]<=target && target<=list[location]){
					last=location;
				}else{
					first=location;
				}
			}else{
				if(list[location]<=target && target<=list[last]){
					first=location;
				}else{
					last=location;
				}
				
			}
		}
		System.out.println("Target is not in the provided list");
		return -1;
	}

}
