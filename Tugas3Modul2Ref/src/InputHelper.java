import java.util.Scanner;

class InputHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int inputInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Masukkan angka yang valid: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }
}