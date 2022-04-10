import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TrafficLights extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage ps) {
		
		ps.setTitle("Traffic Lights");
		
		BorderPane bp = new BorderPane();
		
		Scene scene = new Scene(bp, 400, 400);
		
		ps.setScene(scene);
		
		ps.show();
		
	//***************************************	
		
		HBox hb = new HBox();
		
		hb.setAlignment(Pos.BASELINE_CENTER);
		hb.setPadding(new Insets(10));
		hb.setSpacing(10);
		
		bp.setBottom(hb);
		
		RadioButton rbGreen = new RadioButton("Green");
		RadioButton rbOrange = new RadioButton("Orange");
		RadioButton rbRed = new RadioButton("Red");
		
		ToggleGroup tgColour = new ToggleGroup(); 
		
		rbGreen.setToggleGroup(tgColour);
		rbOrange.setToggleGroup(tgColour);
		rbRed.setToggleGroup(tgColour);
		
		hb.getChildren().add(rbGreen);
		hb.getChildren().add(rbOrange);
		hb.getChildren().add(rbRed);

	//***************************************	
		
		Pane pane = new Pane();
		bp.setCenter(pane);
		
		Rectangle box = new Rectangle(150, 20, 80, 200);
		box.setStroke(Color.BLACK);
		box.setFill(Color.WHITE);
		pane.getChildren().add(box);
		
		Circle green = new Circle(190, 50, 20);
		green.setStroke(Color.BLACK);
		green.setFill(Color.WHITE);
		pane.getChildren().add(green);
		
		Circle orange = new Circle(190, 110, 20);
		orange.setStroke(Color.BLACK);
		orange.setFill(Color.WHITE);
		pane.getChildren().add(orange);
		
		Circle red = new Circle(190, 170, 20);
		red.setStroke(Color.BLACK);
		red.setFill(Color.WHITE);
		pane.getChildren().add(red);
		
	//***************************************
		
		rbGreen.setOnAction(e -> {
			green.setFill(Color.GREEN);
			orange.setFill(Color.WHITE);
			red.setFill(Color.WHITE);
		});
		
		rbOrange.setOnAction(e -> {
			green.setFill(Color.WHITE);
			orange.setFill(Color.ORANGE);
			red.setFill(Color.WHITE);
		});
		
		rbRed.setOnAction(e -> {
			green.setFill(Color.WHITE);
			orange.setFill(Color.WHITE);
			red.setFill(Color.RED);
		});
		
	}
}
