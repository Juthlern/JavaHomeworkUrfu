import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Введите количество строк: ");
            int n = sc.nextInt();
            System.out.print("Введите количество столбцов: ");
            int m = sc.nextInt();

            if (n <= 0 || m <= 0) {
                throw new IllegalArgumentException("Размеры матрицы должны быть > 0");
            }

            int[][] a = new int[n][m];
            System.out.println("Введите элементы матрицы (int):");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            System.out.print("Введите номер столбца (0.." + (m - 1) + "): ");
            int col = sc.nextInt();

            if (col < 0 || col >= m) {
                throw new ArrayIndexOutOfBoundsException("Нет столбца с таким номером");
            }

            System.out.println("Столбец " + col + ":");
            for (int i = 0; i < n; i++) {
                System.out.println(a[i][col]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число");
        } catch (IllegalArgumentException e) {
            System.out.println("Неверный размер: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка индекса: " + e.getMessage());
        } finally {
            System.out.println("Работа программы завершена.");
            sc.close();
        }
    }
}