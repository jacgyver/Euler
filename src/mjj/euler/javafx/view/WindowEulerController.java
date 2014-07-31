package mjj.euler.javafx.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import mjj.euler.javafx.model.Problem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class WindowEulerController {
	@FXML
	private TableView<Problem> problemTable;
	@FXML
	private TableColumn<Problem, String> idColumn;
	@FXML
	private TableColumn<Problem, String> titleColumn;
	
	private ObservableList<Problem> problemData = FXCollections.observableArrayList();
		      
	public WindowEulerController() {
		displayDBData();
	}
	

	@FXML
	private void initialize() {
		idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
		titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
		problemTable.setItems(problemData);
	}

	private void displayDBData() {
		int id = 0;
		String title = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/euler","root","root");
			
			String selectSQL = "Select id,title from euler.problems";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectSQL);
			
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				title = resultSet.getString("title");
				
				problemData.add(new Problem(String.valueOf(id),title));
				System.out.println(problemData.toString());
			}
			resultSet.close();
			statement.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}
