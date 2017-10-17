

import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Buyers extends Driver {
	
	private static int index1;
	private static ImageView imageView;
	
	public static void sceneBuyers() {
		VBox vbox = new VBox(50); 
		Label label1 = new Label("Check out our best offers: ");
		label1.setFont(Font.font("SansSerif", FontWeight.BOLD,
				FontPosture.ITALIC, 12));
		label1.setStyle("-fx-border-color: white; -fx-background-color: aliceblue; -fx-padding: 10 20 10 20");
		vbox.setAlignment(Pos.CENTER);
		
		Button btBack = new Button("Back");
		btBack.setFont(new Font(12));
		btBack.setOnAction(e -> mainWindow.setScene(scene));
		btBack.setStyle("-fx-padding: 10, 20, 10, 20;");
		btBack.setFont(new Font(12));
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(vbox);
		borderPane.setBottom(btBack);
		BorderPane.setAlignment(btBack, Pos.CENTER_RIGHT);
		BorderPane.setMargin(btBack, new Insets(12,20,12,12));
		
		Button btListCars = new Button("List of Available Cars");
		btListCars.setFont(new Font(14));
		btListCars.setOnAction(e -> listAvailableCars());
		
		vbox.getChildren().addAll(label1, btListCars);
		borderPane.setStyle("-fx-background-color: steelblue;");
		
		//Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 500, 450);
		mainWindow.setScene(scene);  // Place the scene in the stage
		mainWindow.setResizable(false);
		mainWindow.show();   // Display the stage
	}
	
	public static void listAvailableCars() {
		Scene scene = new Scene(customPane());
		Stage stageCars = new Stage();
		stageCars.setScene(scene); 
		stageCars.setResizable(true);
		stageCars.setMinWidth(500);
		stageCars.setMaxHeight(700);
		stageCars.setTitle("Available Cars");
		stageCars.showAndWait();
		
	}
	
	private static GridPane customPane() {
		String[][] cars = inputArray();
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10, 14, 10, 14));
		pane.setHgap(10);
		pane.setVgap(10);
		
		Font labelFont = Font.font("Times New Roman", FontWeight.BOLD,
				FontPosture.REGULAR, 16);
		labelMake.setFont(labelFont);
		labelModel.setFont(labelFont);
		labelYear.setFont(labelFont);
		labelPrice.setFont(labelFont);
		
		pane.add(labelMake, 1, 0);
		pane.add(labelModel, 2, 0);
		pane.add(labelYear, 3, 0);
		pane.add(labelPrice, 4, 0);
		
		for (int i = 0; i < index1; i++) {
			imageView = new ImageView(new Image("file:///C:/eclipse/workplace/FinalProject/src/classes/" +
					cars[i][0] + ".jpg"));
			imageView.setFitWidth(75);
			imageView.setFitHeight(50);
			pane.add(imageView, 0, i+1);
		}	
		
		for (int i = 0; i < index1; i++) {
			for (int j = 1; j < 5; j++) {
				Label label = new Label(cars[i][j]);
				label.setFont(new Font(14));
				pane.add(label, j, i+1);
			}
		}	
		return pane;
	}
	
	private static String[][] inputArray() {
		String[][] cars = new String[50][5];
		index1 = 0;
		try {
			Scanner input = new Scanner(fileMake);
			// Read data from a file
			while (input.hasNext()) {
				cars[index1][0] = input.next();
				cars[index1][1] = input.next();
				cars[index1][2] = input.next();
				cars[index1][3] = input.next();
				cars[index1][4] = input.next();
				index1++;
			}
			
			// Close the file
			input.close();
		}
		catch (FileNotFoundException ex){
			System.out.println("I/O Errors: no such file");
		}
		return cars;
		
	}

}
