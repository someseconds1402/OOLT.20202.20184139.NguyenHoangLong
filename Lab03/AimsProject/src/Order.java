
public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	private int qtyOrdered;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("The order is almost full!");
		} else {
			itemsOrdered[qtyOrdered++] = disc;
			System.out.println("Add disc " + qtyOrdered + " successfully!");
		}

	}

	public float totalCost() {
		float total = 0.0f;
		for (int i = 0; i < qtyOrdered; i++) {
			total = total + itemsOrdered[i].getCost();
		}
		return total;
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		System.out.println();
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == disc) {
				for (int j = i; j < qtyOrdered; j++) {
					itemsOrdered[i] = itemsOrdered[i + 1];
				}
				qtyOrdered--;
				System.out.println("Deleted successfully!");
				return;
			}
		}
		System.out.println("This disc does not exist!");

	}

	public void removeDigitalVideoDisc(String title) {
		System.out.println();
		for (int i = 0; i < qtyOrdered; i++) {
			if (title.equals(itemsOrdered[i].getTitle())) {
				for (int j = i; j < qtyOrdered; j++) {
					itemsOrdered[i] = itemsOrdered[i + 1];
				}
				qtyOrdered--;
				System.out.println("Deleted successfully!");
				return;
			}
		}
		System.out.println("This disc's name does not exist!");
	}

	public void showList() {
		System.out.println("\nList of Discs:\n");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + ".");
			itemsOrdered[i].showDiscInformation();
		}
		System.out.println();
	}

}
