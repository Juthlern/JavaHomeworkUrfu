import java.util.Scanner;

public class Timus2001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int sumFirst = 0;
        int sumSecond = 0;

        // В задаче ровно 3 строки ввода
        for (int i = 0; i < 3; i++) {
            int a1 = in.nextInt();
            int b1 = in.nextInt();
            int a2 = in.nextInt();
            int b2 = in.nextInt();

            sumFirst += a1 + b1;
            sumSecond += a2 + b2;
        }

        System.out.println(sumFirst - sumSecond);
    }
}