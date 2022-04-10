import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Number12_13 {

	public static void main(String[] args) {
		
		System.out.print("Please enter the file name: ");
		Scanner in = new Scanner(System.in);
		
		String fileName = in.nextLine(); in.close();
		
		File file = new File(fileName);
		
		if(!file.exists()) {
			throw new NoFileException("File does not exist: filename = " + fileName);
		}//file exists?
		
		try {
			in = new Scanner(file);
			
			int characters = 0;
			int words = 0;
			int lines = 0;
			
			while(in.hasNext()) {
				String line = in.nextLine();
				characters += line.length();
				lines++;
			}//Characters & lines
			
			in.close();
			in = new Scanner(file);//reset scanner to the beginning of the file
			
			while(in.hasNext()) {
				in.next();
				words++;
			}//words
			
			in.close();
			
			System.out.println("The file \"" + fileName + "\" has:\n" + characters + " characters\n" + words + " words\n" + lines + " lines");
			//output
			
		} //try
		catch (FileNotFoundException e) {
			System.out.println("Error: The File: " + fileName + " was not found.");
		}
		
		
		
		
	}
}
