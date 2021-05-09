package hust.soict.hespi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	private final int type = 1;

	// Getter and Setter

	public int getType() {
		return type;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	// Constructor

	public Book() {
		super("Unknown", "Noname", 0.0f);
		authors = null;
	}

	public Book(String title) {
		super(title);
	}

	public Book(String title, String category) {
		super(title, category);
	}

	Book(String title, String category, String... authors) {
		super(title, category);
		for (String author : authors) {
			addAthor(author);
		}
	}

	public Book(String title, String category, float cost, String... authors) {
		super(title, category, cost);
		for (String author : authors) {
			addAthor(author);
		}
	}

	// Method

	public void addAthor(String authorName) {
		if (!(authors.contains(authorName))) {
			authors.add(authorName);
		}
	}

	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		}
	}

	public void showBookInfo() {
		System.out.print("Book - [" + title + "]");
		System.out.print(" - [" + category + "] - ");
		System.out.print(authors);
		System.out.print(": [" + cost + "]$");
	}

}
