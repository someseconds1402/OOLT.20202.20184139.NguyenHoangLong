package hust.soict.hedspi.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GarbageCreator {
    public static void main(String[] args) {
        String s = "";
        try {
            File f = new File("src/hust/soict/hedspi/garbage/garbage.txt");
            Scanner text = new Scanner(f);
            while (text.hasNextLine()) {
                s += text.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Read string:\n" + s);
    }

}
