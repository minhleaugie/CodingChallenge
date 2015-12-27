import java.util.*;


public class HiddenPassword {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String pass = input.next();
		String message = input.next();
		
		if (isAcceptable(pass,message)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
	}

	private static boolean isAcceptable(String pass, String message) {

		for (int i = 0; i < message.length() && pass.length() >  0; i++) {
			char passChar = pass.charAt(0);
			char messageChar = message.charAt(i);
			if (passChar == messageChar) {
				pass = pass.substring(1);
			} else if ( pass.contains("" + messageChar)) {
				return false;
			} 
		}
		if (0 == pass.length()) {
			return true;			
		} else {
			return false;
		}
			
	}

}
