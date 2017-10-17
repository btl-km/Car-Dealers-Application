

import java.io.FileWriter;
import java.io.PrintWriter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Sellers extends Driver{
	
	private static TextField tfMake = new TextField();
	private static TextField tfModel = new TextField();
	private static TextField tfYear = new TextField();
	private static TextField tfPrice = new TextField();
	private static ComboBox<String> cbo = new ComboBox<>();
	private static String cboPicture;

	
	public static void sceneSellers() {
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		
		Button btBack = new Button("Back");
		btBack.setFont(new Font(12));
		btBack.setOnAction(e -> mainWindow.setScene(scene));
		btBack.setStyle("-fx-padding: 10, 20, 10, 20;");
		btBack.setFont(new Font(12));
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(gridPane);
		borderPane.setBottom(btBack);
		BorderPane.setAlignment(btBack, Pos.CENTER_RIGHT);
		BorderPane.setMargin(btBack, new Insets(12,20,12,12));
		
		tfMake.setPromptText("Toyota, etc.");
		tfModel.setPromptText("Corolla, etc.");
		tfYear.setPromptText("2016, etc.");
		tfPrice.setPromptText("10,000, etc.");
		
		Button btPlace = new Button("Place Car for Sale");
		btPlace.setFont(new Font(14));
		btPlace.setOnAction(e -> placeCarSale());
		
		labelMake.setFont(new Font(14));
		labelModel.setFont(new Font(14));
		labelYear.setFont(new Font(14));
		labelPrice.setFont(new Font(14));
		
		cbo.getItems().clear();
		cbo.getItems().addAll("Toyota", "Benz", "Audi", "Chrysler");
		cbo.setPromptText("Choose Image:");
		cbo.setVisibleRowCount(4);
		cbo.setEditable(false);
		cbo.setOnAction(e ->{
			cboPicture = cbo.getValue() + " ";
		});
		
		gridPane.add(labelMake, 0, 0);
		gridPane.add(tfMake, 1, 0);
		gridPane.add(labelModel, 2, 0);
		gridPane.add(tfModel, 3, 0);
		gridPane.add(labelYear, 0, 1);
		gridPane.add(tfYear, 1, 1);
		gridPane.add(labelPrice, 2, 1);
		gridPane.add(tfPrice, 3, 1);
		gridPane.add(cbo, 1, 2);
		gridPane.add(btPlace, 3, 2);
		
		borderPane.setStyle("-fx-background-color: steelblue;");
		
		//Create a scene and place it in the stage
		Scene sceneSeller = new Scene(borderPane, 500, 450);
		mainWindow.setScene(sceneSeller);  // Place the scene in the stage
		mainWindow.setResizable(false);
		mainWindow.show();   // Display the stage
	}
	
	public static void placeCarSale() {
		try {	
			String txtMake = tfMake.getText() + " ";
			String txtModel = tfModel.getText() + " ";
			String txtYear = tfYear.getText() + " ";
			String txtPrice = tfPrice.getText() + " ";
			PrintWriter output1 = new PrintWriter(new FileWriter(fileMake, true));
			output1.print(cboPicture);
			output1.print(txtMake);
			output1.print(txtModel);
			output1.print(txtYear);
			output1.println(txtPrice);
			output1.close();
		}
		catch (java.io.IOException ex) {
			System.out.println("I/O Errors: no such file");
		}		
		tfMake.clear();
		tfModel.clear();
		tfYear.clear();
		tfPrice.clear();
		
	}
	
	

}
