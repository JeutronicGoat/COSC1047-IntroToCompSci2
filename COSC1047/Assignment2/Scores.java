import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scores {

	public static void main(String[] args) {
		
		URL url = null;
		Scanner fileIn = null;
		
		try {
			url = new URL("https://liveexample.pearsoncmg.com/data/Scores.txt");
			fileIn = new Scanner(url.openStream());//set up scanner to URL
			
			ArrayList<Integer> scoreList = new ArrayList();
			while(fileIn.hasNext()) {
				scoreList.add(fileIn.nextInt());
			}//read all the score store in arraylist
			
			int total = 0;
			for(int i = 0; i < scoreList.size(); i++) {
				total += scoreList.get(i);
			}//total scores
			
			System.out.println("The total of all the scores is: " + total + ", and the average is: " + ((total * 1.0) / scoreList.size()) + ".");
			//output
		}
		catch (InputMismatchException ime) {
			System.out.println("Error: Invalid Input.");
		}
		catch (MalformedURLException e) {
			System.out.println("Error: Ivalid URL");
		}
		catch (IOException e) {
			System.out.println("Error: No Such File");
		}
	}
}
