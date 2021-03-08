import java.util.Scanner;

// Ve tam giac

public class DisplayTriangle {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the height: ");
        int height = keyboard.nextInt();
        int i, j;

        for (i = 1; i <= height; i++) {
            for (j = 1; j < height * 2; j++) {
                if (Math.abs(height - j) <= (i - 1))
                    System.out.print(" * ");
                else
                    System.out.print("   ");
            }
            System.out.print("\n");
        }

    }
}
