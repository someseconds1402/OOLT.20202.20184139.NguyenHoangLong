package hust.soict.hespi.aims.media;

public abstract class Media implements Comparable{
	protected String title;
	protected String category;
	protected float cost;
	protected static int id = 0;

	// Constructor

	public Media() {
		id++;
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
		this.category = category;
		this.title = title;
		this.cost = cost;
	}

	// Getter and Setter

	public int getID() {
		return id;
	}

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

	public int getType() {
		if (this instanceof Book) {
			return 1;
		} else if (this instanceof DigitalVideoDisc) {
			return 2;
		} else {
			return 3;
		}
	}

	// week 8

	public boolean equals(Object o) {
		if (o instanceof Media) {
			int id = ((Media) o).getID();
			if (this.getID() == id) {
				return true;
			} else
				return true;
		} else {
			return false;
		}
	}

	public int compareTo(Object obj) {
		if (obj instanceof Media) {
			Media tmp = (Media) obj;
			float result = this.getCost() - tmp.getCost();

			if (result < 0) {
				return -1;
			} else if (result == 0) {
				return 0;
			} else {
				return 1;
			}
		}
		return -999999999;
	}

}
