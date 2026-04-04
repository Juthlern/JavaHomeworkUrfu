import java.util.Scanner;

public class ArrayRec {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Размер массива: ");
        int n = in.nextInt();
        int[] a = new int[n];

        System.out.println("Введите элементы:");
        fillArrayRec(a, 0, in);

        System.out.println("Массив:");
        printArrayRec(a, 0);
    }
    public static void fillArrayRec(int[] arr, int i, Scanner in) {
        if (i == arr.length) {
            return;
        }
        arr[i] = in.nextInt();
        fillArrayRec(arr, i + 1, in);
    }
    public static void printArrayRec(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }
        System.out.print(arr[i] + " ");
        printArrayRec(arr, i + 1);
    }
}