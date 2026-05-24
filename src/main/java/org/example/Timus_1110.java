package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Timus_1110 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(); // степень
        int b = in.nextInt(); // модуль
        int c = in.nextInt(); // нужный остаток

        List<Integer> answers = new ArrayList<>();

        for (int x = 0; x < b; x++) {
            if (powMod(x, a, b) == c) {
                answers.add(x);
            }
        }

        if (answers.isEmpty()) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answers.size(); i++) {
                if (i > 0) sb.append(" ");
                sb.append(answers.get(i));
            }
            System.out.println(sb.toString());
        }
    }

    // быстрый расчёт x^a mod b
    private static int powMod(int x, int a, int b) {
        long base = x % b;
        long result = 1;
        int exp = a;

        while (exp > 0) {
            if ((exp & 1) == 1) { // если exp нечётный
                result = (result * base) % b;
            }
            base = (base * base) % b;
            exp >>= 1; // делим exp на 2
        }

        return (int) result;
    }
}