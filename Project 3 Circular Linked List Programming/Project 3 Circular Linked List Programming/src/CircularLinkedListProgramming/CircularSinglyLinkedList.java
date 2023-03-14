package CircularLinkedListProgramming;

//Programmer: David Koh

public class CircularSinglyLinkedList {

    private Node curr;


    public CircularSinglyLinkedList() { curr = null; }
    private boolean isEmpty(){ return curr == null; }

    public void insert (int data) {
        Node newNode = new Node(data);

        //when list is empty just create the newNode and link it to curr
        if (isEmpty()){
            curr = newNode;
            curr.next = curr;
            //this line could be newNode.next = curr if there is an error
        }

        //when there is only one node
        else if (curr.next == curr){
            //pretend you set the newNode in front of the curr then connect the back of newNode to curr
            newNode.next = curr;

            //atm the nodes look like this newNode->curr then curr circles back to itself
            //to make it circular again set the next of curr to the newNode
            curr.next = newNode;

            //move the curr pointer to the newNode
            //this insertion is similar to that of a stack. I put the newNodes to the front of the list but technically its the end
            curr = newNode;
        }

        //when there are at least 2 nodes in the list you have to traverse the list when wanting to link the end of the list to the newNode
        else{
            //curr is at the "front" of the list. link the newNode to the "front"
            newNode.next = curr;

            //create a temp variable as a placeholder so it stops the loop once it goes around once
            Node temp = curr;

            //have to increment curr because if not the while-loop will always be false
            curr = curr.next;

            //increments curr until it would loop back to where is started
            while(curr.next != temp){
                curr = curr.next;
            }
            //connect the back of the list to the newNode to make it circular
            curr.next = newNode;
            curr = newNode;
        }
    }

    public Node search (int key){
        Node temp = curr;
        if(curr==null){
            System.out.println("there is nothing in the list");
            return null;
        }
        //check the first case because i dont think the else statement checks this node bc algorithms are hard
        else if (curr.data == key){
            return curr;
        }
        else{
            //should go through the rest of the nodes
            curr = curr.next;
            while(curr != temp){
                if(curr.data == key){
                    return curr;
                }
                curr = curr.next;
            }
            //if we got out of the while loop it means that the key didn't match with anything in the list
            System.out.println("The item was not in the list");
            //idk if returning null is the right thing to do but i cant give something from the list :)
            return null;
        }
    }

    public Node delete (int key){
        if(isEmpty()){
            System.out.println("the list is empty. Nothing to delete");
            return null;
        }
        else if(curr == curr.next){
            Node temp = curr;
            curr.next = null;
            curr = null;
            return temp;
        }
        else{
            if(search(key)==null){
                return null;
            }
            else{
                search(key);
                Node temp = curr;
                while(curr.next != temp){
                    curr = curr.next;
                }
                curr.next = curr.next.next;
                return temp;
            }

        }
    }

    public void display (){
        if(curr == null){
            System.out.println("there is nothing in the list");
        }
        else {
            Node temp = curr;
            while (curr.next != temp) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println(curr.data);
        }
    }
}
