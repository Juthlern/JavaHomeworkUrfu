public class Task1 {
    public static void main(String[] args) {
        // Создаём Runnable – что будет делать поток
        Runnable task = new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis(); // время старта
                while (System.currentTimeMillis() - start < 10_000) { // 10 секунд
                    String threadName = Thread.currentThread().getName();
                    long currentTime = System.currentTimeMillis();
                    System.out.println("Поток: " + threadName + ", время: " + currentTime);
                    try {
                        Thread.sleep(1000); // пауза 1 секунда
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        // Создаём два потока, которые выполняют одну и ту же задачу
        Thread t1 = new Thread(task, "Первый поток");
        Thread t2 = new Thread(task, "Второй поток");
        // Запускаем потоки
        t1.start();
        t2.start();
        // Ждём окончания потоков (не обязательно, но правильно)
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Главный поток завершён.");
    }
}