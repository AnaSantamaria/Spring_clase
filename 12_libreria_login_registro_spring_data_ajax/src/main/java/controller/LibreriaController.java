package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpSession;
import model.ClienteDto;
import model.LibroDto;
import service.ClientesService;
import service.LibrosService;

@Controller
public class LibreriaController {
//@Autowired tambien se puede usar para inllectar los services, pero mejor con constructor para facilitar pruebas
@Qualifier("")

ClientesService clientesService;

LibrosService librosService;




public LibreriaController(ClientesService clientesService, LibrosService librosService) {  // Contructor para inyectar
	super();
	this.clientesService = clientesService;
	this.librosService = librosService;
}

//Agregar carrito

@GetMapping(value="agregarCarrito",produces=MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody List<LibroDto> agregarCarrito(@RequestParam("isbn") int isbn,@SessionAttribute("carrito") List<LibroDto> carrito) {
	
	LibroDto libro=librosService.getLibro(isbn);
	//recogemos el libro cuyo ISBN se recibe como parámetro
	carrito.add(libro);
	return carrito;
}
//Registro usuario

@PostMapping(value="registrarCliente",produces=MediaType.TEXT_PLAIN_VALUE)
public @ResponseBody String registro (@ModelAttribute ClienteDto cliente) {
	return String.valueOf(clientesService.registrar(cliente));
	
	
	
	
}

//Libros controller
@GetMapping(value="librosTema",produces=MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody List<LibroDto> librosTemas(@RequestParam("idTema")int idTema){
	
	return librosService.librosTema(idTema);
}

//Login
@GetMapping(value="login",produces=MediaType.APPLICATION_JSON_VALUE)
 public String autenticar (@RequestParam("usuario") String usuario,@RequestParam("password") String password) {
	 
	 if(clientesService.autenticar(usuario, password)) {
		 
		 return "inicio";
	 }
	 
	 return "registro";
 }



//Quitar carrito

@GetMapping(value="eliminarCarrito",produces=MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody List<LibroDto> quitarCarrito(@RequestParam("pos") int pos, @SessionAttribute("carrito") List<LibroDto> carrito){
	
			
	carrito.remove(pos);
	return carrito;
}

//Alta libro

@PostMapping(value="altaLibro",produces=MediaType.TEXT_PLAIN_VALUE)
//el idTema lo recogemos a parte para después construir el TemaDto
public @ResponseBody String altaLibro(@ModelAttribute LibroDto libro, @RequestParam("idTema")int idTema) {
	libro.setTemaDto(librosService.getTema(idTema));
	return String.valueOf(librosService.guardarLibro(libro));
}


@GetMapping(value="temas")
public String temas(Model model) {
	model.addAttribute("temas", librosService.getTemas());
	return "visor";
}
@GetMapping(value="prepararAlta")
public String preparaAlta(Model model) {
	model.addAttribute("temas", librosService.getTemas());
	return "alta";
}
//

}
