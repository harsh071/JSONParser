// CLASS: JSONArrayValue.
//
// Author: Harsh Patel , 7846258
//
// REMARKS: This is testing the JSONParser.
//
//-----------------------------------------

public class JSONArrayValue implements JSONArray, JSONIter,Value{

    private List jsonArray;
    private Node curr;

    public JSONArrayValue() { //constructor.
        jsonArray = new List();
        curr = jsonArray.getFront();
    }


    // checks if the values are equal .
    public boolean equals(Value v) {
        boolean result = false;
        if(v instanceof JSONArrayValue){
            if(v!=this) {
                result = ((JSONArrayValue) v).getFront().getValue().equals(curr.getValue());
                JSONIter iter = ((JSONArrayValue) v).iterator();
                while (result && iter.hasNext() && hasNext()) {
                    result = iter.getNext().equals(getNext()) ;

                }

                if(!iter.hasNext()&&hasNext() || iter.hasNext()&& !hasNext()){
                    result = false;
                }
            }else{
                result = true;
            }
        }
        return result;        
    }

    //Adds the value to the end of the list.
    public void addValue(Value v) {
        jsonArray.insert(v);
        curr = getFront();
    }

    public int numElements(){
        Node temp = getFront();
        int count  =0 ;
        while(temp!=null){
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public Value getValueAtIdx(int i){
        Node temp = getFront();
        for (int j = 0; j < i ; j++) {
            temp = temp.getNext();
        }
        return temp.getValue();
    }
    //Iterates through the list.
    public JSONIter iterator() {
        return this;
    }

    //Gives the next object.
    public boolean hasNext() {
        boolean result = false;
        if(curr!= null){
            if(curr.getNext()!= null){
                result = true;
            }
        }

        return result;
    }

    // Gives the front of the list.
    public Node getFront(){
        return jsonArray.getFront();
    }


    //Gets the next value from the list.
    public Value getNext() {
        Value ret = null;
        if(hasNext()){
            ret = curr.getNext().getValue();
            curr = curr.getNext();
        }
        return ret;
    }

    //Gives the current pointer.
    public Node getCurr() {
        return curr;
    }

    @Override
    public String toString(){
        String output = " [";
        Node temp = getFront();
        while(temp!= null){
            output += temp.getValue().toString();
            temp = temp.getNext();
            if(temp!=null){
                output += ",";
            }
        }
        output+="] ";

        return output;
    } // toString.
} //JSONArrayValue.
