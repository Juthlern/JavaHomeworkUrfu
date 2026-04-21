public class example12 {

    public static void m(String str, double chislo) {
        if (str == null) {
            throw new IllegalArgumentException("Строка введена неверно");
        }
        if (chislo > 0.001) {
            throw new IllegalArgumentException("Неверное число");
        }
    }

    public static void main(String[] args) {
        try {
            m(null, 0.000001); // здесь возникнет IllegalArgumentException
            System.out.println("Метод m отработал без ошибок");
        } catch (IllegalArgumentException e) {
            System.out.println("Поймали исключение: " + e.getMessage());
        }

        System.out.println("Программа продолжила работу после обработки ошибки");
    }
}