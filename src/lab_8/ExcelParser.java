package lab_8;

import java.io.*;
import java.util.Scanner;

public class ExcelParser {

    private static final String FILE_PATH = "src/lab_8/animals.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== МЕНЮ CSV (Excel) =====");
            System.out.println("1. Создать и показать таблицу");
            System.out.println("2. Прочитать таблицу из файла");
            System.out.println("3. Выход");
            System.out.print("Выбери: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createCsvFile();
                case 2 -> readCsvFile();
                case 3 -> {
                    System.out.println("Пока!");
                    return;
                }
                default -> System.out.println("Неверный ввод!");
            }
        }
    }

    // ====== 1. СОЗДАЁМ CSV-ФАЙЛ ======
    private static void createCsvFile() {
        try {
            FileWriter writer = new FileWriter(FILE_PATH);

            // Заголовки
            writer.write("Имя;Вид;Возраст\n");

            // Данные о животных
            writer.write("Барсик;Кот;3\n");
            writer.write("Шарик;Собака;5\n");
            writer.write("Кеша;Попугай;2\n");
            writer.write("Гадя;Кошка;10\n");

            writer.close();
            System.out.println("✅ CSV-файл создан: " + FILE_PATH);

        } catch (IOException e) {
            System.out.println("❌ Ошибка при создании файла: " + e.getMessage());
        }
    }

    // ====== 2. ЧИТАЕМ CSV-ФАЙЛ ======
    private static void readCsvFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;

            System.out.println("\n=== Содержимое CSV-файла ===");

            while ((line = reader.readLine()) != null) {
                // Разделяем строку по точке с запятой
                String[] columns = line.split(";");

                // Выводим красиво
                for (String col : columns) {
                    System.out.printf("%-15s", col);
                }
                System.out.println();
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("❌ Файл не найден! Сначала создай его (пункт 1).");
        } catch (IOException e) {
            System.out.println("❌ Ошибка при чтении файла: " + e.getMessage());
        }
    }
}