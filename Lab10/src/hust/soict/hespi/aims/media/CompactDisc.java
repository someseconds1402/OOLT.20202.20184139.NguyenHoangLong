package hust.soict.hespi.aims.media;

import java.util.ArrayList;

import hust.soict.hespi.aims.PlayerException;
import javafx.scene.control.CheckBox;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	private final int type = 3;
	protected CheckBox selected;

	// Getter and Setter

	public int getType() {
		return type;
	}

	public String getArtist() {
		return artist;
	}

	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public CheckBox getSelected() {
		return selected;
	}

	public void setSelected(CheckBox selected) {
		this.selected = selected;
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
		System.out.print("CD - [" + title + "]");
		System.out.print(" - [" + category + "]");
		System.out.print(" - [" + artist + "]");
		System.out.print(": [" + cost + "]$\n");

		System.out.println("\tTrack: ");
		for (Track track : tracks) {
			track.showTrackInfo();
		}
	}

	@Override
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			System.out.println("Artist: " + this.artist);
			for (Track track : tracks) {
				try {
//					tracks.get(tracks.indexOf(track) + 1);
					track.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
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
