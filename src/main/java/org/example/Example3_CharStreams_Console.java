package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Example3_CharStreams_Console {
    public static void main(String[] args) {
        String fileName = "example_file_console.txt";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст, который нужно записать в файл:");
        String data = scanner.nextLine(); // читаем строку от пользователя

        // Запись в файл
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(data);
            System.out.println("Данные записаны в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        // Чтение из файла
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            System.out.print("Содержимое файла: ");
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        System.out.println("Программа завершена.");
    }
}
