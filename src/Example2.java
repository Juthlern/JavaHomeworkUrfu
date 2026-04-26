import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Example2 {
    // Функция, возвращающая массив общих элементов двух массивов
    public static int[] getCommonElements(int[] a, int[] b) {
        // Помещаем элементы второго массива в множество
        Set<Integer> setB = Arrays.stream(b)
                .boxed()
                .collect(Collectors.toSet());

        // Фильтруем элементы первого массива по наличию во втором
        return Arrays.stream(a)
                .filter(setB::contains)
                .toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};
        int[] common = getCommonElements(arr1, arr2);
        System.out.println(Arrays.toString(common)); // [3, 4, 5]
    }
}