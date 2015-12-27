import java.util.*;


public class DanceRecital {

	static int[][] changeTable;
	static ArrayList<String> routines;
	static int bestSoFar = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int numRoutines = input.nextInt();		
		
		changeTable = new int[numRoutines][numRoutines];
		
		routines = new ArrayList<String>();
		
		for (int i = 0; i < numRoutines; i++) {
			routines.add(input.next());
		}
		
		for (int i = 0; i < numRoutines; i++) {
			for (int j = i; j < numRoutines; j++) {
				changeTable[i][j] = numQuickChanges(routines.get(i), routines.get(j));
				changeTable[j][i] = changeTable[i][j];
//				System.out.println(routines.get(i) + " " + routines.get(j) + " : " + changeTable[i][j]);
			}
		}
		
		ArrayList<Integer> remainingChoices = new ArrayList<Integer>();
		for (int i = 0; i < numRoutines; i++) {
			remainingChoices.add(i);
		}
		
		branchAndBound(new ArrayList<Integer>(), remainingChoices, 0);		
		System.out.println(bestSoFar);
		
	}
	
	private static void branchAndBound(ArrayList<Integer> lineup, ArrayList<Integer> remainingChoices, int costSoFar) {
		if (remainingChoices.size() == 0) {
			if (costSoFar < bestSoFar) {
				bestSoFar = costSoFar;
//				System.out.print(lineup);
//				System.out.print(" ");
//				System.out.print(bestSoFar);
				
			}
		}
		if (costSoFar > bestSoFar) {
			return; 
		}
		
		int lastIndex = -1;
		if (lineup.size() > 0) {
			lastIndex = lineup.get(lineup.size()-1);
		}
		
		for (int i = 0; i < remainingChoices.size(); i++) {
			int nextIndex = remainingChoices.get(i);
			
			int cost = 0;
			if (lastIndex != -1) {
				cost = changeTable[lastIndex][nextIndex];
			}
			lineup.add(nextIndex);
			remainingChoices.remove(i);
			branchAndBound(lineup, remainingChoices, costSoFar+cost);
			remainingChoices.add(i, nextIndex);
			lineup.remove(lineup.size()-1);
		}		
	}
	
	private static int numQuickChanges(String a, String b) {
		Set<Character> setA = new HashSet<Character>();
		for (int i = 0; i < a.length(); i++) {
			setA.add(a.charAt(i));
		}
		int count = 0;
		for (int j = 0; j < b.length(); j++) {
			if (setA.contains(b.charAt(j))) {
				count++;
			}
		}
		return count;
	}

}
