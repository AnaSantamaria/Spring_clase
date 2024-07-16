package utilidades;

import entities.Resultado;
import model.ResultadoDto;

public class Mapeador {
	
	
	public Resultado resultadoEntityToDto(Resultado resultado) {
		return new ResultadoDto(resultado.getUrl(),resultado.getTematica(),resultado.getDescripcion());
		
	}

	
public Resultado resultadoEntityToEntity (Resultado resultado) {
		
	return new Resultado(0,resultado.getUrl(),resultado.getTematica(),resultado.getDescripcion());
	}
}
