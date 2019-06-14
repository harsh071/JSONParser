// CLASS: JSONObjectValue
//
// Author: Harsh Patel , 7846258
//
// REMARKS: This is the type of value stored in the JSON object.
//
//-----------------------------------------

public class JSONObjectValue implements JSONObject,JSONIter,Value {

    private List jsonObject;
    private Node curr;

    public JSONObjectValue() { // constructor.
        jsonObject = new List();
        curr = jsonObject.getFront();
    } //constructor.

    public void addKeyValue(Value key, Value v) { // adds the key and value to the end of the list.
        jsonObject.insert(key,v);
        curr = jsonObject.getFront();
    }

    public Value getValue(Value key) {
        Node search = jsonObject.search(key);
        Value ret = null;

        if(search!=null){
            ret = (jsonObject.search(key)).getValue();
        }
        return ret;
    } // This returns the value searched by the key


    public boolean equals(Value v) { // This checks if two JSONObjectValues are equal.
        boolean result = false;
        if(v instanceof JSONObjectValue){ // Iterates if it is an instance of JSONObjectValue.
            if(v!=this) {
                result = ((JSONObjectValue) v).getFront().getKey().equals(curr.getKey()) && ((JSONObjectValue) v).getFront().getValue().equals(curr.getValue());
                JSONIter iter = ((JSONObjectValue) v).iterator();
                while (result && iter.hasNext() && hasNext()) {
                    result = iter.getNext().equals(getNext()) && (((JSONObjectValue) iter).getCurr().getKey().equals(curr.getKey()));

                }

                if(!iter.hasNext()&&hasNext() || iter.hasNext()&& !hasNext()){ // checks if any one is out of items.
                    result = false;
                }
            }else{
                result = true;
            }
        }
        return result;
    } //equals.

    public JSONIter iterator() {
        return this;
    } // This is would allow one to iterate through the list with its metbods.


    public boolean hasNext() { // JSONIter methods.
        boolean result = false;
        if(curr!=null){
            if(curr.getNext()!=null){
                result = true;
            }
        }

        return result;
    } //hasNext.

    public Node getCurr() {
        return curr;
    } // Returns the current pointer to where the iterator is .

    private  Node getFront(){ // gives you the front of  the list.
        return jsonObject.getFront();
    } // getFront.



    public Value getNext() { // Returns the next value.
        Value ret = null;
        if(hasNext()) {
            ret = curr.getNext().getValue();
            curr = curr.getNext();
        }
        return ret;
    } //getNext



    @Override
    public String toString() {
        String output = " {";
        Node temp = getFront();
        while(temp!=null ){
            output+= temp.getKey().toString()+":" +temp.getValue().toString();
            temp = temp.getNext();
            if(temp!=null){
                output+=",";
            }
        }

        output+="} ";

        return output;
    }//toString.

}//JSONObjectValue.
