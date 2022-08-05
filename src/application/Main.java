package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	/*
	 * This method initialize the program, with the first scene controller
	 */
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/MainSceneTracker.fxml"));
			FirstSceneController controller = (FirstSceneController)loader.getController();
			controller.applicationStage = primaryStage;
			
			
			Scene scene = new Scene(root,700,700);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Meal Generator");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
