public class example7 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
            // здесь мы выбрасываем НОВОЕ исключение
            throw new ArithmeticException();
        }
        // В реальном коде ниже уже не будет работать, т.к. до него не дойдём.
        // В учебном примере хотели показать:
        // то, что брошено внутри catch, НЕЛЬЗЯ поймать catch'ем из того же try ниже.
    }
}