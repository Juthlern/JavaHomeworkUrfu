public class example2 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
            // System.out.println("1");  // недостижимый код (так лучше закомментировать)
        } catch (Exception e) {  // перехватываем предком
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }
}