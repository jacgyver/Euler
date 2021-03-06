package mjj.euler;

import java.io.IOException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.sql.Statement;

import mjj.euler.javafx.model.Problem;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MjjMain extends Application {
	@FXML
	private static TableView<Problem> problemTable;
	@FXML
	private static TableColumn<Problem, String> idColumn;
	@FXML
	private static TableColumn<Problem, String> titleColumn;
	
	private Stage primryStage;
	private BorderPane rootLayout;
	private static ObservableList<Problem> problemData = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage) {
		this.primryStage = primaryStage;
		this.primryStage.setTitle("MJJ JavaFX");
		
		initRootLayout();
		showWindowEuler();
		
	}

	private void initRootLayout() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MjjMain.class.getResource("MjjMain.fxml"));
		
		try {
			rootLayout = (BorderPane)loader.load();
			
			Scene scene = new Scene(rootLayout);
			primryStage.setScene(scene);
			primryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void showWindowEuler() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MjjMain.class.getResource("javafx/view/WindowEuler.fxml"));

		
		

		try {
			AnchorPane windowEuler = (AnchorPane)loader.load();
			
			Scene scene = new Scene(windowEuler);
			rootLayout.setCenter(windowEuler);

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}




	public static void main(String[] args) {
		
		launch(args);
	}
}
