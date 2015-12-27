import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ClosingTheLoop {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int numberOfCases = console.nextInt(); // number of cases
		int ropeLoop = 0;

		for (int i = 1; i <= numberOfCases; i++) {
			int segment = console.nextInt(); // number of rope segments in the bag
			String[] value = new String[segment];
			for (int j = 0; j < segment; j++) {
				value[j] = console.next();
			}
			if (segment <= 1) {
				System.out.println("Case #" + i + ": 0");
			} else {				
				ropeLoop = createLoop(value);
				System.out.println("Case #" + i + ": " + ropeLoop);
			}
			
		}

	}

	public static String color(String string) {
		if (string.charAt(string.length() - 1) == 'B') {
			return "B";
		} else if (string.charAt(string.length() - 1) == 'R') {
			return "R";
		} else
			return "";

	}

	public static int segmentLength(String string) {
		String s = string.substring(0, string.length() - 1);

		return Integer.parseInt(s);
	}

	public static int createLoop(String[] value) {
		ArrayList<Integer> red = new  ArrayList<Integer>();
		ArrayList<Integer> blue = new  ArrayList<Integer>();
		int loop = 0;
		for (int j = 0; j < value.length; j++) {
			if (color(value[j]) == "R") {
				red.add(segmentLength(value[j]));
			} else if (color(value[j]) == "B") {
				blue.add(segmentLength(value[j]));
			}
		}
		Collections.sort(red);
		Collections.reverse(red);
		Collections.sort(blue);
		Collections.reverse(blue);
		
		if (red.size() == blue.size()) {
			for (int i = 0; i < red.size(); i++) {
				loop = loop + red.get(i) + blue.get(i);
			}
			loop= loop - red.size() - blue.size();
		} else if (red.size() < blue.size()) {
			for (int i = 0; i < red.size(); i++) {
				loop = loop + red.get(i) + blue.get(i);
			}
			loop-= 2*red.size();
		} else {
			for (int i = 0; i < blue.size(); i++) {
				loop = loop + red.get(i) + blue.get(i);
			}
			loop-=2*blue.size();
		}

		return loop;
	}

}
