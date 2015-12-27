import java.util.*;


public class PyroTubes {

//	static int[][] hammingDist;

	
	public static void main(String[] args) {
//		System.out.println(withinTwo(3));
//		System.exit(0);
		
		Scanner input = new Scanner(System.in);
		
		ArrayList<Integer> numList = new ArrayList<Integer>();
		Set<Integer> numSet = new HashSet<Integer>(); 
		int val = input.nextInt();
		while (val != -1) {
			numList.add(val);
			numSet.add(val);
			val = input.nextInt();
		}
		
		for (int i = 0; i < numList.size(); i++) {
			int count = 0;
			int n = numList.get(i);
//			System.out.println(withinTwo(n));
			for (int other: withinTwo(n)) {
				if (other > n && numSet.contains(other)) {
//					System.out.println("Other: " + other);
					count++;
				}
			}
			
			System.out.println(n + ":" + count);
		}
		
		
//		for (int i = 0; i < numList.size(); i++) {
//			int count = 0;
//			for (int j = i + 1; j < numList.size(); j++ ) {
//				if (hammingDist(numList.get(i),numList.get(j)) <= 2) {
//					count++;
//				}
//			}		
//			System.out.println(numList.get(i) + ":" + count);
//		}
		
				

	}
	
	private static int hammingDist(int a, int b) {
		int x = a ^ b;
		int count = 0;
		for (int i = 1; i < (1 << 19); i <<= 1) {
			if ((x & i) > 0) {
				count++;
			}
		}
		return count;
	}
	
	private static Set<Integer> withinTwo(int n) {
		Set<Integer> theSet = new HashSet<Integer>();
		
		for (int i = 1; i < (1 << 18); i <<= 1) {
			int x1 = n | i;
			int x2 = n & ((1 << 18) - i - 1);
			theSet.add(x1);
			theSet.add(x2);
//			System.out.println(x1 + "," + x2);
			for (int j = (i << 1); j < (1 << 18); j <<= 1) {
				theSet.add(x1 | j);
				theSet.add(x1 & ((1 << 18) - j - 1));		
//				int x3 = x1 | j;
//				int x4 = x1 & ((1 << 18) - j);
//				System.out.println(" * " + x3 + "," + x4);
				theSet.add(x2 | j);
				theSet.add(x2 & ((1 << 18) - j - 1));			
//				int x5 = x2 | j;
//				int x6 = x2 & ((1 << 18) - j - 1);

//				System.out.println(" * " + x5 + "," + x6);
			}
		}
		return theSet;
	}
	


}
