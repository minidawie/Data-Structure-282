package ArrayProgramming;

/**
 *
 * @author juneja_u
 *         David Koh
 */
public class OrderedList {
    private int[] array;
    private int numOfElements;

    //constructor
    public OrderedList(int size) {
        array = new int[size];
        numOfElements = 0;
    }

    //returns true if array is empty
    public boolean isEmpty(){
        return numOfElements == 0;
    }

    //returns true if array is full
    public boolean isFull(){
        return numOfElements == array.length;
    }

    //displays what is in the array
    public void display(){
        if(isEmpty()){
            System.out.println("There is nothing to display.");
        }
        else{
            for(int i = 0 ; i < numOfElements; i++){
                System.out.print(array[i] + " ");
            }
        }
    }

    //searches for the index the item should go into
    public int search(int item){
        int low =  0;
        int high = numOfElements -1;


        while(high >= low){
            int mid = (low + high)/2;
            if(array[mid] == item)
                return mid;
            else if(item < array[mid])
                high = mid - 1;
            else
                low = mid + 1;

        }
        return -low ;
    }

    //inserts value in order into array
    public void insert(int value){
        int index = -search(value);
        System.out.println(index);

        for(int i = numOfElements; i >= index ; i--){
            if(i == 0)
                continue;
            array[i] = array[i-1];
        }
        array[index] = value;
        numOfElements++;
    }

    //deletes value then puts array into order
    public boolean delete(int value) {
        if(isEmpty()){
            return false;
        }
        else{
            int index = search(value);
            if (index < 0) {
                return false;
            } else {
                for (int i = index; i < numOfElements; i++) {
                    array[i] = array[i + 1];
                }
            }
            numOfElements--;
            return true;
        }

    }

    //grabs array
    public int[] getArray(){
        return array;
    }
    //grabs the size of the array
    public int getSizeOfArray(){
        return array.length;
    }
    //grabs the number of elements in the array

    public int getNumOfElements(){
        return numOfElements;
    }
    //inserts value in order into the merged array
    public void mergeInsert(int value, int elements, int mergedArray[]){
        int index = -search(value);
        System.out.println(index);

        for(int i = elements; i >= index ; i--){
            if(i == 0)
                continue;
            mergedArray[i] = mergedArray[i-1];
        }
        mergedArray[index] = value;
        numOfElements++;
    }
    //merges the first and second array into the third array
    public void merge(int array1[], int array2[], int mergedArray[], int array1NumOfElements, int array2NumOfElements){
        for(int i=0; i<array1NumOfElements; i++){
            mergedArray[i] = array1[i];
            numOfElements++;
        }
        for(int j=0; j<array2NumOfElements; j++){
            mergeInsert(array2[j], numOfElements, mergedArray);
        }
        array = mergedArray;
    }
}
