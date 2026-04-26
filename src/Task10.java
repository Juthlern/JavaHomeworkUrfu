import java.util.List;
import java.util.stream.Collectors;

public class Task10 {
    // Функция, возвращающая числа, которые меньше заданного значения
    public static List<Integer> getNumbersLessThan(List<Integer> numbers, int value) {
        return numbers.stream()
                .filter(n -> n < value)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 5, 10, 15, 20);
        List<Integer> result = getNumbersLessThan(nums, 10);
        System.out.println(result); // [1, 2, 5]
    }
}