import java.util.Arrays;
import java.util.Scanner;

public class Timus1196 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();      // количество дат у преподавателя
        int[] teacher = new int[n];
        for (int i = 0; i < n; i++) {
            teacher[i] = in.nextInt();
        }

        int m = in.nextInt();      // количество дат у студента
        int[] student = new int[m];
        for (int i = 0; i < m; i++) {
            student[i] = in.nextInt();
        }
        // сортируем обе последовательности
        Arrays.sort(teacher);
        Arrays.sort(student);

        int i = 0;
        int j = 0;
        int common = 0;
        // идём по двум массивам одновременно
        while (i < n && j < m) {
            if (teacher[i] == student[j]) {
                common++;
                i++;
                j++;
            } else if (teacher[i] < student[j]) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println(common);
    }
}