package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Example3_CharStreams {
    public static void main(String[] args) {
        String fileName = "example_file.txt";
        String data = "Hello, char streams! Привет!";

        // Запись в файл
        try (FileWriter writer = new FileWriter(fileName)) {
            System.out.println("Открыт FileWriter для записи.");
            writer.write(data);
            System.out.println("Данные записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        // Чтение из файла
        try (FileReader reader = new FileReader(fileName)) {
            System.out.println("Открыт FileReader для чтения.");
            int c;
            System.out.print("Содержимое файла: ");
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        // Удаляем файл
        if (new java.io.File(fileName).delete()) {
            System.out.println("Файл удален.");
        } else {
            System.out.println("Не удалось удалить файл.");
        }

        System.out.println("Программа завершена.");
    }
}
