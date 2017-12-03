package com.teja.appengine.restcontroller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.teja.appengine.beans.Weather;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	private static final Log logger = LogFactory.getLog(WeatherController.class);
	
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
}
