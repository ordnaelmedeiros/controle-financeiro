package com.medeiros.ordnael.controlefinanceiro.repository.teste;

import java.time.Instant;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/teste")
@Produces(MediaType.APPLICATION_JSON)
public class TesteController {

	@RequestMapping(value="/ping", method = RequestMethod.GET)
	public @ResponseBody String ping() {
		
		 Logger logger = Logger.getLogger(TesteController.class);
			
			logger.info("info");
			logger.debug("teste");
			logger.error("erro");
		
 		return "ping " + Instant.now().getEpochSecond();
	}
	
	@RequestMapping(value="/objeto", method = RequestMethod.GET)
	public @ResponseBody ObjetoTeste get() {
		ObjetoTeste objetoTeste = new ObjetoTeste();
		objetoTeste.criar();
		return objetoTeste;
	}
	
	@RequestMapping(value="/objeto", method = RequestMethod.POST)
	public @ResponseBody ObjetoTeste post(@RequestBody ObjetoTeste obj) {
		return obj;
	}
	
}