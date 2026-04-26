import java.util.Arrays;

public class Example1 {
    // Функция, возвращающая массив чётных чисел
    public static int[] getEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)          // создаём поток из массива
                .filter(n -> n % 2 == 0)       // оставляем только чётные
                .toArray();                    // собираем обратно в массив
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] evens = getEvenNumbers(arr);
        System.out.println(Arrays.toString(evens)); // [2, 4, 6]
    }
}