package TwoThreeFourTreeProgramming;

//Programmer: David Koh
//i only edited the methods i was working on.

public class Tree234Test {
    public static void main(String[] args) {
        Tree234 t = new Tree234();
        t.insert(10);
        t.insert(20);
        t.insert(30);
        t.insert(40);
        t.insert(50);
        t.insert(60);
        t.insert(70);
        t.insert(80);

        t.inorderTraversal();
        t.delete(40);
        System.out.println("\n------------------------------\n");
        t.inorderTraversal();
    }
}
