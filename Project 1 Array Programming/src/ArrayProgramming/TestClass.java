package ArrayProgramming;
//author: David Koh
public class TestClass {
    public static void main(String[] args) {
        //im not going to test the methods that were written in class because they were tested in class

        OrderedList first = new OrderedList(10);
        OrderedList second = new OrderedList(11);
        OrderedList third = new OrderedList(first.getSizeOfArray()+ second.getSizeOfArray());

        first.insert(10);
        first.insert(30);
        first.insert(20);
        first.insert(40);

        first.display();

        second.insert(5);
        second.insert(35);
        second.insert(25);
        second.insert(15);
        second.insert(45);
        second.insert(16);
        second.insert(27);
        second.insert(36);


        second.display();

        third.merge(first.getArray(), second.getArray(), third.getArray(), first.getNumOfElements(), second.getNumOfElements());

        third.display();



    }
}
