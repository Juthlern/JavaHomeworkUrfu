package lab_8;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XmlParser {

    public static void main(String[] args) throws Exception {

        // Указываем путь к XML-файлу
        File xmlFile = new File("src/lab_8/animals.xml");

        // Создаём "читалку" для XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Читаем файл
        Document document = builder.parse(xmlFile);

        // Получаем корневой элемент (<animals>)
        Element root = document.getDocumentElement();
        System.out.println("Корневой элемент: " + root.getNodeName());
        System.out.println("======================");

        // Получаем всех животных
        NodeList animals = document.getElementsByTagName("animal");

        // Проходимся по каждому
        for (int i = 0; i < animals.getLength(); i++) {
            Element animal = (Element) animals.item(i);

            String name = animal.getElementsByTagName("name").item(0).getTextContent();
            String species = animal.getElementsByTagName("species").item(0).getTextContent();
            String age = animal.getElementsByTagName("age").item(0).getTextContent();

            System.out.println("Животное №" + (i + 1));
            System.out.println("  Имя: " + name);
            System.out.println("  Вид: " + species);
            System.out.println("  Возраст: " + age);
            System.out.println("----------------------");
        }
    }
}