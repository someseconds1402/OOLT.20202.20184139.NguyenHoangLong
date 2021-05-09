package hust.soict.hespi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Media {
	protected String title;
	protected String category;
	protected float cost;
	
	// Constructor
	
	public Media() {
		
	}
	
	public Media (String title) {
		this.title = title;
	}
	
	public Media (String category, String title) {
		this.category = category;
		this.title = title;
	}
	
	public Media(String category, String title, float cost) {
		this.category = category;
		this.title = title;
		this.cost = cost;
	}

	// Getter and Setter
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}	
	
	// Method
	
	
}
