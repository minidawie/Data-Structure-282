package HuffmanCodeProgramming;


public class HuffmanTree {

    public int treeLeaf = 0;
    private String encodedMessage, decodedMessage, message;
    private int uniqueLetters;
    private String[][] table = new String[53][2];
    private Node finalTree;


    PriorityQ priorityQ = new PriorityQ(100);


    public HuffmanTree(String string){
        message = string;
        String test = string;
        int index = 0;

        while(!test.isEmpty()){
            int findFreq = 0;
            char letter = test.charAt(index);

            for(int i = index; i < test.length(); i++){//goes through string and finds the frequency of each character(case-sensitive and includes space)
                if(test.charAt(i) == letter){
                    findFreq++;
                }
            }
            uniqueLetters++;
            test = test.replace(Character.toString(letter), "");//once looped through string once, get rid of all instances of char
            Node newNode = new Node(letter, findFreq); //make a node for each letter
            priorityQ.insert(newNode); //insert the node into the priorityQ based on the frequency
        }
    }



    public void makeTree(){ makeTree(priorityQ.remove(), priorityQ.remove()); }
    private void makeTree(Node leftChild, Node rightChild){
        Node parent = new Node();

        parent.frequency = leftChild.frequency + rightChild.frequency;
        parent.left = leftChild;
        parent.right = rightChild;

        finalTree = parent;
        if(!priorityQ.isEmpty()) {
            priorityQ.insert(parent); //insert back into priorityQ
            makeTree(priorityQ.remove(), priorityQ.remove());//recurse
        }
    }



    public void makeTable(){
        String temp = "";
        makeTable(finalTree, temp); //call a method(makeTree) that will start making the binary tree
    }
    private void makeTable(Node tree, String temp){
        String ifLeft = "0";
        String ifRight = "1";

        if(tree.left != null){
            temp += ifLeft;
            makeTable(tree.left, temp);
            temp = temp.substring(0,temp.length()-1);
        }
        if(tree.right != null){
            temp += ifRight;
            makeTable(tree.right, temp);
            temp = temp.substring(0,temp.length()-1);
        }
        if(tree.left == null && tree.right == null){
            treeLeaf += 1;
            //put the char and the huffman code (temp) into the 2D array
            for(int i = treeLeaf-1; i < treeLeaf; i++){
                for(int j = 0; j < 2; j++){
                    if(j == 0)
                        table[i][j] = String.valueOf(tree.letter);
                    else
                        table[i][j] = temp;
                }
            }
        }
    }


    public void encode(){ encode(message); }
    private void encode(String string){ //encodes the message

        for(int i = 0; i < string.length(); i++){
            int k = 0;
            String arrayChar = table[k][0];

            char temp = string.charAt(i);
            if(temp != '0' && temp != '1'){
                while(temp != arrayChar.charAt(0)){
                    k++;
                    arrayChar = table[k][0];
                }
                string = string.replace(table[k][0], table[k][1]);
                encodedMessage = string;

            }
        }
    }
    public String getEncodedMessage(){ return encodedMessage; }



    public void decode(){ decode(encodedMessage); }
    private void decode(String message){ //decodes the encoded message

        for(int i = uniqueLetters-1; i > -1; i--){//maybe change to while based off of wills suggestion. will find out why tmr
            message = message.replace(table[i][1], table[i][0]);//need to change how the message is decoded
        }
        decodedMessage = message;
    }
    public String getDecodedMessage() { return decodedMessage; }



    public void displayTree() { displayTree(finalTree); }
    private void displayTree (Node tree) {
        if(tree.left != null) {
            displayTree(tree.left);
        }
        if(tree.right != null) {
            displayTree(tree.right);
        }
        if(tree.left == null && tree.right == null) {
            System.out.println("    " + tree.letter + "         " + tree.frequency);
        }
    } //displays the tree (shows the character and the frequency



    public void displayTable(){ displayTable(table); }
    private void displayTable (String[][] codeTable){
        System.out.println("Character     Code");
        for(int i = 0; i<table.length; i++){
            if(table[i][0] != null) {
                System.out.println("    " + table[i][0] + "         " + table[i][1]);
            }
        }
    } //displays the contents of the array (shows the characters and the huffman code
}
