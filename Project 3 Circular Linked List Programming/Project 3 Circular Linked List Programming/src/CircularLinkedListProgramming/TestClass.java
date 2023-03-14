package CircularLinkedListProgramming;

//Programmer: David Koh

public class TestClass {
    public static void main(String[] args) {
        CircularSinglyLinkedList l = new CircularSinglyLinkedList();
        CircularSinglyLinkedList y = new CircularSinglyLinkedList();

        System.out.println("testing search when nothing in list (should return the print statement)");
        l.search(1);
        System.out.println();

        System.out.println("testing delete when nothing in list (should return the print statement)");
        l.delete(1);
        System.out.println();

        System.out.println("testing insert method");
        l.insert(1);
        l.display();
        System.out.println();

        System.out.println("testing deleting when only one item in list");
        l.delete(1);
        l.display();
        System.out.println();

        System.out.println("testing insert with more than 1 item");
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.insert(5);
        l.display();
        System.out.println();

        System.out.println("deleting a node in the middle of list");
        System.out.println(l.delete(3).data);
        l.display();
        System.out.println();

        System.out.println("testing the delete method when there are only 2 items in the list");
        y.insert(32);
        y.insert(14);
        y.delete(32);
        y.display();
    }
}
