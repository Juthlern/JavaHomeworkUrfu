public class example5 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {  // не подходит
            System.out.println("1");
        } catch (RuntimeException e) {      // подходит
            System.out.println("Перехвачено: " + e.getMessage());
        }
        System.out.println("2"); // теперь до сюда дойдём
    }
}