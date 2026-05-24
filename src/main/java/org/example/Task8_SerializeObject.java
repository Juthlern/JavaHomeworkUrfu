package org.example;

import java.io.*;
import java.util.Scanner;

// Класс с несколькими полями + Serializable
class MyData implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int number;
    private double value;

    public MyData(String name, int number, double value) {
        this.name = name;
        this.number = number;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", value=" + value +
                '}';
    }
}

public class Task8_SerializeObject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод полей объекта с консоли
        System.out.println("Введите имя (строка):");
        String name = scanner.nextLine();

        System.out.println("Введите целое число:");
        int number = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите вещественное число:");
        double value = Double.parseDouble(scanner.nextLine());

        MyData data = new MyData(name, number, value);
        String fileName = "mydata.bin";

        // Запись объекта в файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
            System.out.println("Объект записан в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сериализации: " + e.getMessage());
        }

        // Чтение объекта из файла
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            MyData restored = (MyData) ois.readObject();
            System.out.println("Объект восстановлен из файла.");
            System.out.println("Значения полей: " + restored);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при десериализации: " + e.getMessage());
        }
    }
}
