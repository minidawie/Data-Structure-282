package HuffmanCodeProgramming;

public class Node {

    Node left, right;
    int frequency;
    char letter;

    public Node(){}

    public Node(char letter, int frequency) { //the leaf nodes (the nodes with actual information)
        this.letter = letter;
        this.frequency = frequency;
    }


}
