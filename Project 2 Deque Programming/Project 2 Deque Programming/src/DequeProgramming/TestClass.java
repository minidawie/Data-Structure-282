package DequeProgramming;

//Programmer David Koh

public class TestClass {
    public static void main(String[] args) {
        Deque D = new Deque(5);
        Stack S = new Stack(5);

        System.out.println("Start of Deque testing");
        D.insertLeft(1);
        D.insertLeft(2);
        D.insertLeft(3);
        D.insertLeft(4);
        D.insertLeft(5);
        D.insertLeft(6);
        System.out.println(D.deleteLeft());
        System.out.println(D.deleteLeft());
        System.out.println(D.deleteLeft());
        D.insertRight(7);
        D.insertRight(8);
        System.out.println(D.deleteLeft());
        System.out.println(D.deleteLeft());
        System.out.println(D.deleteLeft());
        System.out.println(D.deleteLeft());
        System.out.println(D.deleteLeft());
        D.insertLeft(1);
        D.insertLeft(2);
        D.insertLeft(3);
        D.insertLeft(4);
        D.insertLeft(5);
        D.insertLeft(6);
        System.out.println(D.deleteRight());
        System.out.println(D.deleteRight());
        System.out.println(D.deleteRight());
        System.out.println(D.deleteRight());
        System.out.println(D.deleteRight());

        System.out.println("\nStart of Stack testing");
        S.push(1);
        S.push(2);
        S.push(3);
        S.push(4);
        S.push(5);
        S.push(6);
        S.peek();
        System.out.println(S.pop());
        System.out.println(S.pop());
        System.out.println(S.pop());
        System.out.println(S.pop());
        System.out.println(S.pop());
        S.push(7);
        S.push(8);
        S.pop();
        if(S.isFull())
            System.out.println("The stack is full");
        else
            System.out.println("The stack is not full");
        S.peek();
        S.push(9);
        S.push(10);
        S.push(11);
        S.push(12);
        if(S.isFull())
            System.out.println("The stack is full");
        else
            System.out.println("The stack is not full");
        S.pop();
        S.pop();
        S.pop();
        S.pop();
        S.pop();
        S.peek();

    }
}
