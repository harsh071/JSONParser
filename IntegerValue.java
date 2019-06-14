// CLASS: IntegerValue
//
// Author: Harsh Patel , 7846258
//
// REMARKS: This is the type of value stored in the JSON object.
//
//-----------------------------------------


public class IntegerValue implements Value {
    private int val;

    public IntegerValue(int val) {
        this.val = val;
    }

    public boolean equals(Value v) { // this checks for the if v is equal to the content .
        boolean result = false;
        if(v instanceof IntegerValue){
            if(val == ((IntegerValue) v).getVal()){
                result = true;
            }
        }

        return result;
    }

    public int getVal() {
        return val;
    } //returns value.

    public String toString() {
        return " "+ val+" " ;
    }
}
