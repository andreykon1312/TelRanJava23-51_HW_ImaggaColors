package telran.imagga.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import telran.imagga.dto.ResponseDto;
import telran.imagga.dto.Color;

public class imaggaClientAppl {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization",
				"Basic YWNjX2RiM2I3OTk1YzY1YTE1ZTo4YTRmOTRlYzA4YzVjM2RlNGIyMTFiNDJkZDY4NThlOA==");
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);

		String url = "https://api.imagga.com/v1/categorizations/nsfw_beta";

		String endpoints = "?url=https://imagga-com-assets.azureedge.net/static/images/nsfw/girl-1211435_960_720.jpg";
		ResponseEntity<ResponseDto> response = restTemplate.exchange(url + endpoints, HttpMethod.GET, requestEntity,
				ResponseDto.class);
displayColors(response.getBody().getResults()[0].getColors());

	}

	private static void displayColors(Color[] colors) {
		Arrays.stream(colors)
		.forEach(t -> System.out.println(t.getColors()+
				"->"+t.getConfidence()));
		
	}
}
