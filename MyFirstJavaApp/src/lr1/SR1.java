package lr1;

import java.util.Scanner;

public class SR1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите фамилию: ");
        String lastName = in.nextLine();

        System.out.println("Введите имя: ");
        String firstName = in.nextLine();

        System.out.println("Введите отчество: ");
        String middleName = in.nextLine();

        System.out.println("Hello " + lastName + " " + firstName + " " + middleName);

        in.close();
    }
}
