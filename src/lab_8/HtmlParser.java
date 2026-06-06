package lab_8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlParser {

    public static void main(String[] args) {

        String url = "https://itlearn.ru/first-steps";

        System.out.println("Подключаюсь к сайту: " + url);

        try {
            // ====== 1. Получаем HTML-код страницы ======
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0") // притворяемся браузером
                    .timeout(10000)           // таймаут 10 секунд
                    .get();

            // ====== 2. Ищем все ссылки (<a>) на странице ======
            Elements links = doc.select("a[href]");

            System.out.println("Найдено ссылок: " + links.size());
            System.out.println("\n=== ССЫЛКИ НА СТРАНИЦЕ ===");

            // ====== 3. Выводим каждую ссылку ======
            StringBuilder result = new StringBuilder();
            result.append("Ссылки со страницы ").append(url).append("\n\n");

            for (Element link : links) {
                String text = link.text();      // текст ссылки
                String href = link.attr("abs:href"); // полный URL

                if (!text.isEmpty()) {
                    System.out.println("  • " + text + " → " + href);
                    result.append("  • ").append(text).append(" → ").append(href).append("\n");
                }
            }

            // ====== 4. Сохраняем результат в файл ======
            String outputFile = "src/lab_8/links_result.txt";
            FileWriter writer = new FileWriter(outputFile);
            writer.write(result.toString());
            writer.close();

            System.out.println("\n✅ Результат сохранён в файл: " + outputFile);

        } catch (IOException e) {
            // Обработка ошибки — если сайт недоступен
            System.out.println("❌ Ошибка при подключении к сайту: " + e.getMessage());
            System.out.println("Попробуй перезапустить программу через несколько секунд.");
        }
    }
}