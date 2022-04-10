import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MovingText extends Application {

	private int xCoord = -150;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage ps) {
		
		Scene scene = new Scene(getPane(), 500, 200);
		
		ps.setTitle("Moving Text");
		
		ps.setScene(scene);
		
		ps.show();
	}
	
	public Pane getPane() {
		Pane pane = new Pane();
		
		Text t = new Text(-100, 100, "Jacob Culp");
		t.setFont(new Font(20));
		pane.getChildren().add(t);
		
		Timeline animate = new Timeline(new KeyFrame(new Duration(15), e -> {
				update(pane, t);
		}));
		
		animate.setCycleCount(Timeline.INDEFINITE);
		animate.play();
		
		pane.setOnMousePressed(e -> {
			animate.pause();
		});
		
		pane.setOnMouseReleased(e -> {
			animate.play();
		});
		
		return pane;
	}
	
	public void update(Pane pane, Text text) {
		double width = pane.getWidth();
		double height = pane.getHeight();
		
		if(xCoord > width) {
			xCoord = -150;
		}
		
		xCoord += 2;
		
		text.setX(xCoord);
	}
}
