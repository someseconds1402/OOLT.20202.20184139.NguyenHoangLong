package hust.soict.hespi.aims.media;

import javafx.scene.control.CheckBox;

public class Media {

	protected String title;
	protected String category;
	protected float cost;
	protected int type;
	protected String typeString;
	protected int ID = 1;
	protected CheckBox selected;

	// Constructor

	public Media() {
		ID++;
	}

	public Media(String title) {
		this();
		this.title = title;
	}

	public Media(String category, String title) {
		this();
		this.category = category;
		this.title = title;
	}

	public Media(String category, String title, float cost) {
		this();
//		CheckBox cb = new CheckBox();
		this.category = category;
		this.title = title;
		this.cost = cost;
//		this.selected = cb;
	}

	// Getter and Setter

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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
	
	public CheckBox getSelected() {
		return selected;
	}

	public void setSelected(CheckBox selected) {
		this.selected = selected;
	}

	// Method
	

	public String getTypeString() {
		int check = this.getType();
		if(check == 1) {
			return "Book";
		}
		else if(check == 2) {
			return "DVD";
		}
		else {
			return "CD";
		}
	}

	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		if (this instanceof Book) {
			return 1;
		} else if (this instanceof DigitalVideoDisc) {
			return 2;
		} else {
			return 3;
		}
	}

}
