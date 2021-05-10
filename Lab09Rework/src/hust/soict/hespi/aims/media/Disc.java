package hust.soict.hespi.aims.media;

import javafx.scene.control.CheckBox;

public class Disc extends Media {
	private int length;
	private String director;
	protected CheckBox selected;

	// Getter and Setter
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public CheckBox getSelected() {
		return selected;
	}

	public void setSelected(CheckBox selected) {
		this.selected = selected;
	}

	// Constructor
	public Disc() {
		super();
	}
	
	public Disc(String category, String title, float cost) {
		super(category, title, cost);
	}

	public Disc(String category, String title) {
		super(category, title);
	}

	public Disc(String title) {
		super(title);
	}

}
