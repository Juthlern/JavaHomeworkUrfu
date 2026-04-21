public class example13 {
    public static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("размер массива= " + l);
            int h = 10 / l;          // если l == 0 → ArithmeticException
            args[l + 1] = "10";      // выход за границы → ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс не существует");
        }
    }
}