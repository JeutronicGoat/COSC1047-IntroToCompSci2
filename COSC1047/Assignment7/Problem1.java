import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Problem1 {

	public static void main(String[] args) {
		
	//******************************************************************	Creating File
		File file = new File("MyData.dat");
		
		try(DataOutputStream output = new DataOutputStream(new FileOutputStream(file));) {
			
			//Create if it doesn't exist
			if(!file.exists()) {
				file.createNewFile();
			}
			
			int numOfAppends = randomInt(200,300);
			for(int i = 0; i < numOfAppends; i++) {
				output.writeInt(randomInt(-12250,13580));
			}
			
			//output.close();
			
		} catch (FileNotFoundException fnfe) {
			
		} catch (IOException e) {

		}
		
		
	//******************************************************************	Reading File
		
		try(DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));){
			
			double total = 0;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			
			int count = 0;
			while(input.available() > 0) {
				
				int newInt = input.readInt();
				
				if(newInt > max) max = newInt;
				if(newInt < min) min = newInt;
				
				total += newInt;
				
				count++;
			}
			
			System.out.printf("The number of values was: %d \nThe total of all the numbers was: %.0f \n"
					+ "The largest value was: %d \nThe smallest value was: %d \nThe average of all the numbers was: %.3f", count, total, max, min, total / count);
			
			//input.close();
			
		} catch (FileNotFoundException fnfe) {

		} catch (IOException e) {

		}
		
		
		
		
	}
	
	private static int randomInt(int low, int high) {
		return low + (int)(Math.random() * (high - low + 1));
	}
}
