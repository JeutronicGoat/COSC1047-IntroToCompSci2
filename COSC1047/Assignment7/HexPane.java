import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class HexPane extends BorderPane{

	TextField tfFileName;
	TextArea taFileContents;
	Button btSaveChanges;
	
	HexPane(){
		drawPane();
	}
	
	private void drawPane() {
		
		HBox hb = new HBox(); hb.setAlignment(Pos.CENTER);
		
		Label fileName = new Label("Please enter the name of the file: ");
		tfFileName = new TextField(); tfFileName.setPrefWidth(500);
		
		hb.getChildren().addAll(fileName, tfFileName);
		this.setTop(hb);
		
		tfFileName.setOnKeyPressed(e -> {
			if(e.getCode().equals(KeyCode.ENTER)) gatherFile();
		});
		
	//****************************************************************
		
		taFileContents = new TextArea();
		taFileContents.setWrapText(true);
		
		this.setCenter(taFileContents);
		
	//****************************************************************

		HBox hb2 = new HBox(); hb2.setAlignment(Pos.CENTER);
		
		btSaveChanges = new Button("Save Changes");
		
		hb2.getChildren().add(btSaveChanges);
		this.setBottom(hb2);
		
		btSaveChanges.setOnAction(e -> { saveChanges(); });
		
	}
	
	private void saveChanges() {
		
		try(DataOutputStream output = new DataOutputStream(new FileOutputStream(tfFileName.getText()))){
			
			
			StringBuilder sb = new StringBuilder();
			String hex = taFileContents.getText();
			
			for( int i=0; i<hex.length()-1; i+=2 ){
				
		      String hexUnit = hex.substring(i, (i + 2));
		      
		      int decimal = Integer.parseInt(hexUnit, 16);
		      
		      output.write((byte)decimal);
			}
			
			
		} catch (FileNotFoundException fnfe) {

		} catch (IOException e) {

		}
		
	}
	
	private void gatherFile() {
		String hexCode = "";
		
		try(DataInputStream input = new DataInputStream(new FileInputStream(tfFileName.getText()))){
			
			while(input.available() > 0) {
				hexCode += Integer.toHexString(input.readUnsignedByte()); 
				
				if(hexCode.length() == 1) hexCode = "0" + hexCode;
			}
			
			taFileContents.setText(hexCode.toString());
			
		} catch (FileNotFoundException fnfe) {

		} catch (IOException e) {

		}
		
		
	} //E:\OneDrive\School\Algoma University\1st Year\2nd Semester\Comp. Science\eclipse-workspace\Assignment 7\Exercise17_05.dat
}