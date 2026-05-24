package org.example;

import java.io.File;

public class Example1_FileDemo {
    public static void main(String[] args) {
        // Папка example_folder
        File dir = new File("example_folder");

        // Файл example_file.txt внутри папки
        File file = new File(dir, "example_file.txt");

        // Создаем папку, если её нет
        if (!dir.exists()) {
            boolean createdDir = dir.mkdir();
            System.out.println("Папка создана: " + createdDir);
        } else {
            System.out.println("Папка уже существует");
        }

        // Создаем файл, если его нет
        try {
            if (!file.exists()) {
                boolean createdFile = file.createNewFile();
                System.out.println("Файл создан: " + createdFile);
            } else {
                System.out.println("Файл уже существует");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }

        // Удаляем файл
        if (file.exists()) {
            boolean deletedFile = file.delete();
            System.out.println("Файл удален: " + deletedFile);
        }

        // Удаляем папку
        if (dir.exists()) {
            boolean deletedDir = dir.delete();
            System.out.println("Папка удалена: " + deletedDir);
        }

        System.out.println("Программа завершена.");
    }
}
