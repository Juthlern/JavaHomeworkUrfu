public class Task2 {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 5;
        int[][] a = new int[rows][cols];

        int value = 1;

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    a[i][j] = value++;
                }
            } else {
                for (int j = cols - 1; j >= 0; j--) {
                    a[i][j] = value++;
                }
            }
        }

        System.out.println("Массив, заполненный змейкой:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%3d", a[i][j]);
            }
            System.out.println();
        }
    }
}