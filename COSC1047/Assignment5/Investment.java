import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Investment extends Application{

	TextField tfAmount;
	TextField tfNumOfYrs;
	TextField tfAnnualRate;
	TextField tfFutureValue;
	Button btCalc;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage ps) {
		ps.setTitle("Investment Calculator");
		
		GridPane gp = new GridPane();
		Scene scene = new Scene(gp, 300, 200);
		ps.setScene(scene);
		
		ps.show();
		
	//***************************************
		
		tfAmount = new TextField();
		tfNumOfYrs = new TextField();
		tfAnnualRate = new TextField();
		tfFutureValue = new TextField();
		
		btCalc = new Button("Calculate");
		btCalc.setOnAction(e -> {
			calculate();
		});
		
	//***************************************	
		
		gp.setPadding(new Insets(15));
		gp.setVgap(10);
		gp.setHgap(10);
		
		gp.add(new Label("Investment Amount:"), 0, 0);
		gp.add(tfAmount, 1, 0);
		gp.add(new Label("Number of Years:"), 0, 1);
		gp.add(tfNumOfYrs, 1, 1);
		gp.add(new Label("Annual Intrest Rate:"), 0, 2);
		gp.add(tfAnnualRate, 1, 2);
		gp.add(new Label("Future Value:"), 0, 3);
		gp.add(tfFutureValue, 1, 3);
		gp.add(btCalc, 1, 4);
		
		tfAmount.setAlignment(Pos.BOTTOM_RIGHT);
		tfNumOfYrs.setAlignment(Pos.BOTTOM_RIGHT);
		tfAnnualRate.setAlignment(Pos.BOTTOM_RIGHT);
		tfFutureValue.setAlignment(Pos.BOTTOM_RIGHT);
		tfFutureValue.setEditable(false);
		
	}
	
	public void calculate() {
		double investmentAmount = Double.parseDouble(tfAmount.getText());
		int years = Integer.parseInt(tfNumOfYrs.getText());
		double monthlyRate = (Double.parseDouble(tfAnnualRate.getText()) / 100) / 12;
		
		double futureValue = Math.round((investmentAmount * Math.pow( 1 + monthlyRate, years * 12) * 100)) / 100.0;
		
		tfFutureValue.setText("$" + futureValue);
	}
}
