import java.util.List;
import java.util.stream.Collectors;

public class Task7 {
    // Функция, возвращающая строки, длина которых больше заданного значения
    public static List<String> getStringsLongerThan(List<String> list, int length) {
        return list.stream()
                .filter(s -> s.length() > length)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("hi", "hello", "world", "java", "stream");
        List<String> result = getStringsLongerThan(strings, 3);
        System.out.println(result); // [hello, world, java, stream]
    }
}