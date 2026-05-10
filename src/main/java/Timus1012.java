import java.util.Scanner;

public class Timus1012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // длина числа
        int k = in.nextInt(); // основание системы

        if (n == 1) {
            // длина 1, нельзя начинать с 0, значит от 1 до k-1
            System.out.println(k - 1);
            return;
        }

        // используем long, так как количество может быть большим
        long[] dp0 = new long[n + 1];
        long[] dp1 = new long[n + 1];

        // база
        dp0[1] = 0;
        dp1[1] = k - 1;

        for (int i = 2; i <= n; i++) {
            dp0[i] = dp1[i - 1]; // числа длины i, оканчиваются на 0
            dp1[i] = (dp0[i - 1] + dp1[i - 1]) * (k - 1); // оканчиваются не 0
        }

        long result = dp0[n] + dp1[n];
        System.out.println(result);
    }
}