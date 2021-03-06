package hust.soict.hespi.aims.media;

import java.util.ArrayList;
import java.util.Collection;

public class TestMediaCompareTo {
    public static void main(String[] args) {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Roger Allers", "Animation", "The Lion King", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("George Lucas", "Science Fiction", "Star Wars", 124, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("John Musker", "Science Fiction", "Aladdin", 90, 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Bit Bucket", "Coder", "Javascript", 66, 15.33f);

		Book book1 = new Book("Nightmare", "Chemical periodic table", 100.0f, "Dmitri Ivanovich Mendeleev");
		Book book2 = new Book("Fiction", "Doraemon", 20.05f, "Fujiko F. Fujio", "Someone1", "Someone2");

		Track track1 = new Track(12, "Hello");
		Track track2 = new Track(10, "Send my love");
		Track track3 = new Track(8, "Someone like you");
		Track track4 = new Track(21, "All i ask");
		Track track5 = new Track(15, "Skyfall");

		CompactDisc compactDisc1 = new CompactDisc("Adele", "Classic", "21", 245.55f, track1, track2, track3, track4, track5);

        java.util.Collection collection = new java.util.ArrayList();
        collection.add(dvd1);
        collection.add(dvd2);
        collection.add(dvd3);
        collection.add(dvd4);
        collection.add(book1);
        collection.add(book2);
        collection.add(compactDisc1);

        java.util.Iterator iterator = collection.iterator();

        System.out.println("----------------------------------------");
        System.out.println("The Items currently in the order are:");

        while(iterator.hasNext()){
            System.out.println(((Media)iterator.next()).getTitle());
        }

        System.out.println("*");

        java.util.Collections.sort((java.util.List)collection);
        
        System.out.println("*");

        iterator = collection.iterator();
        System.out.println("*");

        System.out.println("----------------------------------------");
        System.out.println("The Items in sorted the order are:");
        System.out.println("*");

        while(iterator.hasNext()){
            System.out.println(((Media)iterator.next()).getTitle());
        }
        System.out.println("*");

        System.out.println("----------------------------------------");

        
    }

}
