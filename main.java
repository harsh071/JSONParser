public class main {
    public static void main(String[] args) {
        System.out.println("HII");

        JSONQueryManager lol  = JSONFactory.getJSONQueryManager();
//        lol.loadJSON(" { \"Array\" : [ { \"name\" : \"Anne Vestor\" , \"userid\" : \"avestor\" , \"cash on hand\" : 10000 } , { \"name\" : [ \"Anne Vestor\" , \"Harsh Patel\" ] , \"userid\" : \"avestor\" , \"cash on hand\" : 10000 } ] } ");
        try {
//            lol.getJSONValue("Array[1]");
//            lol.getJSONValue("Array[0]");
//            lol.loadJSON(" { \"Array\" : [ { \"name\" : \"Anne Vestor\" , \"userid\" : \"avestor\" , \"cash on hand\" : 10000 } , { \"name\" : [ { \"Surname\" : \"Patelz\" } , \"Harsh Patel\" ] , \"userid\" : \"avestor\" , \"cash on hand\" : 10000 } ] } ");
//            lol.getJSONValue("Array[1].name[0].Surname");
//            lol.getJSONValue("Array[1].name[0]");

            lol.loadJSON(" { \"Array\" : [ [ 10 ] ] } ");

            lol.getJSONValue("Array[0][0]");
//            lol.getJSONValue("name");
//
//            lol.getJSONValue("cash dfsads");
        }catch (IllegalStateException e){
            System.out.println("Please Load a JSON first .");
        }
    }
}
