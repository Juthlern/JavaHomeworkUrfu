package lr1;

import java.util.Scanner;

public class SR6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя: ");
        String name = in.nextLine();

        System.out.println("Введите год рождения: ");
        int birthYear = in.nextInt();

        System.out.println("Введите текущий год: ");
        int currentYear = in.nextInt();

        int age = currentYear - birthYear;

        System.out.println("Пользователь " + name + ", возраст: " + age);

        in.close();
    }
}
