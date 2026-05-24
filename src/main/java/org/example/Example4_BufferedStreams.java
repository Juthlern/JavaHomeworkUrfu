package org.example;

import java.io.*;

public class Example4_BufferedStreams {
    public static void main(String[] args) {
        String fileName = "example_file.txt";
        String data = "Строка, записанная через BufferedWriter.";

        // Запись с буфером
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Открыт BufferedWriter.");
            bw.write(data);
            bw.newLine(); // перевод строки
            bw.write("Вторая строка.");
            System.out.println("Данные записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        // Чтение с буфером
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Открыт BufferedReader.");
            String line;
            System.out.println("Содержимое файла:");
            while ((line = br.readLine()) != null) { // читаем по строкам
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        // Удаление файла
        if (new File(fileName).delete()) {
            System.out.println("Файл удален.");
        } else {
            System.out.println("Не удалось удалить файл.");
        }

        System.out.println("Программа завершена.");
    }
}
