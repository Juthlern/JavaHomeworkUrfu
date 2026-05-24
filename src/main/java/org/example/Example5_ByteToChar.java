package org.example;

import java.io.*;

public class Example5_ByteToChar {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Для демонстрации заранее создадим input.txt
        try (Writer w = new OutputStreamWriter(new FileOutputStream(inputFile), "UTF-8")) {
            w.write("Первая строка\n");
            w.write("Вторая строка");
        } catch (IOException e) {
            System.out.println("Ошибка подготовки входного файла: " + e.getMessage());
        }

        // Чтение с конвертацией байты -> символы
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(new FileInputStream(inputFile), "UTF-8")
                );
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8")
                )
        ) {
            System.out.println("Открыты потоки с кодировкой UTF-8.");
            String line;
            while ((line = br.readLine()) != null) {
                String upper = line.toUpperCase(); // в верхний регистр
                bw.write(upper);
                bw.newLine();
            }
            System.out.println("Данные прочитаны, преобразованы и записаны.");
        } catch (IOException e) {
            System.out.println("Ошибка обработки файлов: " + e.getMessage());
        }

        System.out.println("Программа завершена. Проверьте файл " + outputFile);
    }
}
