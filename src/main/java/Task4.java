public class Task4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            final int threadNumber = i; // чтобы правильно захватить переменную
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Я поток номер " + threadNumber);
                }
            }, "Поток-" + i);
            t.start();
        }

        // Для простоты не ждём join для всех,
        // но в реальном коде можно сохранить их в список и join-ить.
    }
}