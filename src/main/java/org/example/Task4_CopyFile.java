package org.example;

import java.io.*;
import java.util.Scanner;

public class Task4_CopyFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя исходного файла:");
        String sourceFile = scanner.nextLine();

        System.out.println("Введите имя файла, в который нужно скопировать данные:");
        String destFile = scanner.nextLine();

        try (
                BufferedReader br = new BufferedReader(new FileReader(sourceFile));
                BufferedWriter bw = new BufferedWriter(new FileWriter(destFile))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine(); // чтобы сохранялись переносы строк
            }
            System.out.println("Копирование завершено.");
        } catch (IOException e) {
            System.out.println("Ошибка при копировании: " + e.getMessage());
        }
    }
}
