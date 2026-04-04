public class Task3 {
    public static void main(String[] args) {
        int x = 1;
        printWithBeforeAfter(x);
    }
    public static void printWithBeforeAfter(int x) {
        System.out.println("before: " + x);
        int next = 2 * x + 1;
        if (next < 20) {
            printWithBeforeAfter(next);
        }
        System.out.println("after: " + x);
    }
}