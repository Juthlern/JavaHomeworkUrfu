package lab_8;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Scanner;

public class XmlParser2 {

    private static final String FILE_PATH = "src/lab_8/animals.xml";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== МЕНЮ =====");
            System.out.println("1. Показать всех животных");
            System.out.println("2. Добавить новое животное");
            System.out.println("3. Поиск по виду или возрасту");
            System.out.println("4. Удалить животное по имени");
            System.out.println("5. Выход");
            System.out.print("Выбери: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очищаем после цифры

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

    // ====== ЧИТАЕМ XML И ВОЗВРАЩАЕМ Document ======
    private static Document loadDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(FILE_PATH));
    }

    // ====== СОХРАНЯЕМ Document обратно в XML-файл ======
    private static void saveDocument(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }

    // ====== 1. ПОКАЗАТЬ ВСЕХ ======
    private static void showAllAnimals() throws Exception {
        Document doc = loadDocument();
        NodeList animals = doc.getElementsByTagName("animal");

        if (animals.getLength() == 0) {
            System.out.println("Список пуст!");
            return;
        }

        System.out.println("\n=== Список животных ===");
        for (int i = 0; i < animals.getLength(); i++) {
            Element animal = (Element) animals.item(i);
            System.out.println((i + 1) + ". " +
                    animal.getElementsByTagName("name").item(0).getTextContent() + " | " +
                    animal.getElementsByTagName("species").item(0).getTextContent() + " | " +
                    animal.getElementsByTagName("age").item(0).getTextContent() + " лет");
        }
    }

    // ====== 2. ДОБАВИТЬ НОВОЕ ЖИВОТНОЕ ======
    private static void addAnimal(Scanner scanner) throws Exception {
        Document doc = loadDocument();
        Element root = doc.getDocumentElement();

        System.out.print("Введи имя: ");
        String name = scanner.nextLine();
        System.out.print("Введи вид (напр. Кот, Собака): ");
        String species = scanner.nextLine();
        System.out.print("Введи возраст: ");
        String age = scanner.nextLine();

        // Создаём новый элемент <animal>
        Element newAnimal = doc.createElement("animal");

        Element nameElem = doc.createElement("name");
        nameElem.setTextContent(name);
        newAnimal.appendChild(nameElem);

        Element speciesElem = doc.createElement("species");
        speciesElem.setTextContent(species);
        newAnimal.appendChild(speciesElem);

        Element ageElem = doc.createElement("age");
        ageElem.setTextContent(age);
        newAnimal.appendChild(ageElem);

        // Добавляем в корень
        root.appendChild(newAnimal);
        saveDocument(doc);

        System.out.println("✅ Животное добавлено!");
    }

    // ====== 3. ПОИСК ПО ВИДУ ИЛИ ВОЗРАСТУ ======
    private static void searchAnimal(Scanner scanner) throws Exception {
        Document doc = loadDocument();
        NodeList animals = doc.getElementsByTagName("animal");

        System.out.print("Введи вид животного (или Enter, если неважно): ");
        String searchSpecies = scanner.nextLine();
        System.out.print("Введи возраст (или Enter, если неважно): ");
        String searchAge = scanner.nextLine();

        System.out.println("\n=== Результаты поиска ===");
        boolean found = false;

        for (int i = 0; i < animals.getLength(); i++) {
            Element animal = (Element) animals.item(i);

            String species = animal.getElementsByTagName("species").item(0).getTextContent();
            String age = animal.getElementsByTagName("age").item(0).getTextContent();

            boolean matchesSpecies = searchSpecies.isEmpty() || species.equalsIgnoreCase(searchSpecies);
            boolean matchesAge = searchAge.isEmpty() || age.equals(searchAge);

            if (matchesSpecies && matchesAge) {
                System.out.println("  • " +
                        animal.getElementsByTagName("name").item(0).getTextContent() +
                        " | " + species + " | " + age + " лет");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Ничего не найдено!");
        }
    }

    // ====== 4. УДАЛИТЬ ПО ИМЕНИ ======
    private static void deleteAnimal(Scanner scanner) throws Exception {
        Document doc = loadDocument();
        NodeList animals = doc.getElementsByTagName("animal");

        System.out.print("Введи имя животного для удаления: ");
        String nameToDelete = scanner.nextLine();

        boolean removed = false;

        for (int i = 0; i < animals.getLength(); i++) {
            Element animal = (Element) animals.item(i);
            String name = animal.getElementsByTagName("name").item(0).getTextContent();

            if (name.equalsIgnoreCase(nameToDelete)) {
                animal.getParentNode().removeChild(animal);
                removed = true;
                System.out.println("✅ Животное '" + name + "' удалено!");
                break;
            }
        }

        if (!removed) {
            System.out.println("❌ Животное с именем '" + nameToDelete + "' не найдено!");
        }

        saveDocument(doc);
    }
}