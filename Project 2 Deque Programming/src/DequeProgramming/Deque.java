package DequeProgramming;

//Programmer David Koh

public class Deque {
    private int[] array;
    private int left;
    private int right;
    private int numberOfItems;

    public Deque(int size){
        array = new int[size];
        left = 0;
        right = -1;
        numberOfItems = 0;
    }
    public boolean isEmpty(){
        return numberOfItems == 0;
    }

    public boolean isFull(){
        return numberOfItems == array.length;
    }

    public void insertLeft(int item){
        if(!isFull()){
            if(left == 0)
                left = array.length;

            array[--left] = item;
            numberOfItems++;
        }
        else{
            System.out.println("Cannot insert");
        }
    }

    public void insertRight(int item){
        if(!isFull()){
            if(right == array.length -1)
                right = -1;

            array[++right] = item;
            numberOfItems++;
        }
        else{
            System.out.println("Cannot insert");
        }
    }

    public int deleteLeft(){
        if(!isEmpty()){
            int temp = array[left];
            if(left == array.length -1)
                left = 0;
            else
                left++;
            numberOfItems--;
            return temp;
        }
        else
            return -1;
    }

    public int deleteRight(){
        if(!isEmpty()){
            int temp = array[right];
            if(right == 0)
                right = array.length - 1;
            else
                right--;
            numberOfItems--;
            return temp;
        }
        else
            return -1;
    }

    public int getNumberOfItems(){ return numberOfItems; }

    public int[] getArray(){ return array; }
}
