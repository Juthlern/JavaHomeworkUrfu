package org.example;

import java.io.File;
import java.util.Scanner;

public class Task5_FileSize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла:");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        if (file.exists() && file.isFile()) {
            long size = file.length(); // размер в байтах
            System.out.println("Размер файла " + fileName + ": " + size + " байт");
        } else {
            System.out.println("Файл не существует или это не файл.");
        }
    }
}
