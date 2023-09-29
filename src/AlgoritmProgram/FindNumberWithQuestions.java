package AlgoritmProgram;

import java.util.Scanner;

public class FindNumberWithQuestions {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a single argument N.");
            return;
        }

        int N = Integer.parseInt(args[0]);
        int low = 0;
        int high = N - 1;
        int questions = 0;

        Scanner scanner = new Scanner(System.in);

        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("Is the number between " + low + " and " + mid + "? (true/false)");
            boolean response = scanner.nextBoolean();
            questions++;

            if (response) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        scanner.close();

        System.out.println("The number is " + low);
        System.out.println("Total questions asked: " + questions);
    }
}
