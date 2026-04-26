import java.util.List;
import java.util.stream.Collectors;

public class Task9 {
    // Функция, возвращающая строки, состоящие только из букв
    public static List<String> getAlphabeticStrings(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty())                         // убираем пустые строки
                .filter(s -> s.chars().allMatch(Character::isLetter))
                // s.chars() -> поток символов, allMatch проверяет, что каждый символ - буква
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Hello", "world123", "Java", "stream!", "Привет", "");
        List<String> result = getAlphabeticStrings(strings);
        System.out.println(result); // [Hello, Java, Привет]
    }
}