package HuffmanCodeProgramming;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string of words to be compressed");
        String string = scanner.nextLine();

        HuffmanTree tree = new HuffmanTree(string);

        tree.makeTree();
        System.out.println("Post order traversal of Huffman Tree");
        System.out.println("____________________________________");
        System.out.println("Character     Frequency");
        tree.displayTree();

        System.out.println();

        tree.makeTable();
        System.out.println("Corresponding Code Table");
        System.out.println("________________________");
        tree.displayTable();

        System.out.println();

        tree.encode();
        System.out.println("the encoded message is: " + tree.getEncodedMessage());

        tree.decode();
        System.out.println("the decoded message is: " + tree.getDecodedMessage());

    }
}
