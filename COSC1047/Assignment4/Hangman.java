import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Hangman extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage ps) {
		ps.setTitle("Hangman");
		
		Scene scene = new Scene(drawPic(), 800, 800);
		ps.setScene(scene);
		
		ps.show();
	}
	
	private static Pane drawPic() {
		Pane pane = new Pane();
		
		//Hanging Stand
		Arc arc = new Arc(120, 750, 100, 30, 0, 180);
		arc.setType(ArcType.OPEN);
		arc.setStroke(Color.BLACK);
		arc.setFill(Color.WHITE);
		pane.getChildren().add(arc);
		
		Polyline line = new Polyline(120, 720, 120, 100, 500, 100, 500, 200);
		pane.getChildren().add(line);
		
		//Hangman Body
		Circle head = new Circle(500, 280, 80);
		head.setStroke(Color.BLACK);
		head.setFill(Color.WHITE);
		pane.getChildren().add(head);
		
		Line body = new Line(500, 360, 500, 620);
		pane.getChildren().add(body);
		
		Line arm1 = new Line(500, 400, 450, 500);
		pane.getChildren().add(arm1);
		
		Line arm2 = new Line(500, 400, 550, 500);
		pane.getChildren().add(arm2);
		
		Line leg1 = new Line(500, 620, 450, 700);
		pane.getChildren().add(leg1);
		
		Line leg2 = new Line(500, 620, 550, 700);
		pane.getChildren().add(leg2);
		
		//Face
		Line eye1_0 = new Line(460, 240, 490, 270);
		eye1_0.setStrokeWidth(3);
		pane.getChildren().add(eye1_0);
		Line eye1_1 = new Line(460, 270, 490, 240);
		eye1_1.setStrokeWidth(3);
		pane.getChildren().add(eye1_1);
		
		Line eye2_0 = new Line(510, 240, 540, 270);
		eye2_0.setStrokeWidth(3);
		pane.getChildren().add(eye2_0);
		Line eye2_1 = new Line(510, 270, 540, 240);
		eye2_1.setStrokeWidth(3);
		pane.getChildren().add(eye2_1);
		
		Polyline nose = new Polyline(500, 280, 505, 290, 500, 300);
		pane.getChildren().add(nose);
		
		Arc mouth = new Arc(500, 335, 40, 20, 35, 180);
		pane.getChildren().add(mouth);
		
		Arc tongue = new Arc(480, 340, 10, 10, 20, -180);
		tongue.setFill(Color.PINK);
		pane.getChildren().add(tongue);
		
		return pane;
	}
}
