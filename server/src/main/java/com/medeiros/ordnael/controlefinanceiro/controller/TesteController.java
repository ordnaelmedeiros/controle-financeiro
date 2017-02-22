package com.medeiros.ordnael.controlefinanceiro.controller;

import java.time.Instant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/teste")
public class TesteController {

	@RequestMapping(value="/ping", method= RequestMethod.GET)
	public @ResponseBody String ping() {
		
 		return "ping " + Instant.now().getEpochSecond();
 		
	}
	
}