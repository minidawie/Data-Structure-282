package DequeProgramming;

//Programmer David Koh

public class Stack {
    Deque S;

    public Stack(int size){
        S = new Deque(size);
    }

    public void push(int item){
        S.insertRight(item);
    }

    public int pop(){
        return S.deleteRight();
    }

    public void peek(){
        if(!isEmpty()) {
            int elements = S.getNumberOfItems();
            int[] array = S.getArray();
            System.out.println(array[elements - 1]);
        }
        else
            System.out.println("The stack is empty");;
    }

    public boolean isEmpty(){ return S.isEmpty(); }

    public boolean isFull(){ return S.isFull(); }


}
