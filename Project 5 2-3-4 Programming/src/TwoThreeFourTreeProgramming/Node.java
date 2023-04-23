package TwoThreeFourTreeProgramming;

/**
 *
 * @author juneja_u
 * Programmer: David Koh
 */
public class Node {
    private int[] data;
    private Node[] children;
    private int numOfItems;
    private Node parent;

    //----------
    private int flaggedAsDeleted;

    public Node(){
        data = new int[3];
        children = new Node[4];
    }
    public void connectChild(Node child, int index){
        children[index] = child;
        if(child != null)
            child.parent = this;
    }
    public Node disconnectChild(int index){
        Node temp = children[index];
        children[index] = null;
        return temp;
    }
    public int insertItem(int item){//assume that this is not full
        int i;
        numOfItems++;
        for(i = 2; i >= 0; i--){
            if(data[i] == 0)
                continue;
            else if(item < data[i])
                data[i+1] = data[i];
            else{
                data[i+1] = item;
                return i+1;
            }

        }
        data[0] = item;
        return 0;
    }
    public int searchItem(int item){
        for(int i = 0 ; i < 3 ; i++){
            if(item == data[i])
                return i;

        }
        return -1;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public Node getParent() {
        return parent;
    }
    public boolean isLeaf(){
        return (children[0] == null);

    }
    public int removeItem(){
        int temp = data[numOfItems-1];
        data[numOfItems -1 ] = 0;
        numOfItems--;
        return temp;

    }
    public void displayNode(){
        for(int i = 0 ; i < numOfItems ; i++){
            System.out.print(data[i] + " ");
        }
    }

    public int getItem(int index) {
        return data[index];

    }
    public Node getChild(int index){
        return children[index];
    }
    public boolean isFull(){
        return numOfItems == 3;
    }
    //-----------------------

    public void flag(int flagValue){ flaggedAsDeleted = flagValue; } //if the flag value is 1 then the node is flagged as deleted.

    public int getFlaggedAsDeleted(){
        return flaggedAsDeleted;
    }
}

