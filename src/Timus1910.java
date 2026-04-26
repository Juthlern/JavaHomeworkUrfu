import java.util.Scanner;

public class Timus1910 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        // Ищем максимум суммы трёх подряд и индекс среднего блока
        int maxSum = Integer.MIN_VALUE;
        int middleIndex = 0; // индекс среднего блока (1-based)

        // Перебираем все "тройки": (i, i+1, i+2)
        for (int i = 0; i <= n - 3; i++) {
            int sum = a[i] + a[i + 1] + a[i + 2];

            if (sum > maxSum) {
                maxSum = sum;
                middleIndex = i + 2; // средний в тройке (i+1), но +1 для 1-based: (i+1)+1 = i+2
            }
        }

        System.out.println(maxSum + " " + middleIndex);
    }
}