public class Task3 {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        Thread evenThread = new Thread(new EvenTask(printer), "Чётный поток");
        Thread oddThread = new Thread(new OddTask(printer), "Нечётный поток");

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Печать завершена.");
    }
}

// Класс, который хранит текущее число и даёт методы печати
class NumberPrinter {
    private int number = 1;
    private final int MAX = 10;

    public synchronized void printEven() {
        while (number <= MAX) {
            // если число нечётное, ждём
            while (number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number > MAX) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + ": " + number);
            number++;
            notifyAll(); // будим другой поток
        }
    }

    public synchronized void printOdd() {
        while (number <= MAX) {
            // если число чётное, ждём
            while (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number > MAX) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + ": " + number);
            number++;
            notifyAll(); // будим другой поток
        }
    }
}

class EvenTask implements Runnable {
    private final NumberPrinter printer;

    public EvenTask(NumberPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printEven();
    }
}

class OddTask implements Runnable {
    private final NumberPrinter printer;

    public OddTask(NumberPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printOdd();
    }
}