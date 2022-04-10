import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PizzaCalculator extends Application{

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage ps) {
		
		Pane pane = drawPane();
		
		ps.setTitle("Pizza Calculator");
		Scene scene = new Scene(pane, 500, 200);
		ps.setScene(scene);
		ps.show();
	}
	
	BorderPane drawPane() {
		BorderPane bp = new BorderPane();
		
		Label heading = new Label("Welcome to Algoma Pizza Pit");
		heading.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		heading.setTextFill(Color.BLUE);
		bp.setAlignment(heading, Pos.TOP_CENTER);
		bp.setTop(heading);
		
	//***************************************************************
		
		GridPane gpSize = new GridPane();
		gpSize.setVgap(5);
		gpSize.setStyle("-fx-border-color: black;");
		bp.setLeft(gpSize);

	//***************************************************************
			
		Label sizeTitle = new Label("Size");
		sizeTitle.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		gpSize.add(sizeTitle, 0, 0);
		
		RadioButton rbSmall = new RadioButton("Small");
		RadioButton rbMedium = new RadioButton("Medium");
		RadioButton rbLarge = new RadioButton("Large");
		
		ToggleGroup tgSize = new ToggleGroup(); 
		
		rbSmall.setToggleGroup(tgSize);
		rbMedium.setToggleGroup(tgSize);
		rbLarge.setToggleGroup(tgSize);
		
		gpSize.add(rbSmall, 0, 1);
		gpSize.add(rbMedium, 0, 2);
		gpSize.add(rbLarge, 0, 3);

	//***************************************************************
		
		GridPane gpDough = new GridPane();
		gpDough.setVgap(5); 
		gpDough.setStyle("-fx-border-color: black;");
		bp.setCenter(gpDough);

	//***************************************************************
				
		Label doughTitle = new Label("Dough");
		doughTitle.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		gpDough.add(doughTitle, 0, 0);
		
		RadioButton rbRegluar = new RadioButton("Regular");
		RadioButton rbWW = new RadioButton("Whole Wheat");
		RadioButton rbCS = new RadioButton("Cheese Stuffed");
		RadioButton rbHDS = new RadioButton("HotDog Stuffed");
		
		ToggleGroup tgDough = new ToggleGroup();
		
		rbRegluar.setToggleGroup(tgDough);
		rbWW.setToggleGroup(tgDough);
		rbCS.setToggleGroup(tgDough);
		rbHDS.setToggleGroup(tgDough);
		
		gpDough.add(rbRegluar, 0, 1);
		gpDough.add(rbWW, 0, 2);
		gpDough.add(rbCS, 0, 3);
		gpDough.add(rbHDS, 0, 4);

	//***************************************************************
			
		GridPane gpToppings = new GridPane();
		gpToppings.setVgap(5); gpToppings.setHgap(5);
		gpToppings.setStyle("-fx-border-color: black;");
		bp.setRight(gpToppings);

	//***************************************************************
			
		Label toppingsTitle = new Label("Toppings");
		toppingsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		gpToppings.add(toppingsTitle, 1, 0);
		
		CheckBox chkPep = new CheckBox("Peperoni");
		CheckBox chkMush = new CheckBox("Mushrooms");
		CheckBox chkSaus = new CheckBox("Sausage");
		CheckBox chkGreenPep = new CheckBox("Green Pepper");
		CheckBox chkRedPep = new CheckBox("Red Pepper");
		CheckBox chkOnion = new CheckBox("Onion");
		CheckBox chkGreenOlive = new CheckBox("Green Olive");
		CheckBox chkBlackOlive = new CheckBox("Black Olive");
		CheckBox chkHotPep = new CheckBox("Hot Pepper");
		CheckBox chkEXCheese = new CheckBox("Extra Cheese");
		CheckBox chkHam = new CheckBox("Ham");
		CheckBox chkDevilsTopping = new CheckBox("Pineapple");
		
		gpToppings.add(chkPep, 0, 1);
		gpToppings.add(chkMush, 1, 1);
		gpToppings.add(chkSaus, 2, 1);
		gpToppings.add(chkGreenPep, 0, 2);
		gpToppings.add(chkRedPep, 1, 2);
		gpToppings.add(chkOnion, 2, 2);
		gpToppings.add(chkGreenOlive, 0, 3);
		gpToppings.add(chkBlackOlive, 1, 3);
		gpToppings.add(chkHotPep, 2, 3);
		gpToppings.add(chkEXCheese, 0, 4);
		gpToppings.add(chkHam, 1, 4);
		gpToppings.add(chkDevilsTopping, 2, 4);

	//***************************************************************
			
		HBox hb = new HBox();
		hb.setAlignment(Pos.BASELINE_CENTER);
		hb.setSpacing(15);
		bp.setBottom(hb);
		
	//***************************************************************
			
		Button calculate = new Button("Calculate");
		Button exit = new Button("Exit");
		
		hb.getChildren().add(calculate);
		hb.getChildren().add(exit);
		
		return bp;
	}
}
