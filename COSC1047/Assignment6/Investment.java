import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Investment extends Application{

	TextField tfLoanAmount;
	TextField tfNumOfYrs;
	TextArea text;
	
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage ps) {
		ps.setTitle("Debt Calculator");
		
		BorderPane bp = new BorderPane();
		
		Scene scene = new Scene(bp, 600, 300);
		ps.setScene(scene);
		
		ps.show();
		
	//*************************************** Button Listener
		
		tfLoanAmount = new TextField();
		tfNumOfYrs = new TextField();
		
		Button btShow = new Button("Show Table");
		btShow.setOnAction(e -> {
			calculate();
			
			ScrollPane sp = new ScrollPane();
			sp.setContent(text);
			sp.setFitToWidth(true); sp.setFitToHeight(true);
			bp.setCenter(sp);
			
		});
		
		
	//*************************************** Top labels/textfeilds
		
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		bp.setTop(hb);
		
		hb.setPadding(new Insets(10)); hb.setSpacing(10);
		
		hb.getChildren().add(new Label("Loan Amount:"));
		hb.getChildren().add(tfLoanAmount);
		hb.getChildren().add(new Label("Number of Years:"));
		hb.getChildren().add(tfNumOfYrs);
		
		hb.getChildren().add(btShow);
		
		tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
		tfNumOfYrs.setAlignment(Pos.BOTTOM_RIGHT);
		
		
	}
	
	public void calculate() {
		
		String output = ("Intrest Rate		Monthly Payment		Total Payment\n");
		
		for(double annualRate = 5.0; annualRate <= 8.0; annualRate += 0.125) {
			
			double loanAmount = Double.parseDouble(tfLoanAmount.getText());
			
			int years = Integer.parseInt(tfNumOfYrs.getText());
			
			double monthlyInterest = (annualRate / 100) / 12;
			
			double monthlyPayment = loanAmount * monthlyInterest / (1 - 1 / Math.pow(1 + monthlyInterest, years * 12));
		
			double totalPayment = (monthlyPayment * 12) * years;
		
			output += (String.format("%-28.3f %-36.2f %-30.2f \n", annualRate, monthlyPayment, totalPayment));
			
		}
		
		text = new TextArea(output);
	}
}
