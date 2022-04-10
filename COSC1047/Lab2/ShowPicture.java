import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

public class ShowPicture extends Application {
	
	public void start(Stage primaryStage) throws Exception {
		
		int imgNum = 0;
		do {
			String answer = JOptionPane.showInputDialog(null,"Enter 1-7 to select an image");
			if(answer.length()>0 && answer.charAt(0)>='1'&&answer.charAt(0)<='7')
				imgNum = answer.charAt(0)-'0';
		} while (imgNum==0);
		
		LinePicture picture = new LinePicture("src/Lab2-mystery" + imgNum + ".dat");
				
		int[][][] polylines = picture.getPolylines();
		
		//Create a pane
		Pane pane = new Pane();
		
		//add each awt.Polygon to a javafx Polygon
		//System.out.println("Number of polygons:" + polylines.length );
		for(int i=0; i < polylines.length; i++){
			if(i>100) break;
			int[][] pline = polylines[i];
			//make a javaFX polygon and add it to the pane. Set fill white and stroke black
			Polyline polyline = new Polyline();
			pane.getChildren().add(polyline);
			polyline.setFill(null);
			polyline.setStroke(Color.BLACK);
			//get list of polygon points
			ObservableList<Double> list = polyline.getPoints();

			//System.out.println("Line ("+i+") points:" + polylines[i].length + " (" + pline.length + ")" );
			for(int point=0; point<pline.length; point++){
				list.add(pline[point][0]*1.0);
				list.add(pline[point][1]*1.0);
				
			}
		}
		
		//create Scene and add the pane
		Scene scene = new Scene(pane, 700, 600);
		primaryStage.setTitle("Show Mystery Picture");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
