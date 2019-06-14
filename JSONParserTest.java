//-----------------------------------------
// NAME		: Harsh Patel
// STUDENT NUMBER	: 7846258
// COURSE		: COMP 2150
// INSTRUCTOR	: Gord Boyer.
// ASSIGNMENT	: assignment #3
// QUESTION	: question #1
//
// REMARKS: This tests the JSONParser.
//
//
//-----------------------------------------

import static org.junit.Assert.*;

import org.junit.Test;

public class JSONParserTest {

    @Test
    public void Test1(){
        JSONParser test = new JSONParser();
        JSONObject empty = test.read(" {  } ");

        // Checking for an empty JSONObject.
        assertEquals("The correct out put is \" {} \" ", " {} ", empty.toString() );


        /* Checking when JSONObject has only one item.*/

        //checking for Integer.
        empty.addKeyValue(new StringValue("Age"), new IntegerValue(19));
        assertEquals("The output should be this. "," { Age : 19 } ", empty.toString() );

        //making the object empty again
        empty = test.read(" {  } ");
        assertEquals("The correct out put is \" {} \" ", " {} ", empty.toString() );

        //checking for Double
        empty.addKeyValue(new StringValue("Height"), new DoubleValue(5.9));
        assertEquals("The output should be this. "," { Height : 5.9 } ", empty.toString() );

        //making the object empty again
        empty = test.read(" {  } ");
        assertEquals("The correct out put is \" {} \" ", " {} ", empty.toString() );

        //checking for String.
        empty.addKeyValue(new StringValue("Name"), new StringValue("Harsh"));
        assertEquals("The output should be this. "," { Name : Harsh } ", empty.toString() );


        //making the object empty again
        empty = test.read(" {  } ");
        assertEquals("The correct out put is \" {} \" ", " {} ", empty.toString() );

        //checking for Boolean
        empty.addKeyValue(new StringValue("Verify"), new BooleanValue(true));
        assertEquals("The output should be this. "," { Verify : true } ", empty.toString() );


        //making the object empty again
        empty = test.read(" {  } ");
        assertEquals("The correct out put is \" {} \" ", " {} ", empty.toString() );

        //checking for Empty Array.
        empty.addKeyValue(new StringValue("Array"), new JSONArrayValue());
        assertEquals("The output should be this. "," { Array : [] } ", empty.toString() );

        //making the object empty again
        empty = test.read(" {  } ");
        assertEquals("The correct out put is \" {} \" ", " {} ", empty.toString() );

        //checking for Array with one item.
        JSONArrayValue newArray = new JSONArrayValue();
        newArray.addValue(new IntegerValue(19));

        empty.addKeyValue(new StringValue("Array"),newArray);
        assertEquals("The output should be this. "," { Array : [ 19 ] } ", empty.toString() );

    }

    @Test
    public void Test2(){
        JSONParser test = new JSONParser();
        JSONObject example = test.read(" { \"name\" : \"Anne Vestor\" , \"userid\" : \"avestor\" , \"cash on hand\" : 10000 } ");

       assertEquals("The output is incorrect." , " { \"name\" : \"Anne Vestor\" , \"userid\" : \"avestor\" , \"cash on hand\" : 10000 } ", example.toString() );

        // JSONObject holding a JSONArray which has a JSONObject as a value.
        example = test.read(" { \"Array\" : [ { \"name\" : \"Anne Vestor\" , \"userid\" : \"avestor\" , \"cash on hand\" : 10000 } ] } ");
        assertEquals("The output is incorrect." , " { \"Array\" : [ { \"name\" : \"Anne Vestor\" , \"userid\" : \"avestor\" , \"cash on hand\" : 10000 } ] } ", example.toString() );

        JSONObject example2 = test.read(" { \"Array\" : [ { \"name\" : \"Anne Vestor\" , \"userid\" : \"avestor\" , \"cash on hand\" : 10000 } ] } ");
        //Both should give the same output .
        assertTrue("They should be equal! " , example.toString().equals(example2.toString()));

        //Should be different as key values are different.
        example2 = test.read(" { \"Array2\" : [ { \"name\" : \"Anne Vestor\" , \"userid\" : \"avestor\" , \"cash on hand\" : 10000 } ] } ");
        assertFalse("They should be not be equal! " , example.toString().equals(example2.toString()));

        //Should be different as objects are different.
        example2 = test.read(" { \"Array\" : [ { \"name\" : \"Anne Vestor\" , \"userid\" : \"avestor\" } ] } ");
        assertFalse("They should be not be equal! " , example.toString().equals(example2.toString()));

        //Should be different as keys are same but values are different
        example = test.read(" { \"Array\" : [ { \"name\" : \"Anne Vest\" , \"userid\" : \"avest\" } ] } ");
        assertFalse("They should be not be equal! " , example.toString().equals(example2.toString()));


    }


}