import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PerfVariant15 {

    // можно уменьшить N, если машине тяжело
    private static final int N = 1_000_000; // формально по варианту: 15_000_000, но у меня не загружается это значение

    public static void main(String[] args) {
        // 1. Добавление в начало
        testAddStart();
        // 2. Добавление в конец
        testAddEnd();
        // 3. Добавление в середину
        testAddMiddle();
        // 4. Удаление в начале
        testRemoveStart();
        // 5. Удаление в конце
        testRemoveEnd();
        // 6. Удаление в середине
        testRemoveMiddle();
        // 7. Получение по индексу
        testGetByIndex();
    }

    // 1. Добавление в начало коллекции
    private static void testAddStart() {
        System.out.println("=== Добавление в начало коллекции ===");

        // ArrayList: вставка в индекс 0
        List<Integer> arrayList = new ArrayList<>();
        long tArrayList = measure(() -> {
            for (int i = 0; i < N; i++) {
                arrayList.add(0, i);
            }
        });
        System.out.println("ArrayList: " + tArrayList + " ms");

        // ArrayDeque: добавление в начало (addFirst)
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        long tArrayDeque = measure(() -> {
            for (int i = 0; i < N; i++) {
                arrayDeque.addFirst(i);
            }
        });
        System.out.println("ArrayDeque: " + tArrayDeque + " ms");

        // TreeSet: понятия "начала" нет, просто добавляем элементы
        Set<Integer> treeSet = new TreeSet<>();
        long tTreeSet = measure(() -> {
            for (int i = 0; i < N; i++) {
                treeSet.add(i);
            }
        });
        System.out.println("TreeSet (вставка): " + tTreeSet + " ms");
        System.out.println();
    }

    // 2. Добавление в конец коллекции
    private static void testAddEnd() {
        System.out.println("=== Добавление в конец коллекции ===");

        // ArrayList: обычный add(i) в конец
        List<Integer> arrayList = new ArrayList<>();
        long tArrayList = measure(() -> {
            for (int i = 0; i < N; i++) {
                arrayList.add(i);
            }
        });
        System.out.println("ArrayList: " + tArrayList + " ms");

        // ArrayDeque: добавление в конец (addLast)
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        long tArrayDeque = measure(() -> {
            for (int i = 0; i < N; i++) {
                arrayDeque.addLast(i);
            }
        });
        System.out.println("ArrayDeque: " + tArrayDeque + " ms");

        // TreeSet: просто add (тоже вставка в отсортированное дерево)
        Set<Integer> treeSet = new TreeSet<>();
        long tTreeSet = measure(() -> {
            for (int i = 0; i < N; i++) {
                treeSet.add(i);
            }
        });
        System.out.println("TreeSet (вставка): " + tTreeSet + " ms");
        System.out.println();
    }

    // 3. Добавление в середину коллекции
    private static void testAddMiddle() {
        System.out.println("=== Добавление в середину коллекции ===");

        // ArrayList: вставка в середину
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) arrayList.add(i);

        // чтобы не ждать час, ограничим количество вставок
        final int operations = 10_000;

        long tArrayList = measure(() -> {
            for (int i = 0; i < operations; i++) {
                arrayList.add(arrayList.size() / 2, -1);
            }
        });
        System.out.println("ArrayList: " + tArrayList + " ms");

        // Для ArrayDeque и TreeSet "середина" не определена, в таблице пишем н/пр
        System.out.println("ArrayDeque: н/пр (нет доступа к середине по индексу)");
        System.out.println("TreeSet: н/пр (множество без индексов)");
        System.out.println();
    }

    // 4. Удаление элемента в начале коллекции
    private static void testRemoveStart() {
        System.out.println("=== Удаление элемента в начале коллекции ===");

        // ArrayList: remove(0) до опустошения
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) arrayList.add(i);

        long tArrayList = measure(() -> {
            while (!arrayList.isEmpty()) {
                arrayList.remove(0);
            }
        });
        System.out.println("ArrayList: " + tArrayList + " ms");

        // ArrayDeque: removeFirst до опустошения
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) arrayDeque.addLast(i);

        long tArrayDeque = measure(() -> {
            while (!arrayDeque.isEmpty()) {
                arrayDeque.removeFirst();
            }
        });
        System.out.println("ArrayDeque: " + tArrayDeque + " ms");

        // TreeSet: удаление минимального элемента (pollFirst) до опустошения
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) treeSet.add(i);

        long tTreeSet = measure(() -> {
            while (!treeSet.isEmpty()) {
                treeSet.pollFirst();
            }
        });
        System.out.println("TreeSet (удаление минимального): " + tTreeSet + " ms");
        System.out.println();
    }

    // 5. Удаление элемента в конце коллекции
    private static void testRemoveEnd() {
        System.out.println("=== Удаление элемента в конце коллекции ===");

        // ArrayList: remove(size-1) до опустошения
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) arrayList.add(i);

        long tArrayList = measure(() -> {
            while (!arrayList.isEmpty()) {
                arrayList.remove(arrayList.size() - 1);
            }
        });
        System.out.println("ArrayList: " + tArrayList + " ms");

        // ArrayDeque: removeLast до опустошения
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) arrayDeque.addLast(i);

        long tArrayDeque = measure(() -> {
            while (!arrayDeque.isEmpty()) {
                arrayDeque.removeLast();
            }
        });
        System.out.println("ArrayDeque: " + tArrayDeque + " ms");

        // TreeSet: удаление максимального элемента (pollLast) до опустошения
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) treeSet.add(i);

        long tTreeSet = measure(() -> {
            while (!treeSet.isEmpty()) {
                treeSet.pollLast();
            }
        });
        System.out.println("TreeSet (удаление максимального): " + tTreeSet + " ms");
        System.out.println();
    }

    // 6. Удаление элемента в середине коллекции
    private static void testRemoveMiddle() {
        System.out.println("=== Удаление элемента из середины коллекции ===");

        // ArrayList: постоянно удаляем элемент из середины
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) arrayList.add(i);

        long tArrayList = measure(() -> {
            while (!arrayList.isEmpty()) {
                arrayList.remove(arrayList.size() / 2);
            }
        });
        System.out.println("ArrayList: " + tArrayList + " ms");

        // Для ArrayDeque и TreeSet середина не определена
        System.out.println("ArrayDeque: н/пр (нет индексов и середины)");
        System.out.println("TreeSet: н/пр (множество без индексов)");
        System.out.println();
    }

    // 7. Получение элемента по индексу
    private static void testGetByIndex() {
        System.out.println("=== Получение элемента по индексу ===");

        // ArrayList: get(i) в цикле
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) arrayList.add(i);

        long tArrayList = measure(() -> {
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += arrayList.get(i);
            }
        });
        System.out.println("ArrayList: " + tArrayList + " ms");

        // Для ArrayDeque и TreeSet доступа по индексу нет
        System.out.println("ArrayDeque: н/пр (нет доступа по индексу)");
        System.out.println("TreeSet: н/пр (нет доступа по индексу)");
        System.out.println();
    }

    // универсальный метод замера времени выполнения блока кода
    private static long measure(Runnable r) {
        long start = System.currentTimeMillis();
        r.run();
        return System.currentTimeMillis() - start;
    }
}