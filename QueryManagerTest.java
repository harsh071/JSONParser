//-----------------------------------------
// NAME		: Harsh Patel
// STUDENT NUMBER	: 7846258
// COURSE		: COMP 2150
// INSTRUCTOR	: Gord Boyer.
// ASSIGNMENT	: assignment #3
// QUESTION	: question #2
//
// REMARKS: This tests the JSONQueryManager.
//
//
//-----------------------------------------
import static org.junit.Assert.*;

import org.junit.Test;


public class QueryManagerTest {

    @Test
    public void test1(){
        JSONQueryManager test  = JSONFactory.getJSONQueryManager();
        /*
        JSONObject Has an array as the first element (KEY : Array) , which has two elements , in which the second element's first
        object is an array .

        Second Has a simple Key(Major. ) Value.
        * */
        test.loadJSON(" { \"Array\" : [ { \"name\" : \"Anne Vestor\" , \"userid\" : \"avestor\" , \"cash on hand\" : 10000 } , { \"name\" : [ \"Bhaulik Patel\" , \"Harsh Patel\" ] , \"userid\" : \"harsh071\" , \"cash on hand\" : 10000 } ] , \"Major\" : \"COMP SCI\" } ");

        try{
            //Simple test for an element in the array
            assertEquals("Wrong result" ,  " \"avestor\" ", test.getJSONValue("Array[0].userid").toString());
            assertEquals("Wrong result" ,  " \"COMP SCI\" ", test.getJSONValue("Major").toString());

            //First object has an Array.

            //First element in the Array.
            assertEquals("Wrong result."," { \"name\" : \"Anne Vestor\" , \"userid\" : \"avestor\" , \"cash on hand\" : 10000 } " , test.getJSONValue("Array[0]").toString());

            //Second Element in the Array.
            assertEquals("Wrong result."," { \"name\" : [ \"Bhaulik Patel\" , \"Harsh Patel\" ] , \"userid\" : \"harsh071\" , \"cash on hand\" : 10000 } " , test.getJSONValue("Array[1]").toString());

            //Object having an array having an object with another array
            assertEquals("Wrong result."," [ \"Bhaulik Patel\" , \"Harsh Patel\" ] " , test.getJSONValue("Array[1].name").toString());

            //Checking for the array elements.
            assertEquals("Wrong result."," \"Harsh Patel\" " , test.getJSONValue("Array[1].name[1]").toString());
            assertEquals("Wrong result."," \"Bhaulik Patel\" " , test.getJSONValue("Array[1].name[0]").toString());

            //Checking for non existing object.
            assertEquals("Wrong Result. " , null , test.getJSONValue("Random.random2"));
            assertEquals("Wrong Result. " , null , test.getJSONValue("Array[4]"));
            assertEquals("Wrong Result. " , null , test.getJSONValue("Array[0].name[0]"));
            assertEquals("Wrong Result. " , null , test.getJSONValue("Array[1].name[5]"));
            assertEquals("Wrong Result. " , null , test.getJSONValue("Array[1].name[1].surname"));


        }catch  (IllegalStateException e){
            System.out.println("Please Load a JSON first .");
        }

    }


}