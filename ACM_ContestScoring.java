import java.util.*;


public class ACM_ContestScoring {

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ArrayList<String> correctList = new ArrayList<String>();
		HashMap<String,Integer> timeMap = new HashMap<String,Integer>();
		
		int mins = input.nextInt();
		while (mins != -1) {
			String letter = input.next();
			String rightwrong = input.next();
			if (rightwrong.equals("right")) {
				correctList.add(letter);
				timeMap.put(letter, timeMap.getOrDefault(letter, 0) + mins );
			} else {
				timeMap.put(letter, timeMap.getOrDefault(letter, 0) + 20);				
			}			
			
			mins = input.nextInt();
		}
		
		int totalScore = 0;
		for (String letter : correctList) {
			totalScore += timeMap.get(letter);
		}
		System.out.println(correctList.size() + " " + totalScore);
	}
}
