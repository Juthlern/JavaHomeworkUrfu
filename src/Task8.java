import java.util.List;
import java.util.stream.Collectors;

public class Task8 {
    // Функция, возвращающая числа, которые больше заданного значения
    public static List<Integer> getNumbersGreaterThan(List<Integer> numbers, int value) {
        return numbers.stream()
                .filter(n -> n > value)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 5, 10, 15, 20);
        List<Integer> result = getNumbersGreaterThan(nums, 5);
        System.out.println(result); // [10, 15, 20]
    }
}