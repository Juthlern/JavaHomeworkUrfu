package lr1;

import java.util.Scanner;

public class SR5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите год рождения: ");
        int birthYear = in.nextInt();

        System.out.println("Введите текущий год: ");
        int currentYear = in.nextInt();

        int age = currentYear - birthYear;

        System.out.println("Ваш возраст: " + age);

        in.close();
    }
}
