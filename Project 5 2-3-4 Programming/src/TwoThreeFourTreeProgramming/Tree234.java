package TwoThreeFourTreeProgramming;

/**
 *
 * @author juneja_u
 * Programmer: David Koh
 */
public class Tree234 {
    Node root;

    public Tree234(){
        root = new Node();
    }

    public int search(int item){
        Node curr = root;
        int index = curr.searchItem(item);
        while(true){
            if(index == -1 && !curr.isLeaf()){
                curr = getNextLevel(curr, item);
                index = curr.searchItem(item);
            }
            else if(index >= 0)
                return index;
            else
                break;

        }
        return -1;
    }
    public void insert(int item){
        Node curr = root;

        while(true){
            if(curr.isFull()){
                split(curr);
                curr = curr.getParent();
                curr = getNextLevel(curr,item);
            }
            else if(curr.isLeaf())
                break;
            else
                curr = getNextLevel(curr,item);

        }
        curr.insertItem(item);
    }
    public void split(Node n){
        //node is full
        int B, C;
        Node child2, child3, parent;

        C = n.removeItem();
        B = n.removeItem();

        child3 = n.disconnectChild(3);
        child2 = n.disconnectChild(2);

        Node sibling = new Node();

        if(n == root){
            root = new Node();
            parent = root;
            parent.connectChild(n, 0);
        }
        else
            parent = n.getParent();

        //deal with parent
        int index = parent.insertItem(B);
        int numItems = parent.getNumOfItems();

        for(int i = numItems-1; i> index; i--){
            Node temp = parent.disconnectChild(i);
            parent.connectChild(temp, i+1);
        }
        parent.connectChild(sibling, index+1);

        //deal with sibling
        sibling.insertItem(C);
        sibling.connectChild(child3, 1);
        sibling.connectChild(child2, 0);
    }
    public Node getNextLevel(Node n, int value){
        int i;
        int numItems = n.getNumOfItems();
        for(i = 0 ; i < numItems ; i++){
            if(value < n.getItem(i))
                return n.getChild(i);
        }
        return n.getChild(i);
    }

    //---------------------------------------

    public void inorderTraversal(){
        inorderTraversal(root);
    }

    private void inorderTraversal(Node n){
        //this method performs the inorder traversal of a 2-3-4 tree

        //Travel left ward first then when null is hits, return back
        //then check child 2,3,4 similarly

        if(n.getChild(0) != null){ inorderTraversal(n.getChild(0)); } //if there is a child1 then travel to child1
        if(n.getFlaggedAsDeleted() != 1 && n.getItem(0) != 0) { System.out.print(n.getItem(0) + " "); } //print first data of the node

        if(n.getChild(1) != null){ inorderTraversal(n.getChild(1)); } //if there is a child2 then travel to child2
        if(n.getFlaggedAsDeleted() != 1 && n.getItem(1) != 0) { System.out.print(n.getItem(1) + " "); } //print second data of the node

        if(n.getChild(2) != null){ inorderTraversal(n.getChild(2)); } //if there is a child3 then travel to child3
        if(n.getFlaggedAsDeleted() != 1 && n.getItem(2) != 0) { System.out.print(n.getItem(2) + " "); } //print third data of the node

        if(n.getChild(3) != null){ inorderTraversal(n.getChild(3)); } //if there is a child4 then travel to child4
        //there is no fourth data in the nodes
    }

    public void delete (int value){
        //this method FLAGS a node as deleted

        Node curr = root;
        int index = curr.searchItem(value);
        while(true){
            if(index == -1 && !curr.isLeaf()){
                curr = getNextLevel(curr, value);
                index = curr.searchItem(value);
            }
            else if(index >= 0) {
                curr.flag(1);
                break;
            }

            else
                break;

        }
    }
}
