import java.io.*;

public class CreateBinaryIO {

	
	public static void main(String[] args) {
		File file = new File("myData.dat");
		
		try(DataOutputStream output = new DataOutputStream(new FileOutputStream(file));) {
			
			if(!file.exists()) {
				file.createNewFile();
			}
			
			int starting = 10000;
			int numOfTimes = randomInt(200,300);
			for(int i = 0; i < numOfTimes; i++) {
			
				double ranDouble = -50000 + (Math.random() * ( 50000 - -50000));
				
				int stringLength = randomInt(5,20);
				String s = "";
				for(int j = 0; j < stringLength; j++) {
					s += (char)(Math.random() * ('z' - 'a' + 1) + 'a');
				}
				
				output.writeInt(starting);
				output.writeDouble(ranDouble);
				output.writeUTF(s);
				
				starting++;
				
				output.close();
				
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("The File Was Not Found!!");
		} catch (IOException e) {
			System.out.println("An Error Occurred Writing To The File!!");
		}
		System.out.println("done");
	}
	
	public static int randomInt(int low, int high) {
		return low + (int)(Math.random() * ( high - low + 1));
	}
}
