package Aims;

import Date.MyDate;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	private int qtyOrdered;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private static MyDate dateOrdered = new MyDate();
	private static final int MAX_LIMTED_ORDERED = 5;
	private static int nbOrders = 0;

	// static{
	// 	dateOrdered.setToCurrentTime();
	// }

	// Getter and Setter:

	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	
	public MyDate getDateOrdered() {
		return dateOrdered;
	}

	public int getNbOrders() {
		return nbOrders;
	}

	public int addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (nbOrders >= MAX_LIMTED_ORDERED) {
			System.out.println("The order is almost full!");
			return -1;
		} else {
			itemsOrdered[nbOrders] = disc;
			System.out.println("Add disc '" + itemsOrdered[nbOrders++].getTitle() + "' successfully!");
			return 1;
		}

	}


	public float totalCost() {
		float total = 0.0f;
		for (int i = 0; i < nbOrders; i++) {
			total = total + itemsOrdered[i].getCost();
		}
		return total;
	}

	// Removing Method:

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		System.out.println();
		for (int i = 0; i < nbOrders; i++) {
			if (itemsOrdered[i] == disc) {
				for (int j = i; j < nbOrders; j++) {
					itemsOrdered[i] = itemsOrdered[i + 1];
				}
				nbOrders--;
				System.out.println("Deleted successfully!");
				return;
			}
		}
		System.out.println("This disc does not exist!");

	}

	public void removeDigitalVideoDisc(String title) {
		System.out.println();
		for (int i = 0; i < nbOrders; i++) {
			if (title.equals(itemsOrdered[i].getTitle())) {
				for (int j = i; j < nbOrders; j++) {
					itemsOrdered[i] = itemsOrdered[i + 1];
				}
				nbOrders--;
				System.out.println("Deleted successfully!");
				return;
			}
		}
		System.out.println("This disc's name does not exist!");
	}

	//

	public void showList() {
		System.out.println("\n***********************Order***********************");
		System.out.print("Date: ");
		dateOrdered.print();
		System.out.println("\nOrder Items:");

		for (int i = 0; i < nbOrders; i++) {
			System.out.print((i + 1) + ".");
			itemsOrdered[i].showDiscInformation();
			System.out.println();
		}
		System.out.println("\nTotla cost: " + totalCost() + "$");
		System.out.println("***************************************************\n");
	}

	// Week 4

	public int addDigitalVideoDisc(DigitalVideoDisc ...dvdList) {
		if(dvdList != null && dvdList.length > 0) {
			for (DigitalVideoDisc dvdPara : dvdList){
				if(addDigitalVideoDisc(dvdPara) == -1){
					System.out.println("Error! Full Ordered Items!");
					return -1;
				}
			}
			return 1;
		}
		else {
			System.out.println("Error!");
			return -1;
		}
	}

	public int addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if(addDigitalVideoDisc(dvd1) == 1) {
			if(addDigitalVideoDisc(dvd2) == -1){
				System.out.println("The disc " + dvd2.getTitle() + " could not be added!");
				return -1;
			}
			else {
				return 1;
			}
		}
		else {
			System.out.println("Error, not enough slot for 2 discs");
			return -1;
		}
	}

	

}
