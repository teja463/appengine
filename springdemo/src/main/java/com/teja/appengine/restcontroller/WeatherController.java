package com.teja.appengine.restcontroller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.teja.appengine.beans.DialogResponse;
import com.teja.appengine.beans.Weather;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Weather get(){
		
		
//		String response = restTemplate.getForObject("http://api.worldweatheronline.com/premium/v1/weather.ashx?format=json&num_of_days=1&q=Bangalore&key=e91fb8fc2f084bd6916134145170112&date=", String.class);
		
		Weather weather = restTemplate.getForObject("http://api.worldweatheronline.com/premium/v1/weather.ashx?format=json&num_of_days=1&q=Bangalore&key=e91fb8fc2f084bd6916134145170112&date=", Weather.class);
		/*Gson gson = new Gson();
		JsonObject json = gson.fromJson(response, JsonObject.class);
		JsonArray asJsonArray = json.getAsJsonObject("data").getAsJsonArray("request");
		System.out.println(asJsonArray);*/
		System.out.println("weather: "+weather);
		return weather;
	}

	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public DialogResponse post(HttpEntity<byte []> httpEntity){
		byte[] body = httpEntity.getBody();
		String strBody = new String(body);
		System.out.println("reqBody: "+strBody);
		Gson gson = new Gson();
		JsonObject jsonReq = gson.fromJson(strBody, JsonObject.class);
		JsonObject paramObj = jsonReq.getAsJsonObject("result").getAsJsonObject("parameters");
		
		String date= paramObj.get("date").getAsString();
		String city= paramObj.get("geo-city").getAsString();
		
		String result = "Current temparature in "+ city + " on "+date +" is " +new Random().nextInt(50);
		DialogResponse resp = new DialogResponse();
		resp.setDisplayText(result);
		resp.setSpeech(result);
		return resp;
	}
}
