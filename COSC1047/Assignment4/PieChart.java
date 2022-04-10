import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PieChart extends Application{

	public static void main(String[] args) {
		Application.launch();
	}
	
	@Override
	public void start(Stage ps) {
		ps.setTitle("Pie Chart");
		
		Scene scene = new Scene(pieChart(), 500, 300);
		ps.setScene(scene);
		
		ps.show();
	}
	
	private static Pane pieChart() {
		Pane pane = new Pane();
		
		double[] values = new double[] {20, 30, 35, 25, 100, 70};
		
		int total = 0;
		for(int i = 0; i < values.length; i++) total += values[i];
		
		String[] grades = new String[] {"Project", "Quiz", "Midterm", "Final", 
				"Additional Grade 1", "Additional Grade 2","Additional Grade 3","Additional Grade 4","Additional Grade 5","Additional Grade 6",};
		
		Color[] colors = new Color[] {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, 
				Color.CYAN, Color.GOLD, Color.CRIMSON, Color.LIGHTSLATEGREY, Color.STEELBLUE, Color.SLATEBLUE};
		
		
		double startingAngle = 0;
		for(int i = 0; i < values.length; i++) {
			double angle = values[i] / total * 360;
			Arc arc = new Arc(150, 150, 120, 120, startingAngle, angle);
			arc.setType(ArcType.ROUND);
			arc.setFill(colors[i]);
			arc.setStroke(Color.BLACK);
			pane.getChildren().add(arc);
			
			Circle circle = new Circle(290, 50 + (30 * i), 10);
			circle.setFill(colors[i]);
			pane.getChildren().add(circle);
			
			Text text = new Text(310, 55 + (30 * i), grades[i] + "-- " + Math.round(values[i] / total * 100) + "%");
			pane.getChildren().add(text);
			
			startingAngle += angle;
		}
		
		
		return pane;
	}
}
