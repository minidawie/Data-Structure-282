package HuffmanCodeProgramming;

//from text book page 147-148
//some things might be slightly edited

public class PriorityQ {
    // array in sorted order, from max at 0 to min at size-1
    //
    //NEED TO CHANGE THIS TO MIN TO MAX
    //
    private final int maxSize;
    private final Node[] queArray;
    private int nItems;

    public PriorityQ(int s) { // constructor

        maxSize = s;
        queArray = new Node[maxSize];
        nItems = 0;
    }

    public void insert(Node item) { // insert item
        int j;

        if(nItems==0) { // if no items,
            queArray[nItems++] = item; // insert at 0
        }
        else {// if items,
            for(j=nItems-1; j>=0; j--) { // start at end,
                if(item.frequency > queArray[j].frequency) // if new item larger,  //how to get data item of the object of an object
                    queArray[j+1] = queArray[j]; // shift upward
                else // if smaller,
                    break; // done shifting
            } // end for

            queArray[j+1] = item; // insert it
            nItems++;
        } // end else (nItems > 0)
    } // end insert()

    public Node remove() { return queArray[--nItems]; } // remove minimum item

    public Node peekMin() { return queArray[nItems-1]; } // peek at minimum item

    public boolean isEmpty() { return (nItems==0); } // true if queue is empty

    public boolean isFull() { return (nItems == maxSize); } // true if queue is full

    public int getnItems(){ return nItems; }

} // end class PriorityQ

