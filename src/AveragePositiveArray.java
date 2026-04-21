import java.util.InputMismatchException;
import java.util.Scanner;

public class AveragePositiveArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Введите длину массива: ");
            int n = sc.nextInt(); // тут может быть InputMismatchException

            if (n <= 0) {
                throw new IllegalArgumentException("Длина массива должна быть > 0");
            }

            int[] arr = new int[n];
            System.out.println("Введите элементы массива (int):");

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt(); // тут тоже может быть InputMismatchException
            }

            int sum = 0;
            int count = 0;
            for (int x : arr) {
                if (x > 0) {
                    sum += x;
                    count++;
                }
            }

            if (count == 0) {
                throw new RuntimeException("Положительные элементы отсутствуют");
            }

            double avg = (double) sum / count;
            System.out.println("Среднее среди положительных = " + avg);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось целое число");
        } catch (IllegalArgumentException e) {
            System.out.println("Неверный аргумент: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Логическая ошибка: " + e.getMessage());
        } finally {
            System.out.println("Программа завершила работу (finally).");
            sc.close();
        }
    }
}