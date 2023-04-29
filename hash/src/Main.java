import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		String name;
		do {
			System.out.print("Enter a valid name\n>");
			name = keyboard.nextLine();
		}while(!MainValid.validName(name));
		
		String hashedName = hash(name);
		
		if(MainValid.exists(hashedName)) {
			System.out.println("Name exists. Exiting.");
			System.exit(0);
		}
		
		String ssn;
		do{
			System.out.print("\nEnter an SSN (ex. 123-45-6789)\n>");
			ssn = keyboard.nextLine();
		}while(!MainValid.validSsn(ssn));
		
		String hashedSsn = hash(ssn);
		
		if(MainValid.exists(hashedSsn)) {
			System.out.println("SSN exists. Exiting.");
			System.exit(0);
		}

		//Append both hashes to a file separated by commas.
		save(hashedName + "," + hashedSsn);
		
		keyboard.close();
		System.exit(0);
	}
	
	private static void save(String line) {
		try {
			FileWriter fw = new FileWriter("db", true);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(line);
			
			pw.close();
			
			System.out.println("Success.");
		}catch(Exception e) {
			System.out.println("Writing to file failed.");
			System.exit(5);
		}
	}
	
	private static String hash(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
		    md.update(input.getBytes());
		    byte[] digest = md.digest();
		    
		    //to string
		    String result = String.format("%032x", new BigInteger(1, digest));
		    System.out.println("Hash result " + result);
		    
		    return result;
		}catch(Exception e) {
			System.out.println("Error hashing.");
			
			return null;
		}
	}
}
