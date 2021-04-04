package hust.soict.hespi.aims;

import hust.soict.hespi.aims.media.Book;
import hust.soict.hespi.aims.media.DigitalVideoDisc;
import hust.soict.hespi.aims.media.Media;
import hust.soict.hespi.aims.order.Order;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Aims {

	public static void main(String[] args) {

		 DigitalVideoDisc dvd1 = new DigitalVideoDisc("Roger Allers",
		 "Animation", "The Lion King", 87, 19.95f);
		
		 DigitalVideoDisc dvd2 = new DigitalVideoDisc("George Lucas",
		 "Science Fiction", "Star Wars", 124, 24.95f);
		
		 DigitalVideoDisc dvd3 = new DigitalVideoDisc("John Musker",
		 "Science Fiction", "Aladdin", 90, 18.99f);
		
		 Book book1 = new Book("Nightmare", "Chemical periodic table",
				 100.0f, "Dmitri Ivanovich Mendeleev");
		
		 Book book2 = new Book("Fiction", "Doraemon", 20.05f, "Fujiko F. Fujio");
		
		 DigitalVideoDisc dvd4 = new DigitalVideoDisc("Bit Bucket","Coder",
		 "Javascipt",66, 15.33f);
		 
		 Order managerOrder = new Order();
		 managerOrder.addMedia(dvd1, dvd2, dvd3, dvd4, book1, book2);
//		 managerOrder.showList();
		 
		
		boolean check = false;
		
		while(check == false) {
			System.out.println();
			System.out.println("Welcome to Order Management Application!\n ");
			System.out.print("Do you want to create new order? Y/N: ");
			Scanner keyboard = new Scanner(System.in);
			String option = keyboard.next();
			
			switch(option) {
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

			Scanner keyboard = new Scanner(System.in);
			String option = keyboard.next();
			
			System.out.println("--------------------------------");
			
			System.out.println();

			switch (option) {
			case "1": {
				System.out.print("Enter title: ");
				String inputString = keyboard.next();
				
				Media something = managerOrder.search(inputString);
				if(something != null) {
					if(newOrder.addMedia(something)) {
						System.out.println("Add item complete!");
					}
					else {
						System.out.println("***Error! Order is full!***");
					}
				}
				else {
					System.out.println("***This item does not exist!***");
				}
				break;
			}
			case "2": {
				System.out.print("Enter ID: ");
				String idString = keyboard.next();

				try {  
				    int id = Integer.parseInt(idString);  
				    if(!newOrder.removeMedia(id)) {
				    	System.out.println("***Error! This item does not exist!***");
				    }
				    else {
				    	System.out.println("Remove complete!");
				    }
				  } catch(NumberFormatException e){  
					  System.out.println("***Invalid Input! Please try again!***");  
				  }  

				break;
			}
			case "3": {
				newOrder.showList();
				break;
			}
			case "0": {
				System.out.println("Goodbye!\n");
				System.exit(1);;
			}
			default:
				System.out.println("***Invalid Input! Please try again!***");
			}
			
//			System.out.println("\n--------------------------------\n");

		}

	}

}
