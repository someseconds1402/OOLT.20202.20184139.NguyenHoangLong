package hust.soict.hespi.aims;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hust.soict.hespi.aims.disc.DigitalVideoDisc;
import hust.soict.hespi.aims.order.Order;

class DiscTest {

	@Test
	void test1() {
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Roger Allers", 
				 "Animation", "The Lion King", 87, 19.95f);
		
		 
		 assertTrue("'Cat' does not exist", dvd1.search("The Cat King"));
		 
		  
	}
	
	@Test
	void test2() {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Roger Allers", 
				 "Animation", "The Lion King", 87, 19.95f);
		
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
		 
		 Order testOrder = new Order();
		 testOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd4, dvd5, dvd6);
		 
		 assertTrue("Must be greater than 0", testOrder.getAluckyItem() >= 0);			
	}

}
