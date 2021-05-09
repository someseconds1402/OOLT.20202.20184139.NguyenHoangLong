package hust.soict.hespi.aims;

import hust.soict.hespi.aims.disc.DigitalVideoDisc;
import hust.soict.hespi.aims.order.Order;

public class Aims {

	public static void main(String[] args) {

		 DigitalVideoDisc dvd1 = new DigitalVideoDisc("Roger Allers", 
				 "Animation", "The Lion King", 87, 19.95f);
		 
//		 System.out.println(dvd1.search("King the LION"));;

		 DigitalVideoDisc dvd2 = new DigitalVideoDisc("George Lucas", 
				 "Science Fiction", "Star Wars", 124, 24.95f);

		 DigitalVideoDisc dvd3 = new DigitalVideoDisc("John Musker", 
				 "Science Fiction", "Aladdin", 90, 18.99f);
		 
		 DigitalVideoDisc dvd4 = new DigitalVideoDisc("Dmitri Ivanovich Mendeleev",
				 "Nightmare", "Chemical periodic table",200 ,100.0f);
		 
		 DigitalVideoDisc dvd5 = new DigitalVideoDisc("Fujiko F. Fujio","Fiction", 
				 "Doraemon",8120, 20.05f);
		 
		 DigitalVideoDisc dvd6 = new DigitalVideoDisc("Bit Bucket","Coder",
				 "Javascipt",66, 15.33f);

		// dvd3.showDiscInformation();

		 Order testOrder = new Order();
		 testOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd4, dvd5, dvd6);
		 
		 testOrder.printWithFreeDisc();

	}

}
