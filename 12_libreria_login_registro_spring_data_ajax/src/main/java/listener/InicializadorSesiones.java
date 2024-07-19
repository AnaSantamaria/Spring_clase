package listener;

import java.util.ArrayList;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import model.LibroDto;
@WebListener
public class InicializadorSesiones implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {//crear un atributo de sesion que cree un carrito cada vez que se inicie la sesion
		
		se.getSession().setAttribute("carrito", new ArrayList<LibroDto>());
	}

	

}
