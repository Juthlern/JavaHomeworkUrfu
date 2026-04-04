public class MyListDemo {
    public static void main(String[] args) {
        MyList list = new MyList();

        list.createTail(new int[]{1, 2, 3});
        System.out.println("Начальный список: " + list);

        list.addFirst(0);
        System.out.println("После addFirst(0): " + list);

        list.addLast(4);
        System.out.println("После addLast(4): " + list);

        list.insert(2, 99);
        System.out.println("После insert(2, 99): " + list);

        list.removeFirst();
        System.out.println("После removeFirst(): " + list);

        list.removeLast();
        System.out.println("После removeLast(): " + list);

        list.remove(1);
        System.out.println("После remove(1): " + list);

        list.createTailRec(new int[]{10, 20, 30});
        System.out.println("createTailRec + toStringRec: " + list.toStringRec());
    }
}