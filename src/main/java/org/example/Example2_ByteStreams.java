package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example2_ByteStreams {
    public static void main(String[] args) {
        String fileName = "example_file.txt";
        String data = "Hello, byte streams!";

        // Запись в файл
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            System.out.println("Открыт поток для записи в файл: " + fileName);
            byte[] bytes = data.getBytes(); // строка -> массив байт
            fos.write(bytes);
            System.out.println("Данные записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        // Чтение из файла
        try (FileInputStream fis = new FileInputStream(fileName)) {
            System.out.println("Открыт поток для чтения из файла: " + fileName);
            int b;
            System.out.print("Содержимое файла: ");
            while ((b = fis.read()) != -1) { // -1 = конец файла
                System.out.print((char) b);  // байт -> символ
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