public class FindMin{
	
	public static void main(String[] args){
		
		if(args.length == 3){
			
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);
			int z = Integer.parseInt(args[2]);
			System.out.println("x = " + x + ", y = " + y + ", z = " + z);
			
			int min = x < y ? x : y;
			min = min < z ? min : z;
			System.out.println("Minimum = " + min);
				
		}				
	}
}
		