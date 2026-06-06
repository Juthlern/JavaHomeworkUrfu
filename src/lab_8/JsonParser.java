package lab_8;

import com.google.gson.*;
import java.io.*;
import java.util.*;

public class JsonParser {

    private static final String FILE_PATH = "src/lab_8/animals.json";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== МЕНЮ JSON =====");
            System.out.println("1. Показать всех животных");
            System.out.println("2. Добавить новое животное");
            System.out.println("3. Поиск по виду");
            System.out.println("4. Удалить животное по имени");
            System.out.println("5. Выход");
            System.out.print("Выбери: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showAllAnimals();
                case 2 -> addAnimal(scanner);
                case 3 -> searchAnimal(scanner);
                case 4 -> deleteAnimal(scanner);
                case 5 -> {
                    System.out.println("Пока!");
                    return;
                }
                default -> System.out.println("Неверный ввод!");
            }
        }
    }

    // ====== Читаем JSON-файл ======
    private static JsonObject loadJson() throws Exception {
        FileReader reader = new FileReader(FILE_PATH);
        JsonObject jsonObject = new Gson().fromJson(reader, JsonObject.class);
        reader.close();
        return jsonObject;
    }

    // ====== Сохраняем JSON в файл ======
    private static void saveJson(JsonObject jsonObject) throws Exception {
        FileWriter writer = new FileWriter(FILE_PATH);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(jsonObject, writer);
        writer.close();
    }

    // ====== 1. Показать всех ======
    private static void showAllAnimals() throws Exception {
        JsonObject json = loadJson();
        JsonArray animals = json.getAsJsonArray("animals");

        if (animals.size() == 0) {
            System.out.println("Список пуст!");
            return;
        }

        System.out.println("\n=== Список животных ===");
        for (int i = 0; i < animals.size(); i++) {
            JsonObject animal = animals.get(i).getAsJsonObject();
            System.out.println((i + 1) + ". " +
                    animal.get("name").getAsString() + " | " +
                    animal.get("species").getAsString() + " | " +
                    animal.get("age").getAsInt() + " лет");
        }
    }

    // ====== 2. Добавить ======
    private static void addAnimal(Scanner scanner) throws Exception {
        JsonObject json = loadJson();
        JsonArray animals = json.getAsJsonArray("animals");

        System.out.print("Введи имя: ");
        String name = scanner.nextLine();
        System.out.print("Введи вид: ");
        String species = scanner.nextLine();
        System.out.print("Введи возраст: ");
        int age = scanner.nextInt();

        JsonObject newAnimal = new JsonObject();
        newAnimal.addProperty("name", name);
        newAnimal.addProperty("species", species);
        newAnimal.addProperty("age", age);

        animals.add(newAnimal);
        saveJson(json);

        System.out.println("✅ Животное добавлено!");
    }

    // ====== 3. Поиск по виду ======
    private static void searchAnimal(Scanner scanner) throws Exception {
        JsonObject json = loadJson();
        JsonArray animals = json.getAsJsonArray("animals");

        System.out.print("Введи вид для поиска: ");
        String searchSpecies = scanner.nextLine();

        System.out.println("\n=== Результаты поиска ===");
        boolean found = false;

        for (int i = 0; i < animals.size(); i++) {
            JsonObject animal = animals.get(i).getAsJsonObject();
            String species = animal.get("species").getAsString();

            if (species.equalsIgnoreCase(searchSpecies)) {
                System.out.println("  • " +
                        animal.get("name").getAsString() + " | " +
                        species + " | " +
                        animal.get("age").getAsInt() + " лет");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Ничего не найдено!");
        }
    }

    // ====== 4. Удалить по имени ======
    private static void deleteAnimal(Scanner scanner) throws Exception {
        JsonObject json = loadJson();
        JsonArray animals = json.getAsJsonArray("animals");

        System.out.print("Введи имя для удаления: ");
        String nameToDelete = scanner.nextLine();

        boolean removed = false;
        Iterator<JsonElement> iterator = animals.iterator();

        while (iterator.hasNext()) {
            JsonObject animal = iterator.next().getAsJsonObject();
            if (animal.get("name").getAsString().equalsIgnoreCase(nameToDelete)) {
                iterator.remove();
                removed = true;
                System.out.println("✅ Животное '" + nameToDelete + "' удалено!");
                break;
            }
        }

        if (!removed) {
            System.out.println("❌ Животное '" + nameToDelete + "' не найдено!");
        }

        saveJson(json);
    }
}