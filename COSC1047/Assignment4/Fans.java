import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Fans extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage ps) {
		ps.setTitle("Fans");
		
		Scene scene = new Scene(drawFans(), 800, 800);
		ps.setScene(scene);
		
		ps.show();
	}

	private static GridPane drawFans() {
		GridPane gp = new GridPane();
		gp.setPadding(new Insets(10,10,10,10));
		gp.setHgap(10); gp.setVgap(10);
		
		//Fan1
		Circle c1 = new Circle(190);
		c1.setStroke(Color.RED);
		c1.setFill(Color.WHITE);
		gp.add(c1, 0, 0);
		
		//Fan2
		Circle c2 = new Circle(190);
		c2.setStroke(Color.BLUE);
		c2.setFill(Color.WHITE);
		gp.add(c2, 1, 0);
		
		//Fan3
		Circle c3 = new Circle(190);
		c3.setStroke(Color.PURPLE);
		c3.setFill(Color.WHITE);
		gp.add(c3, 0, 1);
		
		//Fan4
		Circle c4 = new Circle(190);
		c4.setStroke(Color.CYAN);
		c4.setFill(Color.WHITE);
		gp.add(c4, 1, 1);
		
		drawFanBlades(gp);
		
		return gp;
	}
	
	private static void drawFanBlades(GridPane gp) {
		//Fan1
		Pane pane = new Pane();
		int angle = 30;
		for(int i = 0; i < 4; i++, angle += 90) {
			Arc a1 = new Arc(190, 190, 160, 160, angle + 80, 50);
			a1.setType(ArcType.ROUND);
			a1.setFill(Color.RED);
			pane.getChildren().add(a1);
		}
		gp.add(pane, 0, 0);
		
		//Fan2
		Pane pane2 = new Pane();
		angle = 30;
		for(int i = 0; i < 4; i++, angle += 90) {
			Arc a1 = new Arc(190, 190, 160, 160, angle + 80, 50);
			a1.setType(ArcType.ROUND);
			a1.setFill(Color.BLUE);
			pane2.getChildren().add(a1);
		}
		gp.add(pane2, 1, 0);
				
		//Fan3
		Pane pane3 = new Pane();
		angle = 30;
		for(int i = 0; i < 4; i++, angle += 90) {
			Arc a1 = new Arc(190, 190, 160, 160, angle + 80, 50);
			a1.setType(ArcType.ROUND);
			a1.setFill(Color.PURPLE);
			pane3.getChildren().add(a1);
		}
		gp.add(pane3, 0, 1);
				
		//Fan4
		Pane pane4 = new Pane();
		angle = 30;
		for(int i = 0; i < 4; i++, angle += 90) {
			Arc a1 = new Arc(190, 190, 160, 160, angle + 80, 50);
			a1.setType(ArcType.ROUND);
			a1.setFill(Color.CYAN);
			pane4.getChildren().add(a1);
		}
		gp.add(pane4, 1, 1);
	}
}
