package org.example;

import java.util.Scanner;

public class Timus_1787 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt(); // сколько человек можно обслужить за час
        int n = in.nextInt(); // количество часов

        int queue = 0; // текущий размер очереди

        for (int i = 0; i < n; i++) {
            int came = in.nextInt(); // сколько пришло в этот час
            queue += came;           // добавляем в очередь

            // обслуживаем не больше k человек
            if (queue >= k) {
                queue -= k;
            } else {
                queue = 0;
            }
        }

        System.out.println(queue);
    }
}