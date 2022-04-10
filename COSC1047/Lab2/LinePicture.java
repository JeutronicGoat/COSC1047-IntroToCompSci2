import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LinePicture {
	
	int[][][] points;
	
	
	public LinePicture (String filename) {
		
		File file = new File(filename);
		
		if(!file.exists()) {
			throw new LinePictureException("File not found: filename = " + filename + ".");
		}
		
		Scanner fileScanner = null;
		
		int lineIndex = 0;
		int pointIndex = 0;
		
		try {
			fileScanner = new Scanner(file);
			
			int numLines = fileScanner.nextInt();
			points = new int[numLines][][];
			
			for(lineIndex = 0; lineIndex < numLines; lineIndex++) {
				
				int numPoints = fileScanner.nextInt();
				points[lineIndex] = new int[numPoints][2];
				
				for(pointIndex = 0; pointIndex < numPoints; pointIndex++) {
					
					int x = fileScanner.nextInt();
					int y = fileScanner.nextInt();
					
					points[lineIndex][pointIndex][0] = x;
					points[lineIndex][pointIndex][1] = 550 - y;
				}//for2
				
			}//for1
			
		}//try
		catch(InputMismatchException ime) {
			System.out.println("Error reading the data: lineNum = " + lineIndex + ", vertexNum = " + pointIndex + ".");
		}
		catch(NullPointerException npe) {
			System.out.println("Error, no data found: lineNum = " + lineIndex + ", vertexNum = " + pointIndex + ".");
		}
		catch(Exception e) {
			System.out.println("Unkown Error: " + lineIndex + ", vertexNum = " + pointIndex + ".");
		}
		finally {
			if(fileScanner != null) fileScanner.close();
		}//finally
		
	}
	
	public int[][][] getPolylines(){
		return points;
	}
	
}
