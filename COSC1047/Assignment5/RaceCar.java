import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RaceCar extends Application {

	private int speed = 10;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage ps) {
		
		ps.setTitle("RaceCar");
		
		BorderPane bp = new BorderPane();
		
		HBox hb = new HBox();
		hb.setSpacing(40);
		hb.setPadding(new Insets(15,15,15,350));
		hb.setStyle("-fx-background-color: #336699;");
		
		Car car = new Car();

		bp.setBottom(hb);
		bp.setCenter(car.pane);
		
		Scene scene = new Scene(bp, 800, 455);
		ps.setScene(scene);
		
		ps.show();
		
		//adjust speed
		car.pane.requestFocus();
		car.pane.setOnKeyPressed(e -> {
			switch(e.getCode()) {
			case UP: speed -= 5; break;
			case DOWN: speed += 5; break;
			}
		});
		
		//move the car
		Timeline animate = new Timeline(new KeyFrame(new Duration(speed), e -> {
			car.moveCar();
		}));
		animate.setCycleCount(Timeline.INDEFINITE);
		animate.play();
		
		
		
		Button btStart = new Button("Start");
		hb.getChildren().add(btStart);
		
		btStart.setOnAction(e -> {
			animate.play();
		});
		
		Button btStop = new Button("Stop");
		hb.getChildren().add(btStop);
		
		btStop.setOnAction(e -> {
			animate.pause();
		});
	}
	
	
	
	private class Car {
		
		Pane pane = new Pane();
		
		private Arc body;
		private Arc windScreen;
		private Circle wheel1;
		private Circle wheel2;
		
		
		Car(){
			createTrack(pane);
			//Car
			body = new Arc(40, 200, 50, 30, 0, 180);
			body.setFill(Color.RED);
			body.setType(ArcType.ROUND);
			pane.getChildren().add(body);
			
			windScreen = new Arc(50, 190, 37, 20, 0, 90);
			windScreen.setFill(Color.LIGHTSTEELBLUE);
			windScreen.setType(ArcType.ROUND);
			pane.getChildren().add(windScreen);
			
			wheel1 = new Circle(20, 200, 10);
			pane.getChildren().add(wheel1);
		
			wheel2 = new Circle(60, 200, 10);
			pane.getChildren().add(wheel2);
		}
		
		void createTrack(Pane pane) {
			//Track & sky
			Rectangle sky = new Rectangle(0, 0, 800, 150);
			sky.setFill(Color.LIGHTBLUE);
			pane.getChildren().add(sky);
			
			Rectangle grass = new Rectangle(0, 150, 800, 250);
			grass.setFill(Color.GREEN);
			pane.getChildren().add(grass);
			
			Rectangle road = new Rectangle(0, 170, 800, 50);
			road.setFill(Color.DARKGRAY);
			pane.getChildren().add(road);
			
			Circle sun = new Circle(10, 10, 50);
			sun.setFill(Color.YELLOW);
			pane.getChildren().add(sun);
		}
		
		void moveCar() {
			if(wheel1.getCenterX() > pane.getWidth()) {
				body.setCenterX(40);
				windScreen.setCenterX(50);
				wheel1.setCenterX(20);
				wheel2.setCenterX(60);
			}
			else{
				body.setCenterX(body.getCenterX() + 2);
				windScreen.setCenterX(windScreen.getCenterX() + 2);
				wheel1.setCenterX(wheel1.getCenterX() + 2);
				wheel2.setCenterX(wheel2.getCenterX() + 2);
			}
		}
		
	}
}
