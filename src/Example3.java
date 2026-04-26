import java.util.List;
import java.util.stream.Collectors;

public class Example3 {
    // Функция, возвращающая список строк, начинающихся с большой буквы
    public static List<String> getStringsStartingWithUppercase(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty())                         // убираем пустые строки
                .filter(s -> Character.isUpperCase(s.charAt(0)))   // первая буква заглавная
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Hello", "world", "Java", "stream", "API");
        List<String> result = getStringsStartingWithUppercase(strings);
        System.out.println(result); // [Hello, Java, API]
    }
}