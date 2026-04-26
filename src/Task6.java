import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

public class Task6 {
    // Функция, возвращающая числа, которые делятся на divisor без остатка
    public static List<Integer> getDivisibleBy(List<Integer> numbers, int divisor) {
        if (divisor == 0) {
            // На ноль делить нельзя, вернём пустой список
            return Collections.emptyList();
        }

        return numbers.stream()
                .filter(n -> n % divisor == 0)   // делится без остатка
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 10, 12, 15);
        List<Integer> result = getDivisibleBy(nums, 3);
        System.out.println(result); // [3, 6, 12, 15]
    }
}