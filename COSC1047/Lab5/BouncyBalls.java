import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class BouncyBalls extends Application {
	
	private Ball[] balls = new Ball[200];
	private int numBalls = 50;
	private boolean paused = true;
	private DrawingPane dPane = new DrawingPane();
	private Button startButton, stopButton;
	private int speed = 20;
	private Timeline animate;
	
	public void start(Stage primaryStage){
		
		BorderPane bPane = new BorderPane();
		bPane.setCenter(dPane);
		dPane.setStyle("-fx-background-color: #F8F8F8;");
	    dPane.setPrefSize(800,500);
		
	    
	    FlowPane buttonPane = new FlowPane(10, 10);
	    buttonPane.setPadding(new Insets(10, 10, 10, 10));
	    buttonPane.setStyle("-fx-background-color: blue;");
	    buttonPane.setAlignment(Pos.CENTER);
	    
	    startButton = new Button("Start");
	    
	    //STEP B - Part 2: add Action listener to call new StartHandler event handler object XX
	    startButton.setOnAction(new StartHandler());
	    
	    stopButton = new Button("Stop");
		stopButton.setDisable(true);

		//STEP C: add anonymous Action listener to do opposite of StartHandler object
		stopButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				startButton.setDisable(false);
				stopButton.setDisable(true);
				paused = true;
			}
		});
		
		

		buttonPane.getChildren().addAll(startButton, stopButton);
		bPane.setBottom(buttonPane);

		//STEP D - part 1: Add Timeline object to call a method in dPane called animateBall().  
		// The cycle will be INDEFINITE and the duration is stored in the global variable speed.
		animate = new Timeline(new KeyFrame( new Duration(speed), e -> { dPane.animateBalls();}));
		
		animate.setCycleCount(Timeline.INDEFINITE); 
		animate.play();
		
		//STEP E - Part 3: create KeyEvent Handler using any method to call removeBalls()
	    //when down arrow pressed, and addBalls() when up arrow pressed
		dPane.setOnKeyPressed(e -> {
			System.out.print("High");
			if(e.getCode() == KeyCode.UP) dPane.addBalls();
			if(e.getCode() == KeyCode.DOWN) dPane.removeBalls();
			}
		);
		
	
		dPane.requestFocus();
	    Scene scene = new Scene(bPane, 800, 600);
		primaryStage.setTitle("Bouncy Balls");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

	//STEP B - Part 1:  Create StartHandler class for Action Event event handler
	private class StartHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			startButton.setDisable(true);
			stopButton.setDisable(false);
			paused = false;
		}
	}
	
	
	
	private class DrawingPane extends Pane {
		
		DrawingPane(){
			
			for(int i = 0; i < numBalls; i++){
				balls[i] = new Ball();
				this.getChildren().add(balls[i].getBall());
			}
			System.out.println("NumBalls: " + numBalls);
		}
		
		//STEP D - Part 2 - create animateBalls() method
		void animateBalls() {
			if(!paused) {
				for(int i = 0; i < numBalls; i++) {
					balls[i].update();
				}
			}
		}
		
		

		//STEP E - Part 1: create a method called addBalls that will increase 
		// the numBalls value by 10 to a maximum of 200.
		void addBalls(){
			
			if(numBalls < 200) {
				for(int i = numBalls; i < numBalls + 10; i++) {
					balls[i] = new Ball();
					this.getChildren().add(balls[i].getBall());
				}
				numBalls += 10;
			}
			dPane.requestFocus();
		}
		
		
		//STEP E - Part 2: create a method called removeBalls that will decrease 
		// the numBalls value by 10 to a minimum of 0.

		void removeBalls(){
			dPane.requestFocus();
			if(numBalls > 0) {
				for(int i = numBalls -10; i < numBalls; i++) {
					this.getChildren().remove(balls[i].getBall());
					balls[i] = null;
				}
				numBalls -= 10;
			}
		}
		
	}
	
	
	//STEP A - create a BALL Object definition
	private class Ball {
		
		private double posX = 100;
		private double posY = 100;
		private double xVelocity;
		private double yVelocity;
		private double radius;
		private Circle ball;

		
		Ball(){
			xVelocity = -5 + (Math.random() * (5 - -5));
			yVelocity = -5 + (Math.random() * (5 - -5));
			radius = 10 + (Math.random() * (50 - 10));

			Color colour = new Color(Math.random(), Math.random(), Math.random(), Math.random());
			
			ball = new Circle(posX, posY, radius);
			ball.setFill(colour);
		}
		
		Circle getBall(){
			return ball;
		}
		
		void update() {
			double width = dPane.getWidth();
			double height = dPane.getHeight();
			
			if(posX + xVelocity + radius > width || posX + xVelocity - radius < 0) {
				xVelocity = -xVelocity;
			}
			if(posY + yVelocity + radius > height || posY + yVelocity - radius < 0) {
				yVelocity = -yVelocity;
			}
			
			posX += xVelocity;
			posY += yVelocity;

			ball.setCenterX(posX);
			ball.setCenterY(posY);
		}
	}
		
}
