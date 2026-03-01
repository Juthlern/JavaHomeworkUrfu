package Timus;

import java.util.Scanner;

public class Task1293 {public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int a = in.nextInt();
    int result = 2 * n * m * a;
    System.out.println(result);
    in.close();
    }
}
