public class Task1 {
    public static void main(String[] args) {
        int x = 1;
        printSeq(x);
    }
    public static void printSeq(int x) {
        System.out.println(x);
        int next = 2 * x + 1;
        if (next < 20) {
            printSeq(next);
        }
    }
}
