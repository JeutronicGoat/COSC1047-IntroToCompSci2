import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TheVisitors extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage ps) {
		ps.setTitle("Welcome to Earth!");
		
		Scene scene = new Scene(drawPicture(), 400, 400);
		ps.setScene(scene);
		
		ps.show();
	}
	
	private static Pane drawPicture() {
		Pane pane = new Pane();
		
		pane.setStyle("-fx-background-color: #A9F5F2");
		
		Rectangle grass = new Rectangle(0, 200, 400, 200);
		grass.setStroke(Color.GREEN);
		grass.setFill(Color.GREEN);
		pane.getChildren().add(grass);
		
		Arc sun = new Arc(170, 135, 45, 45, 20, 190);
		sun.setStroke(Color.YELLOW);
		sun.setFill(Color.YELLOW);
		pane.getChildren().add(sun);
		
		Polygon backM = new Polygon(40, 190, 130, 90, 215, 190, 300, 100, 355, 190);
		backM.setStroke(Color.DARKGRAY);
		backM.setFill(Color.DARKGRAY);
		pane.getChildren().add(backM);
		
		Polygon frontM = new Polygon(0, 170, 70, 120, 120, 155, 230, 95, 300, 175, 360, 110, 400, 180, 400, 200, 0, 200);
		frontM.setStroke(Color.GRAY);
		frontM.setFill(Color.GRAY);
		pane.getChildren().add(frontM);
		
		Polygon river = new Polygon(95, 201, 145, 215, 85, 230, 400, 350, 400, 400, 250, 400, 40, 225, 100, 210, 75, 201);
		river.setStroke(Color.BLUE);
		river.setFill(Color.BLUE);
		pane.getChildren().add(river);
		
		Circle dome = new Circle(290, 235, 15);
		dome.setStroke(Color.LIGHTGRAY);
		dome.setFill(Color.WHITE);
		pane.getChildren().add(dome);
		
		Ellipse shipBody = new Ellipse(290, 250, 35, 15);
		shipBody.setStroke(Color.GRAY);
		shipBody.setFill(Color.LIGHTGRAY);
		pane.getChildren().add(shipBody);
		
		Line leg1 = new Line(270, 255, 260, 270);
		leg1.setStrokeWidth(2);
		pane.getChildren().add(leg1);
		
		Line leg2 = new Line(310, 255, 320, 270);
		leg2.setStrokeWidth(2);
		pane.getChildren().add(leg2);
		
		Text text = new Text(100, 40, "Hello People of Earth!");
		text.setFont(Font.font("Arial",FontWeight.BOLD, FontPosture.ITALIC, 20));
		pane.getChildren().add(text);
		
		return pane;
	}
}
