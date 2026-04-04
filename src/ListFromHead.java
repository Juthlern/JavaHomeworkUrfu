public class ListFromHead {
    public static void main(String[] args) {
        Node head = null;

        for (int i = 1; i <= 5; i++) {
            head = new Node(i, head);
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