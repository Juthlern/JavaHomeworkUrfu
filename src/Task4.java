public class Task4 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("factorial(" + n + ") = " + fact(n));
    }
    public static long fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }
}