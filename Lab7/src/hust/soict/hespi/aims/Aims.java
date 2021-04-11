package hust.soict.hespi.aims;

import hust.soict.hespi.aims.media.Book;
import hust.soict.hespi.aims.media.CompactDisc;
import hust.soict.hespi.aims.media.DigitalVideoDisc;
import hust.soict.hespi.aims.media.Media;
import hust.soict.hespi.aims.media.Track;
import hust.soict.hespi.aims.order.Order;
import java.util.Scanner;

public class Aims {

	private static Scanner keyboard = new Scanner(System.in);
	private static Order managerOrder = createManageOrder();

	// Main

	public static void main(String[] args) {

		boolean check = false;

		while (check == false) {
			System.out.println();
			System.out.println("Welcome to Order Management Application!\n ");
			System.out.print("Do you want to create new order? Y/N: ");

			String option = keyboard.next();

			switch (option) {
			case "y":
			case "Y":
				System.out.println("\n**Create new order complete!**\n");
				check = true;
				break;
			case "n":
			case "N":
				System.out.println("Goodbye!\n");
				System.exit(0);
			default:
				System.out.println("***Invalid Input! Please try again!***\n");
			}
		}

		Order newOrder = new Order();

		printMenu(newOrder, managerOrder);

	}

	private static Order createManageOrder() {

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Roger Allers", "Animation", "The Lion King", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("George Lucas", "Science Fiction", "Star Wars", 124, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("John Musker", "Science Fiction", "Aladdin", 90, 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Bit Bucket", "Coder", "Javascipt", 66, 15.33f);

		Book book1 = new Book("Nightmare", "Chemical periodic table", 100.0f, "Dmitri Ivanovich Mendeleev");
		Book book2 = new Book("Fiction", "Doraemon", 20.05f, "Fujiko F. Fujio", "Someone1", "Someone2");

		Track track1 = new Track(12, "Hello");
		Track track2 = new Track(10, "Send my love");
		Track track3 = new Track(8, "Someone like you");
		Track track4 = new Track(21, "All i ask");
		Track track5 = new Track(15, "Skyfall");

		CompactDisc album1 = new CompactDisc("Adele", "Classic", "21", 245.55f, track1, track2, track3, track4, track5);

		Order managerOrder = new Order();
		managerOrder.addMedia(dvd1, dvd2, dvd3, dvd4, book1, book2, album1);

		return managerOrder;
	}

	// Print Menu

	public static void printMenu(Order newOrder, Order managerOrder) {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add item to the order");
		System.out.println("2. Delete item by id");
		System.out.println("3. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");

		while (true) {

			System.out.println("\n--------------------------------");
			System.out.print("Please choose a number: ");
			String option = keyboard.next();
			System.out.println("--------------------------------");
			System.out.println();

			switch (option) {
			case "1": {

				int type = addMediaOption(newOrder, managerOrder);
				if (type == 0) {
					break;
				}
				System.out.print("Enter title: ");
				String bufferString = keyboard.nextLine();
				String inputString = keyboard.nextLine();
				newOrder.addItem(managerOrder, inputString, type);
				Media something = managerOrder.search(inputString, type);
				if (something == null) {
					break;
				}

				if (type == 2 || type == 3) {

					System.out.println("Do you want to play this CD/DVD? Y : N");
					System.out.print("Your option: ");

					String check = keyboard.nextLine();
					switch (check) {
					case "y":
					case "Y":
						nowPlaying();
						if (type == 2) {
							((DigitalVideoDisc) something).play();
						} else if (type == 3) {
							((CompactDisc) something).play();
						}
						break;
					case "n":
					case "N":
						break;
					default:
						System.out.println("***Invalid Input! Return Menu!***\n");
					}
				}

				break;
			}
			case "2": {
				System.out.print("Enter ID: ");
				String idString = keyboard.next();

				try {
					int id = Integer.parseInt(idString);
					if (!newOrder.removeMedia(id)) {
						System.out.println("***Error! This item does not exist!***");
					} else {
						System.out.println("Remove complete!");
					}
				} catch (NumberFormatException e) {
					System.out.println("***Invalid Input! Return Menu!***");
				}

				break;
			}
			case "3": {
				newOrder.showList();
				break;
			}
			case "0": {
				System.out.println("Goodbye!\n");
				System.exit(1);
				;
			}
			default:
				System.out.println("***Invalid Input! Return Menu!***");
			}
		}
	}

	// Option add items

	public static int addMediaOption(Order newOrder, Order managerOrder) {
		System.out.println("Choose the type of item:");
		System.out.println("1. Book");
		System.out.println("2. Digital VIdeo Disc");
		System.out.println("3. Compact Disc");
		System.out.print("Your option: ");

		String option = keyboard.next();
		switch (option) {
		case "1":
		case "2":
		case "3":
			return Integer.parseInt(option);
		default:
			System.out.println("***Invalid Input! Return Menu!***\n");
			return 0;
		}
	}

	public static void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public static void nowPlaying() {
		System.out.print(".");
		wait(500);
		System.out.print(".");
		wait(500);
		System.out.print(".");
		wait(500);
		System.out.print("Now Playing");
		wait(500);
		System.out.print(".");
		wait(500);
		System.out.print(".");
		wait(500);
		System.out.print(".");
		wait(500);
		System.out.println();
	}

}
