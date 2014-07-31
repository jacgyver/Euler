package mjj.euler;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class MjjMainController {
	@FXML
	private MenuItem closeMenuItem;
	
	public MjjMainController() {
	}
	
	@FXML
	private void initialize() {
		
	}
	@FXML
	public void handleClose() {
		System.exit(0);
	}
	
}
