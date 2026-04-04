import java.util.HashMap;
import java.util.Map;

public class HashMapTask {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "second");
        map.put(3, "three");
        map.put(4, "fourth");
        map.put(5, "five");
        map.put(6, "sixth");
        map.put(7, "seven");
        map.put(8, "eighth");
        map.put(9, "nine");

        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            if (e.getKey() > 5) {
                System.out.println("key=" + e.getKey() + ", value=" + e.getValue());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            if (e.getKey() == 0) {
                if (sb.length() > 0) sb.append(", ");
                sb.append(e.getValue());
            }
        }
        System.out.println("Строки с ключом = 0: " + sb);

        long product = 1;
        boolean hasAny = false;
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            if (e.getValue().length() > 5) {
                product *= e.getKey();
                hasAny = true;
            }
        }
        if (hasAny) {
            System.out.println("Произведение ключей (len(value) > 5) = " + product);
        } else {
            System.out.println("Строк с длиной > 5 нет");
        }
    }
}