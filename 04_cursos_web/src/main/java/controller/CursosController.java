package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import model.Curso;
import service.CursosService;
@Controller
public class CursosController {
	@Autowired
	CursosService service;
	
	@PostMapping(value="alta")
	public String GuardarResultados(@ModelAttribute Curso curso) {
		return service.guardar(curso)?"inicio":"error";
		
	}
	@GetMapping(value="buscar")
	public String BuscarPorPrecioMax(@RequestParam ("precioMax")Double precioMax, HttpServletRequest request ) {
		ArrayList<Curso> curso =service.preciosCursoMax(Double.parseDouble(request.getParameter("precio")));;
		request.setAttribute("curso", curso);
		return "curso";
	}
	@PostMapping(value="eliminar")
	public String Eliminar (@RequestParam ("nombre") String nombre  ) {
		 service.eliminarCurso(nombre);
		return "menu";
}
}