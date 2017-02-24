package com.medeiros.ordnael.controlefinanceiro.core;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.medeiros.ordnael.controlefinanceiro.model.Gasto;

public class WebApiRest {
	
	private String urlBase = "http://localhost:8080/controlefinanceiro/";
	
	private static RestTemplate rest;
	
	static {
		
		rest = new RestTemplate();
		
	}
	
	public WebApiRest() {
		
	}
	
	public <T> T get(String url, Class<T> responseType) {
		return rest.getForObject(urlBase+url, responseType);
	}
	
	public <T> T post(String url, Object obj, Class<T> responseType) {
		ResponseEntity<T> entity = rest.postForEntity(urlBase+url, obj, responseType);
		return entity.getBody();
	}
	
}
