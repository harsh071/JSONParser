// CLASS: BooleanValue
//
// Author: Harsh Patel , 7846258
//
// REMARKS: This is the type of value stored in the JSON object.
//
//-----------------------------------------

public class BooleanValue implements Value {
    private boolean val;

    public BooleanValue(boolean val) {
        this.val = val;
    }

    public boolean equals(Value v) { // this checks for the if v is equal to the content .
        boolean result = false;
        if(v instanceof BooleanValue){
            if(((BooleanValue) v).getVal() == val){
                result = true;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return " "+Boolean.toString(val) + " ";
    }


    public boolean getVal() {
        return val;
    } // returns the value.
}
