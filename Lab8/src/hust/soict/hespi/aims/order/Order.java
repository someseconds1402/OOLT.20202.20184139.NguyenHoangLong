package hust.soict.hespi.aims.order;

import hust.soict.hespi.aims.media.Book;
import hust.soict.hespi.aims.media.CompactDisc;
import hust.soict.hespi.aims.media.DigitalVideoDisc;
import hust.soict.hespi.aims.media.Media;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order {

	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private final int MAX_ORDERED_NUMBER = 10;
	private final LocalDate today = LocalDate.now();

	public void printType() {
		for (Media media : itemsOrdered) {
			System.out.println(media.getType());
		}
	}

	public int getSize() {
		return itemsOrdered.size();
	}

	public boolean addMedia(Media item) {
		if (itemsOrdered.size() < MAX_ORDERED_NUMBER) {
			itemsOrdered.add(item);
			return true;
		} else {
			return false;
		}
	}

	public boolean addMedia(Media... items) {
		for (Media item : items) {
			if (!addMedia(item)) {
				return false;
			}
		}
		return true;
	}

	public boolean removeMedia(Media item) {
		if (itemsOrdered.size() == 0) {
			return false;
		} else {
			if (itemsOrdered.contains(item)) {
				itemsOrdered.remove(item);
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean removeMedia(int index) {
		if (index < 1 || index > itemsOrdered.size()) {
			return false;
		} else {
			itemsOrdered.remove(index - 1);
			return true;
		}
	}

	public float totalCost() {
		float total = 0;
		for (Media item : itemsOrdered) {
			total += item.getCost();
		}
		return total;
	}

	public Media search(String input, int type) {
		String parts[] = input.toLowerCase().split(" ");
		int count = 0;
		int length = parts.length;

		for (Media item : itemsOrdered) {
			if (item.getType() == type) {
				for (int i = 0; i < length; i++) {
					if (item.getTitle().toLowerCase().indexOf(parts[i]) == -1) {
						break;
					} else {
						count++;
					}
				}
				if (count == length) {
					return item;
				}
			}
		}
		return null;
	}

	public void addItem(Order managerOrder, String inputString, int type) {
		Media something = managerOrder.search(inputString, type);
		if (something != null) {
			if (this.addMedia(something)) {
				System.out.println("Add item complete!");
			} else {
				System.out.println("***Error! Order is full!***");
			}
		} else {
			System.out.println("***This item does not exist!***");
		}
	}

	public void showList() {
		int i = 1;
		System.out.println("\n***********************Order***********************");
		System.out.print("Date: " + today);
		System.out.println("\nOrder Items:");

		for (Media item : itemsOrdered) {
			System.out.print((i++) + ".");
			int type = item.getType();
			if (type == 1) {
				((Book) item).showBookInfo();
			} else if (type == 2) {
				((DigitalVideoDisc) item).showDiscInfo();
			} else if (type == 3) {
				((CompactDisc) item).showCompactDiscInfo();
			}
			System.out.println();
		}
		System.out.println("\nTotal cost: " + totalCost() + "$");
		System.out.println("***************************************************");
	}

}
