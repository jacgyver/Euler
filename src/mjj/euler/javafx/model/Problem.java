package mjj.euler.javafx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Problem {
	private final StringProperty id;
	private final StringProperty title;
	
	public Problem() {
		this(null,null);
	}
	public Problem(String id,String title) {
		this.id = new SimpleStringProperty(id);
		this.title = new SimpleStringProperty(title);
	}
	public String getId() {
		return id.get();
	}
	public StringProperty idProperty() {
		return id;
	}
	public void setId(String id) {
		this.id.set(id);
	}
	public String getTitle() {
		return title.get();
	}
	public StringProperty titleProperty() {
		return title;
	}
	public void setTitle(String title) {
		this.title.set(title);
	}
	
	
	@Override
	public String toString() {
		return "Problem [id=" + id + ", title=" + title + "]";
	}


	
	

}
