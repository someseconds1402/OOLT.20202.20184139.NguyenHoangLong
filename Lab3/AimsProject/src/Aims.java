
public class Aims {

	public static void main(String[] args) {

		Order anOrder = new Order();

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
		
		System.out.print("\nTotal cost is: ");
		System.out.println(anOrder.totalCost());
		
//		anOrder.removeDigitalVideoDisc("Star Wars");
//		anOrder.removeDigitalVideoDisc(dvd3);
//		
		anOrder.showList();
	}

}
