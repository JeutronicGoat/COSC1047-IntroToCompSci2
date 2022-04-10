import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class FanPane {
		
		Timeline animate;
		int startingAngle = 15;
		BorderPane bp;
		double speed = 30; 
		Pane arcPane;
		
		FanPane(){
	
		bp = new BorderPane();
		bp.setStyle("-fx-border-color: black");

	//*************************************** Fan
		
		Pane pane = new Pane();
		pane.setPadding(new Insets(20));
		
		Circle circle = new Circle(190, 190, 180);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		pane.getChildren().add(circle);
		
	//*************************************** Fan Blades
		
		arcPane = new Pane();
		pane.getChildren().add(arcPane);
		
		int angle = 30;
		for(int i = 0; i < 4; i++, angle += 90) {
			Arc arc = new Arc(190, 190, 160, 160, angle + 80, 50);
			arc.setType(ArcType.ROUND);
			arcPane.getChildren().add(arc);
		}
		
		bp.setCenter(pane);
		
	//*************************************** Top Buttons
		
		getButtons();
		
	//*************************************** Bottom Slider
		
		getSlider();
		
	//*************************************** Animation
		animate = new Timeline(new KeyFrame(new Duration(speed), e -> {
			spinFan(arcPane);
		}));
		
		animate.setCycleCount(Timeline.INDEFINITE);
		animate.play();
		
		
		
	}
	
	public void play() {
		animate.play();
	}
		
	public void pause() {
		animate.pause();
	}
		
	public BorderPane getPane() {
		return bp;
	}
		
	private void animate() {
		animate.stop();
		animate = new Timeline(new KeyFrame(new Duration(speed), e -> {
			spinFan(arcPane);
		}));
		
		animate.setCycleCount(Timeline.INDEFINITE);
		animate.play();
	}
	
	private void getSlider() {
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		
		Slider slider = new Slider(0, 100, 30);
		slider.setScaleX(2);
		slider.setMin(0);
		slider.setMax(100);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(50);
		slider.setMinorTickCount(5);
		slider.setBlockIncrement(10);
		hb.getChildren().add(slider);
		
		
		slider.valueProperty().addListener(ov -> {
			speed = slider.getValue(); 
			animate();
		});
		
		bp.setBottom(hb);
	}
	
	private void getButtons() {
		HBox hb = new HBox();
		hb.setPadding(new Insets(5));
		hb.setSpacing(20);
		hb.setAlignment(Pos.CENTER);
			
		Button pause = new Button("Pause");
		Button resume = new Button("Resume");
		Button reverse = new Button("Reverse");

		hb.getChildren().addAll(pause, resume, reverse);
		bp.setTop(hb);
			
	//***************************************
			
		pause.setOnAction(e -> {
			animate.pause();
		});
			
		resume.setOnAction(e -> {
			animate.play();
		});
		
		reverse.setOnAction(e -> {
				startingAngle *= -1;
		});
	}
		
	private void spinFan(Pane pane) {
		ObservableList<Node> list = pane.getChildren();
		for (Node n: list) {
			((Arc)n).setStartAngle(((Arc)n).getStartAngle() + startingAngle);
		}
	}
	
}