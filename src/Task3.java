public class Task3 {
    public static void main(String[] args) {
        task3CaesarCipher();
    }
    public static void task3CaesarCipher() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Введите текст для шифрования:");
        String text = scanner.nextLine();

        System.out.println("Введите ключ (целое число):");
        int key = scanner.nextInt();
        scanner.nextLine();

        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char newChar = (char) (c + key);
            encrypted.append(newChar);
        }
        System.out.println("Текст после преобразования: " + encrypted);

        System.out.println("Выполнить обратное преобразование? (y/n)");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            StringBuilder decrypted = new StringBuilder();
            for (int i = 0; i < encrypted.length(); i++) {
                char c = encrypted.charAt(i);
                char newChar = (char) (c - key);
                decrypted.append(newChar);
            }
            System.out.println("Текст после обратного преобразования: " + decrypted);
        } else if (answer.equalsIgnoreCase("n")) {
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректный ответ");
        }
    }
}