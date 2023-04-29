import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainValid {

	public static boolean exists(String hash) {
		boolean result = false;
		
		try {
			File in = new File("db");
			Scanner file = new Scanner(in);
			
			while(file.hasNext()) {
				if(file.nextLine().contains(hash)) {
					result = true;
				}
			}
			
			file.close();
		} catch (Exception e) {
			//System.out.println("Warning: lookup failed, db missing.");
		}
		
		return result;
	}
	
	public static boolean validName(String input) {
		if(input == null)
			return false;
		
		if(input.length() < 1)
			return false;
		
		if(input.length() > 256)
			return false;
		
		if(!isLetters(input))
			return false;
		
		return true;
	}
	
	private static boolean isLetters(String input) {
		Pattern p = Pattern.compile("^[a-zA-Z ]+$");
		Matcher m = p.matcher(input);
		
		return m.find();
	}
	
	public static boolean validSsn(String input) {
		if(input == null)
			return false;
		
		if(input.length() != 11)
			return false;
		
		if(!isNumbers(input))
			return false;
		
		if(input.charAt(3) != '-' || input.charAt(6) != '-')
			return false;
		
		return true;
	}
	
	public static boolean isNumbers(String input) {
		Pattern p = Pattern.compile("^[0-9-]+$");
		Matcher m = p.matcher(input);
		
		return m.find();
	}
}
