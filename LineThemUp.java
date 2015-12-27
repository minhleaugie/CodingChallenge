import java.util.*;


public class LineThemUp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numNames = input.nextInt();
		ArrayList<String> names = new ArrayList<String>();
		
		for (int i = 0; i < numNames; i++) {
			names.add(input.next());
		}
		
		ArrayList<String> sortedCopy = new ArrayList<String>(names);
		Collections.sort(sortedCopy);

		if (names.equals(sortedCopy))
		{
			System.out.println("INCREASING");
		} else
		{
			Collections.reverse(sortedCopy);
			
			if (names.equals(sortedCopy)) {
				System.out.println("DECREASING");
			} else {
				System.out.println("NEITHER");				
			}
				
		}	
		

	}

			
			

}
 