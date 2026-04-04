public class Task5 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println("F(" + n + ") = " + fib(n));
    }
    public static int fib(int n) {
        System.out.println("fib(" + n + ") called");

        if (n == 0) {
            System.out.println("fib(" + n + ") returns 0");
            return 0;
        }
        if (n == 1) {
            System.out.println("fib(" + n + ") returns 1");
            return 1;
        }

        int a = fib(n - 1);
        int b = fib(n - 2);
        int res = a + b;

        System.out.println("fib(" + n + ") returns " + res);
        return res;
    }
}