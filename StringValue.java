// CLASS: StringValue .
//
// Author: Harsh Patel , 7846258
//
// REMARKS: This is the type of value stored in the JSON object.
//
//-----------------------------------------

public class StringValue implements Value {
    private String val;

    public StringValue(String val) {
        this.val = val;
    } //StringValue .

    public boolean equals(Value v) { // this checks for the if v is equal to the content .
        boolean result = false;

        if(v instanceof StringValue){
            if(((StringValue) v).getVal().equals(val)){
                result = true;
            }
        }
        return result;
    } //equals.

    public String getVal() {
        return val;
    } // getVal.

    public String toString() {
        return " " + val + " ";
    }//toString.
}
