import java.util.Scanner;

public class Timus1014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        if (n == 0) {
            System.out.println(10);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }

        // Будем разлагать n на множители-цифры от 9 до 2
        StringBuilder digitsReversed = new StringBuilder();

        for (int d = 9; d >= 2; d--) {
            while (n % d == 0) {
                n /= d;
                digitsReversed.append(d);
            }
        }

        // Если после разложения n != 1, значит представить нельзя
        if (n != 1) {
            System.out.println(-1);
            return;
        }

        // digitsReversed хранит цифры в обратном порядке (от больших к маленьким множителям),
        // перевернём, чтобы получить минимально возможное число
        System.out.println(digitsReversed.reverse().toString());
    }
}