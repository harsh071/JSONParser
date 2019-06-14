// CLASS: DoubleValue
//
// Author: Harsh Patel , 7846258
//
// REMARKS: This is the type of value stored in the JSON object.
//
//-----------------------------------------
public class DoubleValue implements Value {
    private double val;

    public DoubleValue(double val) {
        this.val = val;
    }

    public boolean equals(Value v) { // this checks for the if v is equal to the content .
        boolean result = false;
        if(v instanceof DoubleValue){
            if(val == ((DoubleValue) v).getVal()){
                result = true;
            }
        }

        return result;
    }

    public double getVal() {
        return val;
    } //returns value.

    public String toString() {
        return " "+ val  + " ";
    }
}
