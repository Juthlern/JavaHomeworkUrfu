public class MyList {
    private Node head;

    //  а) Методы с циклами

    // ввод с головы: createHead()
    public void createHead(int[] values) {
        head = null;
        for (int value : values) {
            head = new Node(value, head);
        }
    }
    // ввод с хвоста: createTail()
    public void createTail(int[] values) {
        head = null;
        Node tail = null;
        for (int value : values) {
            Node newNode = new Node(value, null);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }
    // вывод: toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node ref = head;
        while (ref != null) {
            sb.append(ref.value).append(" ");
            ref = ref.next;
        }
        return sb.toString().trim();
    }
    // AddFirst()
    public void addFirst(int value) {
        head = new Node(value, head);
    }
    // AddLast()
    public void addLast(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            return;
        }
        Node ref = head;
        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = newNode;
    }
    // Insert() – вставка по номеру (индексы с 0)
    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node ref = head;
        int i = 0;
        while (ref != null && i < index - 1) {
            ref = ref.next;
            i++;
        }
        if (ref == null) return; // индекс вне диапазона
        Node newNode = new Node(value, ref.next);
        ref.next = newNode;
    }
    // RemoveFirst()
    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }
    // RemoveLast()
    public void removeLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node ref = head;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null;
    }
    // Remove() – удалить по индексу
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node ref = head;
        int i = 0;
        while (ref != null && i < index - 1) {
            ref = ref.next;
            i++;
        }
        if (ref == null || ref.next == null) return;
        ref.next = ref.next.next;
    }

    // б) Методы с рекурсией

    // createHeadRec()
    public void createHeadRec(int[] values) {
        head = null;
        for (int value : values) {
            head = createHeadRecInner(head, value);
        }
    }
    private Node createHeadRecInner(Node h, int value) {
        // добавляем новый элемент в голову
        return new Node(value, h);
    }
    // createTailRec()
    public void createTailRec(int[] values) {
        head = null;
        for (int value : values) {
            head = createTailRecInner(head, value);
        }
    }
    private Node createTailRecInner(Node node, int value) {
        if (node == null) {
            return new Node(value, null);
        }
        node.next = createTailRecInner(node.next, value);
        return node;
    }
    // toStringRec()
    public String toStringRec() {
        StringBuilder sb = new StringBuilder();
        buildStringRec(head, sb);
        return sb.toString().trim();
    }
    private void buildStringRec(Node node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.value).append(" ");
        buildStringRec(node.next, sb);
    }
}