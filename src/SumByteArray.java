import java.util.InputMismatchException;
import java.util.Scanner;

public class SumByteArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Введите количество элементов массива: ");
            int n = sc.nextInt();

            if (n <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть > 0");
            }

            byte[] arr = new byte[n];
            System.out.println("Введите элементы массива (byte от -128 до 127):");

            for (int i = 0; i < n; i++) {
                int tmp = sc.nextInt(); // читаем как int
                if (tmp < -128 || tmp > 127) {
                    throw new ArithmeticException("Значение " + tmp + " выходит за диапазон byte");
                }
                arr[i] = (byte) tmp;
            }

            int sum = 0;
            for (byte b : arr) {
                sum += b; // здесь может быть выход суммы за пределы int? маловероятно
            }

            System.out.println("Сумма элементов (как int) = " + sum);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось число");
        } catch (IllegalArgumentException e) {
            System.out.println("Неверный размер массива: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка диапазона: " + e.getMessage());
        } finally {
            System.out.println("Программа завершена (finally).");
            sc.close();
        }
    }
}