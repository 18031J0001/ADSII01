
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class In {
	private static final String CHARSET_NAME = "UTF-8";
	private static final Locale LOCALE = Locale.US;
	private Scanner scanner;

	   /**
	     * Initializes an input stream from standard input.
	     */
	    public In() {
	        scanner = new Scanner(new BufferedInputStream(System.in), CHARSET_NAME);
	        scanner.useLocale(LOCALE);
	    }
	    
	  public int readInt() {
	        try {
	        	String s=scanner.nextLine();
	        
	            return Integer.parseInt(s);
	        }
	        catch (InputMismatchException e) {
	            String token = scanner.next();
	            throw new InputMismatchException("attempts to read an 'int' value from the input stream, "
	                                           + "but the next token is \"" + token + "\"");
	        }
	        catch (NoSuchElementException e) {
	            throw new NoSuchElementException("attemps to read an 'int' value from the input stream, "
	                                           + "but no more tokens are available");
	        }
	    }
	  
	  public String Strineline() {
	        try {
	        	String s=scanner.nextLine();
	        	//System.out.println("==="+s);
	            return s;
	        }
	        catch (InputMismatchException e) {
	            String token = scanner.next();
	            throw new InputMismatchException("attempts to read an 'int' value from the input stream, "
	                                           + "but the next token is \"" + token + "\"");
	        }
	        catch (NoSuchElementException e) {
	            throw new NoSuchElementException("attemps to read an 'int' value from the input stream, "
	                                           + "but no more tokens are available");
	        }
	    }
	  
	  
	  public In(Scanner scanner) {
	        if (scanner == null) throw new IllegalArgumentException("scanner argument is null");
	        this.scanner = scanner;
	    }

}
