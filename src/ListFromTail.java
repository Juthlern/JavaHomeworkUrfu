public class ListFromTail {
    public static void main(String[] args) {
        Node head = null;
        Node tail = null;

        for (int i = 1; i <= 5; i++) {
            Node newNode = new Node(i, null);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        printList(head);
    }
    public static void printList(Node head) {
        Node ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
    }
}