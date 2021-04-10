package hust.soict.hespi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	private final int type = 3;

	// Getter and Setter

	public int getType() {
		return type;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	// Constructor
	public CompactDisc() {
		super();
	}

	public CompactDisc(String category, String title, float cost) {
		super(category, title, cost);
	}

	public CompactDisc(String category, String title) {
		super(category, title);
	}

	public CompactDisc(String title) {
		super(title);
	}

	public CompactDisc(String artist, String category, String title, float cost, Track... tracks) {
		super(category, title, cost);
		this.artist = artist;
		for (Track track : tracks) {
			this.addTrack(track);
		}
	}

	// Method

	public void addTrack(Track track) {
		if (!(tracks.contains(track))) {
			tracks.add(track);
		}
	}

	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
		}
	}

	public int getLength() {
		return tracks.size();
	}

	public void showCompactDiscInfo() {
		System.out.print("DVD - [" + title + "]");
		System.out.print(" - [" + category + "]");
		System.out.print(" - [" + artist + "]");
		System.out.print(": [" + cost + "]$\n");

		System.out.println("\tTrack: ");
		for (Track track : tracks) {
			track.showTrackInfo();
		}
	}

	@Override
	public void play() {
		System.out.println("Artist: " + this.artist);
		for (Track track : tracks) {
			wait(1000);
			track.play();
		}
	}

	public static void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}
