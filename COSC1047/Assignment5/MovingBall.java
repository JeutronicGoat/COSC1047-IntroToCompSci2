import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MovingBall extends Application{

	private BallPane bp = new BallPane();
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage ps) {
		
		ps.setTitle("Moving Ball");
		
		
		Scene scene = new Scene(bp.getPane(), 800, 800);
		
		ps.setScene(scene);
		
		ps.show();
		
		bp.getPane().requestFocus();
		bp.getPane().setOnKeyPressed(e -> {
			switch(e.getCode()) {
			case UP: bp.ballUp(); break;
			case DOWN: bp.ballDown(); break;
			case LEFT: bp.ballLeft(); break;
			case RIGHT: bp.ballRight(); break;
			}
		});
	}
	
	
	private class BallPane{
		
		private Circle c;
		private Pane pane;
		private int xCoord = 400;
		private int yCoord = 400;
		private double radius = 100;
		 BallPane(){
			 pane = new Pane();
			 
			 c = new Circle(xCoord, yCoord, radius);
			 pane.getChildren().add(c);
		 }
		 
		 Pane getPane() {
			 return pane;
		 }
	
		 void ballUp() {
			 if(yCoord >= 0) {
				 yCoord -= 10;
				 c.setCenterY(yCoord);
				 c.setFill(Color.GREEN);
			 }
		 }
		 
		 void ballDown() {
			 if(yCoord <= pane.getHeight()) {
			 	yCoord += 10;
			 	c.setCenterY(yCoord);
			 	c.setFill(Color.RED);
			 }
		 }
		 
		 void ballLeft() {
			 if(xCoord >= 0) {
			 	xCoord -= 10;
			 	c.setCenterX(xCoord);
			 	c.setFill(Color.ORANGE);
			 }
		 }
		 
		 void ballRight() {
			 if(xCoord <= pane.getWidth()) {
			 	xCoord += 10;
			 	c.setCenterX(xCoord);
			 	c.setFill(Color.BLUE);
			 }
		 }
	} 
}

