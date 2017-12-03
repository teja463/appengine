package springdemo;

import java.util.Random;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class GsonTest {

	@Test
	public void test() {
		Gson gson = new Gson();
		String strBody = "{\"id\":\"ba4a4f45-61f2-4947-8bb9-937d9d67955f\",\"timestamp\":\"2017-12-03T17:07:50.624Z\",\"lang\":\"en\",\"result\":{\"source\":\"agent\",\"resolvedQuery\":\"Bangalore\",\"speech\":\"\",\"action\":\"\",\"actionIncomplete\":false,\"parameters\":{\"date\":\"2017-12-03\",\"geo-city\":\"Bangalore\"},\"contexts\":[{\"name\":\"location\",\"parameters\":{\"date\":\"2017-12-03\",\"geo-city\":\"Bangalore\",\"date.original\":\"today\",\"geo-city.original\":\"Bangalore\"},\"lifespan\":5}],\"metadata\":{\"intentId\":\"0df08bc1-06b0-49df-807d-70eb883166ee\",\"webhookUsed\":\"true\",\"webhookForSlotFillingUsed\":\"false\",\"intentName\":\"weather\"},\"fulfillment\":{\"speech\":\"I don\\u0027t know the weather for 2017-12-03 in Bangalore but I hope it\\u0027s nice!\",\"messages\":[{\"type\":0,\"speech\":\"I don\\u0027t know the weather for 2017-12-03 in Bangalore but I hope it\\u0027s nice!\"}]},\"score\":1.0},\"status\":{\"code\":200,\"errorType\":\"success\",\"webhookTimedOut\":false},\"sessionId\":\"3548ccbd-b6ae-43d5-acd5-ed07cbd8d7cf\"}";
		JsonObject jsonReq = gson.fromJson(strBody, JsonObject.class);
		JsonObject paramObj = jsonReq.getAsJsonObject("result").getAsJsonObject("parameters");
		String date= paramObj.get("date").getAsString();
		String city= paramObj.get("geo-city").getAsString();
		
		System.out.println("Current temparature in "+String.valueOf(city) + " on "+String.valueOf(date) +" is " +new Random().nextInt(50)); 
	}

}
