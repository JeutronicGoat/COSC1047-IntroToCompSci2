import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		
		System.out.print("Please enter the file name: ");//ask file name
		Scanner in = new Scanner(System.in);			 //get file name 
		String fileName = in.nextLine(); in.close();	 //store file name
		
		File file = new File("src/" + fileName);
		File fileV2 = new File("src/Ver2-" + fileName);
		
		if(!file.exists() || !fileV2.exists()) {
			throw new NoFileException("Error: One or more of the files do not exist");
		}
		
		//initialize variables
		Scanner fileReader = null;
		PrintWriter output = null;
		
		StringBuilder s = new StringBuilder("");
		
			try {
				fileReader = new Scanner(file);
				
				while(fileReader.hasNextLine()) {
					s.append(fileReader.nextLine());
				}//fill stringbuilder
				fileReader.close();
				
				output = new PrintWriter(fileV2);
				
				for(int i = s.length() - 1; i >= 0; i--) {
					output.print(s.charAt(i));
				}//read string builder backwards and write to new file
				output.close();
				
				
				
			} //try
			catch (FileNotFoundException e) {
				System.out.println("Error: File does not exist");
			}
		
		
		
		
	}
	
}
