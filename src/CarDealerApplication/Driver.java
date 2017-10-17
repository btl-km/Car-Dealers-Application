

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Driver extends Application {
	
	static File fileMake = new File("make.txt");
	VBox vbox = new VBox(50);  //Create a VBox
	HBox hBox = new HBox(100);
	Stage primaryStage;
	
	static Label labelMake = new Label("Make:");
	static Label labelModel = new Label("Model:");
	static Label labelYear = new Label("Year:");
	static Label labelPrice = new Label("Price");
	static Scene scene;
	static Stage mainWindow;

	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		Font buttonFont = Font.font("SansSerif", FontWeight.BOLD,
				FontPosture.REGULAR, 12); 
		mainWindow = primaryStage;
		Button btSeller = new Button("Seller");
		btSeller.setStyle("-fx-padding: 10, 20, 10, 20;");
		btSeller.setFont(buttonFont);
		Button btBuyer = new Button("Buyer");
		btBuyer.setStyle("-fx-padding: 10, 20, 10, 20;");
		btBuyer.setFont(buttonFont);
		
		Label label1 = new Label("Welcome to the Auto_Dealer Application!");
		label1.setFont(Font.font("SansSerif", FontWeight.BOLD,
				FontPosture.REGULAR, 12));
		label1.setStyle("-fx-border-color: white; -fx-background-color: whitesmoke; -fx-padding: 10 20 10 20");
		vbox.setAlignment(Pos.CENTER);
		
		hBox.setPadding(new Insets(10, 50, 50, 50));
		hBox.getChildren().addAll(btSeller, btBuyer);
		hBox.setAlignment(Pos.CENTER);
		
		vbox.getChildren().addAll(label1, hBox);
		
		BackgroundImage myBI= new BackgroundImage(new Image("file:///C:/eclipse/workplace/FinalProject/src/classes/background.jpg",500,400,false,true),
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
		          BackgroundSize.DEFAULT);
		//then you set to your node
		vbox.setBackground(new Background(myBI));
		
		
		//Process events
		btBuyer.setOnAction(e -> Buyers.sceneBuyers());
		btSeller.setOnAction(e -> Sellers.sceneSellers());
		
		mainWindow.setTitle("Car Dealer Application");  // Set title
		scene = new Scene(vbox, 500, 400);
		mainWindow.setScene(scene);  // Place the scene in the stage
		mainWindow.setResizable(false);
		mainWindow.show();   // Display the stage
	}
	

	public static void main(String[] args) throws Exception {
		Application.launch(args);
	}

}
