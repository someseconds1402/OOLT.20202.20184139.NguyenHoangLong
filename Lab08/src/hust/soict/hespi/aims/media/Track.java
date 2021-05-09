package hust.soict.hespi.aims.media;

public class Track implements Playable {
	private int length;
	private String title;

	// Getter and Setter
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// Constructor
	public Track(int length, String title) {
		super();
		this.length = length;
		this.title = title;
	}

	// Method

	public void showTrackInfo() {
		System.out.println("\t\t+ [" + title + "] - [" + length + "]");
	}

	@Override
	public void play() {
		System.out.println("\tPlaying DVD: " + this.getTitle());
		System.out.println("\tDVD length: " + this.getLength());
	}

	// week 8

	public boolean equals(Object o) {
		if (o instanceof Track) {
			Track track = (Track) o;
			return this.length == track.getLength()
					&& this.title.trim().toLowerCase().equals(track.getTitle().trim().toLowerCase());
		} else {
			return false;
		}
	}

	public int compareTo(Object obj) {
		if (obj instanceof Track) {
			Track tmp = (Track) obj;
			int result = this.getTitle().compareTo(tmp.getTitle());

			if (result < 0) {
				return -1;
			} else if (result == 0) {
				return 0;
			} else {
				return 1;
			}
		}
		return -2;
	}

}
