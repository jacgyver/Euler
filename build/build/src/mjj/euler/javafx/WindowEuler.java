package mjj.euler.javafx;

import javafx.application.Application;
import javafx.stage.Stage;

public class WindowEuler extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Euler project for Windows");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
