package Aims;


public class Aims {

	public static void main(String[] args) {

		Order anOrder = new Order();
		// addDiscTest(anOrder);

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		anOrder.addDigitalVideoDisc(dvd1);

		// dvd1.showDiscInformation();

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		anOrder.addDigitalVideoDisc(dvd2);

		// dvd2.showDiscInformation();

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
		dvd3.setCategory("Science Fiction");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		anOrder.addDigitalVideoDisc(dvd3);

		// dvd3.showDiscInformation();

		DigitalVideoDisc[] testOrder = new DigitalVideoDisc[3];
		testOrder[0] = dvd1;
		testOrder[1] = dvd2;
		testOrder[2] = dvd3;

		Order anotherOrder = new Order();
		anotherOrder.addDigitalVideoDisc(dvd1, dvd2);
		anotherOrder.addDigitalVideoDisc(testOrder);
		anotherOrder.addDigitalVideoDisc(testOrder);
		anotherOrder.addDigitalVideoDisc(testOrder);
		anotherOrder.addDigitalVideoDisc(testOrder);

		// System.out.println(anOrder.getNbOrders());;

		// anOrder.showList();
	}

	// @Test
	// public static void addDiscTest (Order list) {
	// DigitalVideoDisc dvd1 = new DigitalVideoDisc("Roger Allers","Animation","The
	// Lion King",87,19.95f);
	// DigitalVideoDisc dvd2 = new DigitalVideoDisc("Wayler Biket","Fiction","Hey
	// guys",87,19.95f);
	// DigitalVideoDisc dvd3 = new DigitalVideoDisc("Bit
	// Bucket","Coder","Javascipt",87,19.95f);
	// int check = list.addDigitalVideoDisc(dvd1, dvd2, dvd3);
	// assertTrue(check == -1, "Not enough slot!");
	// assertTrue(check == 1, "Complete!");
	// }

}
