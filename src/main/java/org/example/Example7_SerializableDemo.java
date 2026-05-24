package org.example;

import java.io.*;

// Класс, который можно сериализовать
class Person implements Serializable {
    private static final long serialVersionUID = 1L; // версия класса

    private String name;
    private int age;
    private double height;

    Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", height=" + height + "}";
    }
}

public class Example7_SerializableDemo {
    public static void main(String[] args) {
        String fileName = "person.bin";

        // Создаем объект
        Person p1 = new Person("Иван", 25, 1.80);

        // Сериализация (запись объекта в файл)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(p1);
            System.out.println("Объект записан в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка сериализации: " + e.getMessage());
        }

        // Десериализация (чтение объекта из файла)
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Person p2 = (Person) ois.readObject();
            System.out.println("Объект прочитан из файла.");
            System.out.println("Содержимое объекта: " + p2);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка десериализации: " + e.getMessage());
        }

        System.out.println("Программа завершена.");
    }
}