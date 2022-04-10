import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HowManyWords {

	public static void main(String[] args) {
		
		//initialize
		URL url = null;
		Scanner fileReader = null;
		
		
		try {
			url = new URL("https://liveexample.pearsoncmg.com/data/Lincoln.txt");
			
			fileReader = new Scanner(url.openStream());
			
			long count = 0L;
			while(fileReader.hasNext()) {
				fileReader.next();
				count++;
			}//how many words
			
			System.out.println("\nThe URL file: \"https://liveexample.pearsoncmg.com/data/Lincoln.txt\" has " + count + " words in it.");
			//output
			
		}//try 
		catch (MalformedURLException e) {
			System.out.println("Error: Ivalid URL");
		}
		catch (IOException e) {
			System.out.println("Error: No Such File");
		}
		finally {
			if(fileReader != null) fileReader.close();
		}
		
		
	}
}
