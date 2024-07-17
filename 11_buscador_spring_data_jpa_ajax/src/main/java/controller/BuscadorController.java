package controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.Resultado;
import jakarta.servlet.http.HttpServletRequest;
import model.ResultadoDto;
import service.BuscadorService;
import org.springframework.beans.factory.annotation.Qualifier;
@Controller
public class BuscadorController {
	@Autowired
	@Qualifier("buscadorEstandar")
	BuscadorService service;
	
	@GetMapping(value="buscar",produces=MediaType.APPLICATION_JSON_VALUE)// produces=MediaType.APPLICATION_JSON_VALUE esto es opcional si pones el @ResponseBody
	public @ResponseBody List<ResultadoDto> buscarResultados(@RequestParam("tematica")String tematica) {
		
		
		 return service.buscar(tematica);
	}
	
	
	@PostMapping(value="alta")
	public String altaResultados(@ModelAttribute ResultadoDto resultado) {

		
		
		return service.agregar(resultado)?"inicio":"error";
}
	@GetMapping(value="buscarUno")
	public @ResponseBody   ResultadoDto buscarResultado(@RequestParam("url") String url) {
		
		return service.buscarPorUrl(url);
	}
	
	@PostMapping(value="eliminar")
	public String eliminarResultado(@RequestParam("url") String url) {
		service.eliminar(url);
		return "inicio";
	}
	
	
	
}
