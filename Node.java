/// CLASS: Node.
//
// Author: Harsh Patel , 7846258
//
// REMARKS: This is a Node class which holds the data and a link to the next Node, it also holds the hash codes
// for the current and the previous Nodes.
//-----------------------------------------
public class Node {
    private Value key; // Key  in the list.
    private Value v; //Value in the list.
    private Node next; // Link to the next Item .

    public Node(Value key, Value v , Node next){
        this.key = key;
        this.v = v;
        this.next = next;
    }

    public Node(Value v, Node next){
        key = null;
        this.v = v;
        this.next = next;
    }


    /*getters and setter*/

    public Value getKey(){
        return key;
    }

    public Value getValue() {
        return v;
    }

    public void setValue(Value v){
        this.v = v;
    }

    public Node getNext() {
        return next;
    }


    public void setNext(Node n ) {
        next = n;
    }

}
