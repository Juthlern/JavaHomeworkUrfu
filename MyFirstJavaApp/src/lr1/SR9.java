package lr1;

import java.util.Scanner;

public class SR9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число: ");
        int n = in.nextInt();

        int a = n - 1;
        int b = n;
        int c = n + 1;

        int sum = a + b + c;
        int d = sum * sum; // квадрат суммы

        System.out.println("Первое число: " + a);
        System.out.println("Второе число: " + b);
        System.out.println("Третье число: " + c);
        System.out.println("Четвертое число (квадрат суммы первых трех): " + d);

        in.close();
    }
}
