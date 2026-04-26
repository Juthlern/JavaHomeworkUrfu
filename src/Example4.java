import java.util.List;
import java.util.stream.Collectors;

public class Example4 {
    // Функция, возвращающая список квадратов чисел
    public static List<Integer> getSquares(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * n)                // каждое число заменяем на его квадрат
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        List<Integer> squares = getSquares(nums);
        System.out.println(squares); // [1, 4, 9, 16, 25]
    }
}