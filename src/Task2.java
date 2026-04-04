public class Task2 {
    public static void main(String[] args) {
        int x = 1;
        printSeqReverse(x);
    }
    public static void printSeqReverse(int x) {
        int next = 2 * x + 1;
        if (next < 20) {
            printSeqReverse(next);
        }
        System.out.println(x);
    }
}