import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ReadAsHex {

	public static void main(String[] args) {
		
		File file = new File("Exercise17_05.dat");
		
	//******************************************************************	Creating File
		
		try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))){
			
			int[] ints = new int[] {1,2,3,4,5};
			double doubleValue = 5.5;
			Date date = new Date();
			
			output.writeObject(ints);
			output.writeDouble(doubleValue);
			output.writeObject(date);
			
		} catch (FileNotFoundException fnfe) {

		} catch (IOException e) {

		}
		
		System.out.println("Done!");
		
	}
}
