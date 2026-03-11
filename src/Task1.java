public static void task1MinArray() {
    int n = 10;
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
        arr[i] = (int) (Math.random() * 10);
    }

    IO.println("Массив:");
    for (int i = 0; i < n; i++) {
        IO.print(arr[i] + " ");
    }
    IO.println();

    int min = arr[0];
    for (int i = 1; i < n; i++) {
        if (arr[i] < min) {
            min = arr[i];
        }
    }

    IO.println("Минимальное значение: " + min);
    IO.print("Индексы минимальных элементов: ");

    for (int i = 0; i < n; i++) {
        if (arr[i] == min) {
            IO.print(i + " ");
        }
    }
    IO.println();
}

void main() {
    task1MinArray();
}
