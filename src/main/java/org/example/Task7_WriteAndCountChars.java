package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task7_WriteAndCountChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла для записи:");
        String fileName = scanner.nextLine();

        System.out.println("Введите текст, который нужно записать в файл:");
        String text = scanner.nextLine();

        int charsCount = text.length();

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(text);
            System.out.println("Текст записан в файл: " + fileName);
            System.out.println("Количество записанных символов: " + charsCount);
        } catch (IOException e) {
            System.out.println("Ошибка при записи: " + e.getMessage());
        }
    }
}
