package HashtableProgramming;

public class BST {
    private Node root;

    public BST(){
        root = null;
    }

    public Node search(int key){
        Node curr = root;
        while(curr != null){
            if(key < curr.data){
                curr = curr.left;
            }
            else if(key > curr.data){
                curr = curr.right;
            }
            else
                return curr;
        }
        return curr;
    }

    public void insert(Student data){
        Node n = new Node(data.id);
        Node parent;
        Node curr = root;
        if(root == null){
            root = n;
            return;
        }

        while(true){
            parent = curr;
            if(data.id < curr.data){
                //parent = curr;
                curr = curr.left;
                if(curr == null){
                    parent.left = n;
                    break;
                }
            }
            else if(data.id > curr.data){
                //parent = curr;
                curr = curr.right;
                if(curr == null){
                    parent.right = n;
                    break;
                }
            }
        }
    }

    private void inorder(){
        inorder(root);
    }
    private void inorder(Node curr){
        if(curr != null){
            inorder(curr.left);
            System.out.print(curr.data+ " ");
            inorder(curr.right);
        }
    }

    private void preorder(){
        preorder(root);
    }
    private void preorder(Node curr){
        if(curr != null){
            System.out.print(curr.data+ " ");
            preorder(curr.left);
            preorder(curr.right);
        }
    }

    private void postorder(){
        postorder(root);
    }
    private void postorder(Node curr){
        if(curr != null){
            postorder(curr.left);
            postorder(curr.right);
            System.out.print(curr.data+ " ");
        }
    }

    private int min(){
        Node parent = root;
        Node curr = root;
        while(curr != null){
            parent = curr;
            curr = curr.left;
        }
        return parent.data;
    }

    public boolean delete(int item){
        Node parent = root;
        Node curr = root;
        boolean isLeft = true;
        while(curr.data != item){
            parent = curr;
            if(item < curr.data){
                isLeft = true;
                curr = curr.left;
                if(curr == null) { return false; }
            }
            else{
                isLeft = false;
                curr = curr.right;
                if(curr == null) { return false; }
            }
        }
        //found it
        //check if it is a leaf node
        if(curr.right == null && curr.left == null){
            if(curr == root)
                root = null;
            else if(isLeft)
                parent.left = null;
            else
                parent.right = null;
        }//check if a node has right child only
        else if(curr.left == null){
            if(curr == root)
                root = curr.right;
            else if(isLeft)
                parent.left = curr.right;
            else
                parent.right = curr.right;

        }//if a node has left child only
        else if(curr.right == null){
            if(curr == root)
                root = curr.left;
            else if(isLeft)
                parent.left = curr.left;
            else
                parent.right = curr.left;
        }
        else{
            Node successor = getSuccessor(curr);
            if (curr == root) {
                root = successor;
                successor.left = curr.left;
                successor.right = curr.right;
            } else if (isLeft) {
                parent.left = successor;
                successor.left = curr.left;
                successor.right = curr.right;
            } else {
                parent.right = successor;
                successor.left = curr.left;
                successor.right = curr.right;
            }
        }
        return true;
    }

    public Node getSuccessor(Node n){
        Node curr = n;
        Node parent = n;
        Node successor = n.right;

        while(successor.left != null){
            parent = curr;
            curr = successor;
            successor = successor.left;
        }

        if(successor != n.right)
            curr.left = successor.right;
        return successor;
    }

    //---------------------

    public void display(){
        //inorder tranversal to display the tree
        inorder();
        System.out.println();
    }
}


