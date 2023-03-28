package HuffmanCodeProgramming;


public class HuffmanTree {

    private char character;
    public int frequency, numberOfTrees, treeLeaf = 0;
    private String encodedMessage; //might not need if i use encode in the constructor
    private String decodedMessage;
    private final String[][] table = new String[53][2];
    private HuffmanTree root, left, right, finalTree;
    PriorityQ priorityQ = new PriorityQ(100);

    public HuffmanTree () {} //empty constructor

    public HuffmanTree(String string){

        numberOfTrees = 0;
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

            test = test.replace(Character.toString(letter), "");//once looped through string once, get rid of all instances of char
            Node newNode = new Node(letter, findFreq); //make a node for each letter
            root = new HuffmanTree(newNode); //makes a tree object for each node
            priorityQ.insert(root); //insert the tree into the priorityQ based on the frequency
        }
        String temp = "";
        finalTree = makeTree(priorityQ.remove(), priorityQ.remove());
        makeTable(finalTree, temp); //call a method(makeTree) that will start making the binary tree
       // encode(string);
    }

    private HuffmanTree(Node data){
        this.frequency = data.frequency;
        this.character = data.letter;
    }

    private HuffmanTree makeTree(HuffmanTree leftChild, HuffmanTree rightChild){//ERROR THIS STOPS AT I AND V BECAUSE I DOESNT RESURSE LIKE I WANTED IT TO
        HuffmanTree parent = new HuffmanTree();

        parent.frequency = leftChild.frequency + rightChild.frequency;
        parent.left = leftChild;
        parent.right = rightChild;

        if(!priorityQ.isEmpty()) {
            priorityQ.insert(parent); //insert back into priorityQ
            makeTree(priorityQ.remove(), priorityQ.remove());//recurse

        }
        return parent;
    }

    private void makeTable(HuffmanTree tree, String temp){
        String ifLeft = "0";
        String ifRight = "1";

        if(tree.left != null){
            temp += ifLeft;
            makeTable(tree.left, temp);
        }
        if(tree.right != null){
            temp += ifRight;
            makeTable(tree.right, temp);
        }
        if(tree.left == null && tree.right == null){
            treeLeaf += 1;
            //put the char and the huffman code (temp) into the 2D array
            for(int i = treeLeaf-1; i < treeLeaf; i++){
                for(int j = 0; j < 2; j++){
                    if(j == 0)
                        table[i][j] = String.valueOf(tree.character);
                    else
                        table[i][j] = temp;
                }
            }
        }
    }


    private void encode(String string){ //encodes the message

        for(int i = 0; i < table.length; i++){
            char temp = string.charAt(i);
            if(temp != '0' && temp != '1'){
                string = string.replace(table[i][0], table[i][1]);
                encodedMessage = string;
            }

        }
    }
    public String getEncodedMessage(){
        return encodedMessage;
    }


    public String decode(){ //calls private decode method so user doesn't have to have access to variable
        return decode(encodedMessage);
    }
    private String decode(String message){

        for(int i = 0; i < table.length; i++){
            message = message.replace(table[i][1], table[i][0]);
            decodedMessage = message;
        }
        return decodedMessage;
    }

    public void displayTree(){
        displayTree(finalTree);
    }
    private void displayTree (HuffmanTree tree){
        if(tree.left != null){
            System.out.println("went left");
            displayTree(tree.left);
        }
        if(tree.right != null){
            System.out.println("went right");
            displayTree(tree.right);
        }
        if(tree.left == null && tree.right == null){
            System.out.println("Character     Frequency");
            System.out.println("    " + tree.character + "         " + tree.frequency);
        }
    } //displays the tree (shows the character and the frequency

    public void displayTable(){
        displayTable(table);
    }
    private void displayTable (String[][] codeTable){
        System.out.println("Character     Code");
        for(int i = 0; i<table.length; i++){
            if(table[i][0] != null) {
                System.out.println("    " + table[i][0] + "         " + table[i][1]);
            }
        }
    } //displays the contents of the array (shows the characters and the huffman code
}
