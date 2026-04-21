public class example6 {
    public static void main(String[] args) {
        /*
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (ArithmeticException e) {
            System.out.println("1");
        } catch (Exception e) {          // предок для RuntimeException
            System.out.println("2");
        } catch (RuntimeException e) {   // до этого catch программа никогда не дойдёт
            System.out.println("3");
        }
        System.out.println("4");
        */
        System.out.println("Этот пример не компилируется: предок (Exception) стоит выше потомка (RuntimeException).");
    }
}