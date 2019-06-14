// CLASS: JSONFactory .
//
// Author: Harsh Patel , 7846258
//
// REMARKS: This is a JSONFactory.
//
//-----------------------------------------

public class JSONFactory {


    public static JSONObject getJSONObject(){
        return new JSONObjectValue();
    }

    public static JSONArray getJSONArray(){
        return new JSONArrayValue();
    }

    public static JSONQueryManager getJSONQueryManager(){
        return new QueryManager();
    }

    public static Value getJSONValue(ValueEnum value , Object o){ // checks for the value and returns an object accordingly

        if(value.toString().equals("INT")){
            return new IntegerValue((Integer) o);
        }else if(value.toString().equals("BOOL")) {
            return new BooleanValue((Boolean)o);
        }else if(value.toString().equals("STRING")){
            return new StringValue((String) o);
        }else if(value.toString().equals("DOUBLE")){
            return new DoubleValue((Double) o);
        }
        return null;
    }

}
