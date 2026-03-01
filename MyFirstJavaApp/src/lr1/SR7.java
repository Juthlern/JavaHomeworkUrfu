package lr1;

import java.util.Scanner;

public class SR7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите текущий год: ");
        int currentYear = in.nextInt();

        System.out.println("Введите возраст: ");
        int age = in.nextInt();

        int birthYear = currentYear - age;

        System.out.println("Год вашего рождения: " + birthYear);

        in.close();
    }
}
