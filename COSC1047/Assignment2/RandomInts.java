import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RandomInts {

	public static void main(String[] args) {
		
		File file = new File("Exercise12_15.txt");
		
		if(!file.exists()) {
			throw new NoFileException("File not found: filename = Exercise12_15.txt ");
		}
		
		//initialize
		PrintWriter fileWriter = null;
		Scanner fileScanner = null;
		
		try {
			//assign
			fileWriter = new PrintWriter(file);
			fileScanner = new Scanner(file);
			
			//write to file
			for(int i = 0; i < 100; i++) {
				fileWriter.print(randomNum(0,100) + " ");
			}
			fileWriter.close();//move from buffer to file
			
			//write from file
			for(int i = 0, j = 1; i < 100; i++, j++) {
				System.out.printf("%6d",fileScanner.nextInt());
				if(j == 5) {
					System.out.println();
					j = 0;
				}
			}//for
		
		}//try
		catch(FileNotFoundException fnfe) {
			System.out.println("Error File Was Not Found");
		}
		catch(NoSuchElementException nsee) {
			System.out.println("Error: No Such Element");
		}
		catch(Exception e) {
			System.out.println("Error UNKOWN!");
		}
		finally{
			
			if(fileWriter != null)fileWriter.close();
			
			if(fileScanner != null)fileScanner.close();
			
		}
		
		
		
	}
	
	//random num generator
	public static int randomNum(int low, int high) {
		
		if(low > high) {
			int temp = low;
			low = high;
			high = temp;
		}
		
		return (int)(Math.random() * (high - low + 1)) + low;
	}
}
