
// CLASS: List.
//
// Author: Harsh Patel , 7846258
//
// REMARKS: A Linked list which holds a Node which contains the details of the list.
//
//-----------------------------------------
public class List {
    private Node front, end; // Front and end pointer of the List

    public List(){
        front = end = null;
    }

    public Node search(Value key){
        //Search for the Value on the list.
        boolean found = false;
        Node curr =  front;
        while(!found && curr!= null){
            if( curr.getKey()!= null && curr.getKey().equals(key) ){
                found = true;
            }else {
                curr = curr.getNext();
            }
        }

        return curr;

    }//Search


    public void insert(Value key, Value v){
        //Insert The given Value to the end of the list.
        Node searchNode = search(key);

        if(front==null){
            front = new Node(key,v,null);
            end = front;
        }else if(searchNode==null){
            Node newNode = new Node(key,v, null);
            end.setNext(newNode);
            end = end.getNext();
        }else{
            searchNode.setValue(v);
        }
    } // insert with key and value.

    public void insert(Value v){
        //Insert The given Value to the end of the list.

        if(front==null){
            front = new Node(v,null);
            end = front;
        }else{
            Node newNode = new Node(v, null);
            end.setNext(newNode);
            end = end.getNext();
        }
    } // insert with value.

    /*Getter Method.*/

    public Node getFront() {
        return front;
    }

    public Node getEnd() {
        return end;
    }

}
