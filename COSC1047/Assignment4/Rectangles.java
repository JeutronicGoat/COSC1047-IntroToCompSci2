import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Rectangles extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage ps) {
		
		Scanner in =  new Scanner(System.in);
		
		System.out.print("Please enter the (Center Coords(X,Y), Width, Height) of the first rectangle: ");
		int rec1CenterX = in.nextInt();
		int rec1CenterY = in.nextInt();
		int rec1Width = in.nextInt();
		int rec1Height = in.nextInt();
		Rectangle rec1 = new Rectangle(rec1CenterX, rec1CenterY, rec1Width, rec1Height);
		
		System.out.print("Please enter the (Center Coords, Width, Height) of the second rectangle: ");
		int rec2CenterX = in.nextInt();
		int rec2CenterY = in.nextInt();
		int rec2Width = in.nextInt();
		int rec2Height = in.nextInt();
		Rectangle rec2 = new Rectangle(rec2CenterX, rec2CenterY, rec2Width, rec2Height);
		
		
		ps.setTitle("Rectangles");
		
		Scene scene = new Scene(drawRectangles(rec1, rec2), 1000, 1000);
		ps.setScene(scene);
		
		ps.show();
	}
	
	private static Pane drawRectangles(Rectangle rec1, Rectangle rec2) {
		Pane pane = new Pane();
		
		rec1.setFill(Color.WHITE);
		rec1.setStroke(Color.BLACK);
		pane.getChildren().add(rec1);
		
		rec2.setFill(Color.WHITE);
		rec2.setStroke(Color.BLACK);
		pane.getChildren().add(rec2);
		
		recStatus(pane, rec1, rec2);
		
		return pane;
	}
	
	private static void recStatus(Pane pane, Rectangle rec1, Rectangle rec2) {
		
		if(contains(rec1, rec2)) {
			Text text = new Text(10, 10, "One Rectangle Is Contained In The Other.");
			pane.getChildren().add(text);
		}
		else if(doesNotOverlap(rec1, rec2)) {
			Text text = new Text(10, 10, "The Rectangles Do Not Overlap.");
			pane.getChildren().add(text);
		}
		else {
			Text text = new Text(10, 10, "One Rectangle Overlaps The Other.");
			pane.getChildren().add(text);
		}
	}
	
	private static boolean contains(Rectangle rec1, Rectangle rec2) {
		
		//		&& both corners must be inside to be contained
		return  (( rec2.getX() + rec2.getWidth()/2 < rec1.getX() + rec1.getWidth()/2				//	}-- rec2 is contained in rec1
				&& rec2.getX() - rec2.getWidth()/2 > rec1.getX() - rec1.getWidth()/2				//	|
				&& rec2.getY() + rec2.getHeight()/2 < rec1.getY() + rec1.getHeight()/2				//	|
				&& rec2.getY() - rec2.getHeight()/2 > rec1.getY() - rec1.getHeight()/2)) 			//	}
				||																					//	other case
				(  rec1.getX() + rec1.getWidth()/2 < rec2.getX() + rec2.getWidth()/2				//	}-- rec1 is contained in rec2
				&& rec1.getX() - rec1.getWidth()/2 > rec2.getX() - rec2.getWidth()/2				//	|
				&& rec1.getY() + rec1.getHeight()/2 < rec2.getY() + rec2.getHeight()/2				//	|
				&& rec1.getY() - rec1.getHeight()/2 > rec2.getY() - rec2.getHeight()/2);			//	}
	}
	
	private static boolean doesNotOverlap(Rectangle rec1, Rectangle rec2) {
		
		//    ^ because only one of the 2 corners can be inside to overlap
		return  (  rec2.getX() - rec2.getWidth()/2 > rec1.getX() + rec1.getWidth()/2		//	}-- Test to see if they don't overlap at all
				|| rec2.getY() - rec2.getHeight()/2 > rec1.getY() + rec1.getHeight()/2		//	|
				|| rec1.getX() - rec1.getWidth()/2 > rec2.getX() + rec2.getWidth()/2		//	|
				|| rec1.getX() - rec1.getWidth()/2 > rec2.getX() + rec2.getWidth()/2);		//	}
	}
}
