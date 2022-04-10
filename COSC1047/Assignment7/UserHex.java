import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class UserHex extends Application{

	public static void main(String[] args) {
		launch();
	}
	
	public void start(Stage ps) {
		ps.setTitle("Hex Editing");
		
		HexPane hp = new HexPane();
		Scene scene = new Scene(hp, 800, 400);
		
		ps.setScene(scene);
		ps.show();
	}
}

