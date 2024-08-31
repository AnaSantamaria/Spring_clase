package controller;

import org.springframework.stereotype.Controller;

import service.BancaService;

@Controller
public class BancaController {

	BancaService bancaservice;

	public BancaController(BancaService bancaservice) {
		super();
		this.bancaservice = bancaservice;
	}
	
	
}
