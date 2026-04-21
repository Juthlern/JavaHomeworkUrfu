public class example10 {

    public static int m() {
        try {
            System.out.println("0");
            return 15;
        } finally {
            System.out.println("1");
            return 20; // перекрывает return 15
        }
    }

    public static void main(String[] args) {
        System.out.println(m());
        // Вывод:
        // 0
        // 1
        // 20
    }
}