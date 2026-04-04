import java.util.Scanner;

public class ToBinaryRec {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int n = in.nextInt();
        if (n == 0) {
            System.out.println("0");
        } else {
            toBinary(n);
            System.out.println();
        }
    }
    public static void toBinary(int n) {
        if (n == 0) {
            return;
        }
        toBinary(n / 2);
        System.out.print(n % 2);
    }
}