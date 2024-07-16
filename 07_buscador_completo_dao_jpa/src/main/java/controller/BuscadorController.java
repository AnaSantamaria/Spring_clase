package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping(value="buscar")
	public String buscarResultados(@RequestParam("tematica")String tematica,HttpServletRequest request) {
		
		List<ResultadoDto> resultado=service.buscar(tematica);
		request.setAttribute("resultados", resultado);
		return "resultados";
	}
	
	
	@PostMapping(value="alta")
	public String altaResultados(@ModelAttribute ResultadoDto resultado) {

		
		
		return service.agregar(resultado)?"inicio":"error";
}
	@GetMapping(value="toBuscarResultados")
	public String buscarResultado(@RequestParam("url") String url,HttpServletRequest request) {
		ResultadoDto resultado=service.buscarPorUrl(url);
		
		request.setAttribute("resultado", resultado);
		return "resultado";
	}
	
	
	
}
