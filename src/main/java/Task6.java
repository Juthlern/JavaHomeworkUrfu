public class Task6 {
    public static void main(String[] args) {
        int[] array = {5, 9, 1, 3, 100, 7, 20, 50, 2, 99};

        long sum = parallelSum(array);
        System.out.println("Сумма: " + sum);
    }

    public static long parallelSum(int[] array) {
        int processors = Runtime.getRuntime().availableProcessors();
        if (processors <= 0) {
            processors = 1;
        }

        int length = array.length;
        int chunkSize = (int) Math.ceil((double) length / processors);

        Thread[] threads = new Thread[processors];
        SumWorker[] workers = new SumWorker[processors];

        for (int i = 0; i < processors; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, length);

            if (start >= end) {
                workers[i] = new SumWorker(new int[0], 0, 0);
                continue;
            }

            workers[i] = new SumWorker(array, start, end);
            threads[i] = new Thread(workers[i], "SumWorker-" + i);
            threads[i].start();
        }

        // Ждём все потоки
        for (int i = 0; i < processors; i++) {
            if (threads[i] != null) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        long total = 0;
        for (SumWorker worker : workers) {
            if (worker == null) continue;
            total += worker.getLocalSum();
        }

        return total;
    }
}

// Поток, который считает сумму своего куска массива
class SumWorker implements Runnable {
    private final int[] array;
    private final int start;
    private final int end;
    private long localSum = 0;

    public SumWorker(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public long getLocalSum() {
        return localSum;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        localSum = sum;
    }
}