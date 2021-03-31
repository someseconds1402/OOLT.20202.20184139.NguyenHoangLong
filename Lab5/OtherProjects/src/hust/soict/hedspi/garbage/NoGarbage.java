package hust.soict.hedspi.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NoGarbage {

	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("");
        try {
            File f = new File("src/hust/soict/hedspi/garbage/garbage.txt");
            Scanner text = new Scanner(f);
            while (text.hasNextLine()) {
                s.append(text);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(s);

	}

}
