import java.util.Scanner;

public class Timus1020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // количество столбов
        double r = sc.nextDouble(); // радиус

        double[] x = new double[n];
        double[] y = new double[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
        }

        sc.close();

        // длина ломаной: сумма расстояний между соседними точками
        double length = 0.0;
        for (int i = 1; i < n; i++) {
            double dx = x[i] - x[i - 1];
            double dy = y[i] - y[i - 1];
            length += Math.sqrt(dx * dx + dy * dy);
        }

        // добавляем длину окружности 2 * PI * r
        length += 2.0 * Math.PI * r;

        // по условию Timus обычно нужно вывести с точностью 2–3 знака
        System.out.printf("%.2f%n", length);
    }
}