package lab_8;

import java.util.Scanner;

public class Timus1313 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Проходим по всем диагоналям
        for (int sum = 0; sum < 2 * n - 1; sum++) {
            for (int i = 0; i < n; i++) {
                int j = sum - i;
                if (j >= 0 && j < n) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }
}
