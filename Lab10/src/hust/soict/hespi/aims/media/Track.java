package hust.soict.hespi.aims.media;

import hust.soict.hespi.aims.PlayerException;

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
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			System.out.println("\tPlaying DVD: " + this.getTitle());
			System.out.println("\tDVD length: " + this.getLength());
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
		
	}
	
}
