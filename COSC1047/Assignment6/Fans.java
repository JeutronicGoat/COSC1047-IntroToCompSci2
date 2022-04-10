import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Fans extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage ps) {
		
		ps.setTitle("Fans");
		BorderPane bp = new BorderPane();
		Scene scene = new Scene(bp, 1200, 500);
		ps.setScene(scene);
		ps.show();
		
	//*************************************** Fan 1
		
		FanPane fan1 = new FanPane();
		bp.setLeft(fan1.getPane());
		
	//*************************************** Fan 2
		
		FanPane fan2 = new FanPane();
		bp.setCenter(fan2.getPane());
		
	//*************************************** Fan 3

		FanPane fan3 = new FanPane();
		bp.setRight(fan3.getPane());
		
	//*************************************** Bottom Buttons
		
		HBox hb = new HBox();
		
		hb.setAlignment(Pos.CENTER);
		hb.setPadding(new Insets(5));
		hb.setSpacing(30);
		
		Button startAll = new Button("Start All");
		Button stopAll = new Button("Stop All");
		
		hb.getChildren().addAll(startAll, stopAll);
		
		bp.setBottom(hb);

		startAll.setOnAction(e -> {
			fan1.play();
			fan2.play();
			fan3.play();
		});
		
		stopAll.setOnAction(e -> {
			fan1.pause();
			fan2.pause();
			fan3.pause();
		});
	}
}
	
