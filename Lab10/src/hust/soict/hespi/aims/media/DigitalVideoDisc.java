package hust.soict.hespi.aims.media;

import hust.soict.hespi.aims.PlayerException;
import javafx.scene.control.CheckBox;

public class DigitalVideoDisc extends Disc implements Playable{

	private int length;
	private String director;
	private final int type = 2;
	protected CheckBox selected;
	
	// Getter and Setter
	
	public int getType() {
		return type;
	}
	
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

	public DigitalVideoDisc() {
		super("Unknown", "Noname", 0.0f);
		this.director = "Unknown";
		this.length = 0;
	}

	public DigitalVideoDisc(String title) {
		super(title);
	}

	public DigitalVideoDisc(String category, String title) {
		super(category, title);
	}

	public DigitalVideoDisc(String director, String category, String title) {
		super(category, title);
		this.director = director;
	}

	public DigitalVideoDisc(String director, String category, String title, int length, float cost) {
		super(category, title, cost);
		this.director = director;
		this.length = length;
	}
		
	public void showDiscInfo() {		
		System.out.print("DVD - [" + title + "]");
		System.out.print(" - [" + category + "]");
		System.out.print(" - [" + director + "]");
		System.out.print(": [" + cost + "]$");
	}

	@Override
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			System.out.println("\tPlaying DVD: " + this.getTitle());
			System.out.println("\tDVD length: " + this.getLength());
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
		
	}

}
