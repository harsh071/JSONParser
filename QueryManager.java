// CLASS: QueryManager
//
// Author: Harsh Patel , 7846258
//
// REMARKS: This is testing the JSONParser.
//
//-----------------------------------------


public class QueryManager implements JSONQueryManager {
    private JSONObject jsonObject;
    private JSONParser read = null;

    public QueryManager(){

        read = new JSONParser();
    }

    public void loadJSON(String JSON) {
        jsonObject = read.read(JSON);

    }

    public Value getJSONValue(String query) throws IllegalStateException { // gets the query

        if(jsonObject == null){
            throw new IllegalStateException();
        }
        Value res = null;

        String[] keys = query.split("\\.");
        int len = keys.length;
        String key = "\"" + keys[0] + "\"";

        if(key.indexOf("[") == -1) { // checks if the query is given as an array
            res = jsonObject.getValue(new StringValue(key));
        }else{
            int idx = key.indexOf("[");
            String key1 = key.substring(0,idx)+"\"";
            res = jsonObject.getValue(new StringValue(key1));
            if(res!= null){
                if(res instanceof JSONArrayValue) { // check if the value is actually and array .
                    //checks if the length is not out of bound
                    if(((JSONArrayValue) res).numElements()>Character.getNumericValue(key.charAt(idx + 1))) {
                        res = ((JSONArrayValue) res).getValueAtIdx(Character.getNumericValue(key.charAt(idx + 1)));
                    }else{
                        res = null;
                    }
                }
            }
        } // checking first query key


        if(res!= null) {

            for (int i = 1; i < len; i++) { // Loop to go through all the keys to find element.
                key = "\"" + keys[i] + "\"";

                if (res instanceof JSONObjectValue) { // checks if the is a JSONObject.

                    if(key.indexOf("[") == -1) {// checks if the query is given as an array
                        res = ((JSONObjectValue) res).getValue(new StringValue(key));

                    }else{

                        int idx = key.indexOf("[");
                        String key1 = key.substring(0,idx)+"\"";
                        res = ((JSONObjectValue)res).getValue(new StringValue(key1));
                        if(res!= null){
                            if(res instanceof JSONArrayValue) {// check if the value is actually and array .
                                //checks if the length is not out of bound
                                if(((JSONArrayValue) res).numElements()>Character.getNumericValue(key.charAt(idx + 1))){
                                    res = ((JSONArrayValue) res).getValueAtIdx(Character.getNumericValue(key.charAt(idx + 1)));
                                }else{
                                    res = null;
                                }
                            }else{
                                System.out.println(key1 + " is not a JSONArray");
                                res = null;
                            }
                        }
                    }
                } //
                else{
                    System.out.println("You cannot search further than "+keys[i-1]);
                    res = null;
                }
            }
                if(res!=null) {
                    System.out.println("Query Result is:"+ res.toString());
                }
        }
        return res;
    }
}
