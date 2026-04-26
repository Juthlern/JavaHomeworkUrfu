import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    // Функция, возвращающая строки, которые содержат заданную подстроку
    public static List<String> getStringsContainingSubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))  // строка содержит подстроку
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("hello", "world", "hell", "java", "stream");
        List<String> result = getStringsContainingSubstring(strings, "hell");
        System.out.println(result); // [hello, hell]
    }
}