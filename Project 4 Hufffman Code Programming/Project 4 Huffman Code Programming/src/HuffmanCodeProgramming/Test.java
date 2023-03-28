package HuffmanCodeProgramming;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string of words to be compressed");
        String string = scanner.nextLine();

        HuffmanTree tree = new HuffmanTree(string);

        tree.displayTree();
     //   tree.displayTable();

      //  System.out.println(tree.getEncodedMessage());

       // System.out.println(tree.decode());

        //dont forget to uncomment line 41 in Huffman Tree

    }
}
