public class Task5 {
    public static void main(String[] args) {
        int[] array = {5, 9, 1, 3, 100, 7, 20, 50, 2, 99};

        int max = parallelMax(array);
        System.out.println("Максимум: " + max);
    }

    public static int parallelMax(int[] array) {
        int processors = Runtime.getRuntime().availableProcessors();
        if (processors <= 0) {
            processors = 1;
        }

        int length = array.length;
        int chunkSize = (int) Math.ceil((double) length / processors);

        Thread[] threads = new Thread[processors];
        MaxWorker[] workers = new MaxWorker[processors];

        for (int i = 0; i < processors; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, length);

            if (start >= end) {
                // если элементов меньше, чем потоков
                workers[i] = new MaxWorker(new int[0], 0, 0);
                continue;
            }

            workers[i] = new MaxWorker(array, start, end);
            threads[i] = new Thread(workers[i], "MaxWorker-" + i);
            threads[i].start();
        }

        // Ждём окончания всех потоков
        for (int i = 0; i < processors; i++) {
            if (threads[i] != null) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Находим максимум среди частичных максимумов
        Integer globalMax = null;
        for (MaxWorker worker : workers) {
            if (worker == null) continue;
            if (worker.getLocalMax() == null) continue;

            if (globalMax == null || worker.getLocalMax() > globalMax) {
                globalMax = worker.getLocalMax();
            }
        }

        // На всякий случай, если массив пустой
        return globalMax == null ? Integer.MIN_VALUE : globalMax;
    }
}

// Поток, который ищет максимум на своём участке массива
class MaxWorker implements Runnable {
    private final int[] array;
    private final int start;
    private final int end;
    private Integer localMax = null;

    public MaxWorker(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public Integer getLocalMax() {
        return localMax;
    }

    @Override
    public void run() {
        if (start >= end) {
            localMax = null;
            return;
        }
        int max = array[start];
        for (int i = start + 1; i < end; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        localMax = max;
    }
}