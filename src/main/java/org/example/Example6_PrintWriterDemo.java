package org.example;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Example6_PrintWriterDemo {
    public static void main(String[] args) {
        String fileName = "printwriter_example.txt";

        // Запись в файл с указанием кодировки
        try (PrintWriter pw = new PrintWriter(fileName, "UTF-8")) {
            pw.println("Первая строка, записанная через PrintWriter.");
            pw.print("Вторая строка без перевода строки. ");
            pw.println("Теперь с переводом.");
            System.out.println("Данные записаны в файл " + fileName);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Ошибка при работе с PrintWriter: " + e.getMessage());
        }

        // Использование PrintWriter для консоли (необязательно, просто пример)
        try (PrintWriter console = new PrintWriter(System.out, true)) {
            console.println("Это вывод через PrintWriter в консоль.");
        }

        System.out.println("Программа завершена.");
    }
}