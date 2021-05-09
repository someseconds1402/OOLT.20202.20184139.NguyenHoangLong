package hust.soict.hespi.aims.disc;

public class DigitalVideoDisc {

	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;

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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public boolean setLength(int length) {
		if (length > 0) {
			this.length = length;
			return true;
		} else
			return false;
	}

	public float getCost() {
		return cost;
	}

	public boolean setCost(float cost) {
		if (cost >= 0) {
			this.cost = cost;
			return true;
		} else
			return false;
	}

	public DigitalVideoDisc() {
		this.title = "Noname";
		this.category = "Unknown";
		this.director = "Unknown";
		this.length = 0;
		this.cost = 0.0f;
	}

	public DigitalVideoDisc(String title) {
		this.title = title;
	}

	public DigitalVideoDisc(String category, String title) {
		this.category = category;
		this.title = title;
	}

	public DigitalVideoDisc(String director, String category, String title) {
		this.director = director;
		this.category = category;
		this.title = title;
	}

	public DigitalVideoDisc(String director, String category, String title, int length, float cost) {
		this.director = director;
		this.category = category;
		this.title = title;
		this.length = length;
		this.cost = cost;
	}

	public void showDiscInformation() {
		System.out.print("DVD - [" + title + "]");
		System.out.print(" - [" + category + "]");
		System.out.print(" - [" + director + "]");
		System.out.print(" - [" + length + "]");
		System.out.print(": [" + cost + "]$");
	}

	public boolean search(String title) {
		String[] partsInput = title.toLowerCase().split(" ");
		for (int i = 0; i < partsInput.length; i++) {
			if (this.title.toLowerCase().indexOf(partsInput[i]) == -1) {
				return false;
			}
		}
		return true;
	}
}
