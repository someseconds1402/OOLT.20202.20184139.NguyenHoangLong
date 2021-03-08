import java.util.Scanner;
import java.util.Random;

public class SortArray {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random RandomDigit = new Random();

        int[] IntArray = new int[1000];
        int[] InputArray = new int[1000];
        int i, j, tmp, count = 0, sum = 0;
        float avg = 0f;
        for (i = 0; i < 1000; i++) {
            IntArray[i] = RandomDigit.nextInt(100);
        }

        String Input;
        for (i = 0; i < 1000; i++) {
            System.out.println("\nPress $ to copy the element with similar position. \nPress Q to quit.");
            System.out.print("Array[" + (i + 1) + "] = ");
            Input = keyboard.next();

            if (Input.equals("Q") || Input.equals("q"))
                break;

            else if (Input.equals("$")) {
                InputArray[i] = IntArray[i];
                System.out.print("Array[" + (i + 1) + "] = ");
                System.out.println(InputArray[i] + "  ");
            } else {
                InputArray[i] = Integer.parseInt(Input);
                // System.out.println(InputArray[i] + " ");
            }
            sum += InputArray[i];
            count++;
        }

        for (i = 0; i < count - 1; i++) {
            for (j = i + 1; j < count; j++) {
                if (InputArray[j] < InputArray[i]) {
                    tmp = InputArray[i];
                    InputArray[i] = InputArray[j];
                    InputArray[j] = tmp;
                }
            }
        }

        avg = (float) sum / (float) count;

        System.out.println("\n****************\n");

        System.out.println("Sorted Array: ");

        for (i = 0; i < count; i++) {
            System.out.print(InputArray[i] + "\t");
        }

        System.out.println("\n\nsum = " + sum);
        System.out.println("average = " + avg);

        System.exit(0);
    }
}
