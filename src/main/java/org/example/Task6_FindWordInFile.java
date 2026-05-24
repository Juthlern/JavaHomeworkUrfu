package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task6_FindWordInFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла:");
        String fileName = scanner.nextLine();

        System.out.println("Введите слово для поиска:");
        String word = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.contains(word)) { // если нужно без регистра: line.toLowerCase().contains(word.toLowerCase())
                    System.out.println("Строка " + lineNumber + ": " + line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Слово \"" + word + "\" не найдено в файле.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
