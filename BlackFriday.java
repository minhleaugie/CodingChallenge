import java.util.*;

public class BlackFriday {

	public static void main(String[] args) {
		Scanner console = new Scanner (System.in);
		int size = console.nextInt();
		ArrayList<Integer> number = new ArrayList<Integer>();
		ArrayList<Integer> unique = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			int input = console.nextInt();			
			if (number.contains(input)) {
				int index = number.indexOf(input);
				int count = unique.get(index);
				count++;
				unique.set(index, count);
			} else {
				number.add(input);
				unique.add(1);
			}
		}
		int uniqueOutcome = unique.get(0);
		int uniqueResult = number.get(0);
		
		
		for (int i = 1; i < unique.size(); i++) {
			 if (unique.get(i) < uniqueOutcome) {
				 uniqueOutcome = unique.get(i);
				 uniqueResult = number.get(i);
			 } else if (unique.get(i) == uniqueOutcome) {
				 if (number.get(i) > uniqueResult) {
					 uniqueResult = number.get(i);
				 }
			 }
		}
		
		System.out.print(uniqueResult);
		
		

	}

}
