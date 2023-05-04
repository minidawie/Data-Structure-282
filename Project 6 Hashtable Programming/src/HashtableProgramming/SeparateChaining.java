package HashtableProgramming;

public class SeparateChaining {
    BST[] hashtable;
    public SeparateChaining(){
        hashtable = new BST[5];
        for(int i = 0 ; i < 5 ; i++)
            hashtable[i] = new BST();
    }
    public int hash(int key){
        return key%5;
    }
    public void insert(Student s){
        int index = hash(s.id);
        hashtable[index].insert(s);
    }
    public boolean delete(int s){
        int index = hash(s);
        return hashtable[index].delete(s);
    }
    public int search(int s){
        int index = hash(s);
        if(hashtable[index].search(s) != null) {
            return hashtable[index].search(s).data;
        }
        else {
            System.out.println("the id is not in the system");
            return -1;
        }
    }
    public void display(){
        for(int i = 0 ; i < 5 ; i++){
            hashtable[i].display();
        }
    }
}
