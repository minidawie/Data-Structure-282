package HashtableProgramming;

//Programmer: David Koh
public class Test {
    public static void main(String[] args) {
        //I only tested the functions that were important
        Student student;
        SeparateChaining chain = new SeparateChaining();

        chain.insert(new Student(5)); //Please give me feedback on this portion of the code
        chain.insert(new Student(2)); //I didnt know how else to insert a Student object
        chain.insert(new Student(6));
        chain.insert(new Student(4));
        chain.insert(new Student(3));
        chain.insert(new Student(1));
        chain.insert(new Student(7));
        chain.insert(new Student(9));
        chain.insert(new Student(8));
        chain.insert(new Student(11));
        chain.insert(new Student(10));

        System.out.println("This displays the original hash table inorder for each index");
        chain.display();
        System.out.println();

        System.out.println("This should return true");
        System.out.println(chain.delete(9));

        System.out.println();

        System.out.println("This displays the hash table with 9 removed");
        chain.display();

        System.out.println();

        System.out.println("This search should return 4");
        System.out.println(chain.search(4));

        System.out.println();

        System.out.println("This search should return -1 because the search parameter is not in the hash table");
        System.out.println(chain.search(14));

        System.out.println();

        System.out.println("This delete should return false because the parameter to be deleted is not in the hash table");
        System.out.println(chain.delete(14));

    }
}
