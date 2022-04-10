import java.io.*;

public class ReadBinaryIO {

	public static void main(String[] args) {
		
		File file = new File("myData.dat");
		
		try(DataInputStream gather = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));){
			
			int count = 0;
			int maxInt = Integer.MIN_VALUE;
			int minInt = Integer.MAX_VALUE;
			double intAverage = 0.0;
			double maxDouble = Double.MIN_VALUE;
			double minDouble = Double.MAX_VALUE;
			double doubleAverage = 0.0;
			
			for( ; gather.available() > 0; count++) {
				int newInt = gather.readInt();
				double newDouble = gather.readDouble();
				
				intAverage += newInt;
				doubleAverage += newDouble;
				
				if(newInt > maxInt) maxInt = newInt;
				if(newInt < minInt) minInt = newInt;
				if(newDouble > maxDouble) maxDouble = newDouble;
				if(newDouble < minDouble) minDouble = newDouble;

				System.out.printf("%10d %15.5f %-25s \n", newInt, newDouble, gather.readUTF());
			}
			intAverage /= count;
			doubleAverage /= count;
			
			System.out.printf("\nThe Total Number of Records Was: %d \n", count);
			System.out.printf("The MIN Integer Was: %11d     The MAX Integer Was: %10d     The Average Integer Was: %.2f \n",
					minInt, maxInt, intAverage);
			System.out.printf("The MIN Double Was: %10.5f     The MAX Double Was: %10.5f     The Average Double Was: %.5f \n", 
					minDouble, maxDouble, doubleAverage);
			
			gather.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("The File Was Not Found!!!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}	
