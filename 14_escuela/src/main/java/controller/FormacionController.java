package controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.AlumnoDto;
import service.FormacionService;

@Controller
public class FormacionController {

		FormacionService formacionService;

		public FormacionController(FormacionService formacionService) {  // para inyectar
			super();
			this.formacionService = formacionService;
		}
		@GetMapping (value="/")// la barra nos indica que es la pagina inicial
		public String inicial(Model model) {
			model.addAttribute("cursos", formacionService.cursos());
			return "cursos";
	}
		
		@GetMapping(value="buscarAlumnosPorCurso",produces=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody List<AlumnoDto> alumnosPorCurso(@RequestParam("idCurso")int idCurso){
			
			return formacionService.buscarAlumnosMatriculados(idCurso);
		} 
}

