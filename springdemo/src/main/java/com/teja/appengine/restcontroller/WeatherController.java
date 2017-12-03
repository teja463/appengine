package com.teja.appengine.restcontroller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
		DialogResponse resp = new DialogResponse();
		resp.setDisplayText(strBody);
		resp.setSpeech("Sample response from spring demo");
		return resp;
	}
}
