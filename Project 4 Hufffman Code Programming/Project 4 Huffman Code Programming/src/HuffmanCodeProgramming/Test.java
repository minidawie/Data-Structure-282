package HuffmanCodeProgramming;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string of words to be compressed");
        String string = scanner.nextLine();

        HuffmanTree tree = new HuffmanTree(string);

        tree.makeTree();
        tree.displayTree();

        System.out.println();

        tree.makeTable();
        tree.displayTable();

        System.out.println();

        tree.encode();
        System.out.println("the encoded message is " + tree.getEncodedMessage());

        tree.decode();
        System.out.println("the decoded message is " + tree.getDecodedMessage());

    }
}
