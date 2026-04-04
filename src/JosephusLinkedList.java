import java.util.LinkedList;
import java.util.List;

public class JosephusLinkedList {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Выживший (LinkedList): " + josephus(n));
    }
    public static int josephus(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}