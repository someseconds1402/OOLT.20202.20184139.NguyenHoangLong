package hust.soict.hespi.aims.media;

public class DigitalVideoDisc extends Media {

	private int length;
	private String director;
	
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
	
	public void showDiscInformation() {		
		System.out.print("DVD - [" + title + "]");
		System.out.print(" - [" + category + "]");
		System.out.print(" - [" + director + "]");
		System.out.print(": [" + cost + "]$");
	}

}
