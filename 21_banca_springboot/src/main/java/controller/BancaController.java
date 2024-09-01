package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.ClienteDto;
import model.MovimientoDto;
import service.BancaService;

@Controller
public class BancaController {

	BancaService bancaService;

	public BancaController(BancaService bancaService) {
		super();
		this.bancaService = bancaService;
	}
	
	@GetMapping("/validarCuenta/{numeroCuenta}")
    public ResponseEntity<Boolean> validarCuenta(@PathVariable int numeroCuenta) {
        boolean isValid = bancaService.validarCuenta(numeroCuenta);
        return new ResponseEntity<>(isValid, HttpStatus.OK);
    }

    @PostMapping("/ingreso")
    public ResponseEntity<Void> ingreso(@RequestParam int numeroCuenta, @RequestParam double cantidad) {
        try {
            bancaService.ingreso(numeroCuenta, cantidad);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/extraccion")
    public ResponseEntity<Void> extraccion(@RequestParam int numeroCuenta, @RequestParam double cantidad) {
        try {
            bancaService.extraccion(numeroCuenta, cantidad);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/transferencia")
    public ResponseEntity<Void> transferencia(@RequestParam int numeroCuentaOrigen,
                                              @RequestParam int numeroCuentaDestino,
                                              @RequestParam double cantidad) {
        try {
            bancaService.transferencia(numeroCuentaOrigen, numeroCuentaDestino, cantidad);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/titulares/{numeroCuenta}")
    public ResponseEntity<List<ClienteDto>> titularesCuenta(@PathVariable int numeroCuenta) {
        try {
            List<ClienteDto> titulares = bancaService.titularesCuenta(numeroCuenta);
            return new ResponseEntity<>(titulares, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/movimientos")
    public ResponseEntity<List<MovimientoDto>> movimientosCuentaFecha(@RequestParam int numeroCuenta,
                                                                      @RequestParam String fecha) {
        try {
            LocalDateTime fechaParsed = LocalDate.parse(fecha); // Conversión de String a LocalDate
            List<MovimientoDto> movimientos = bancaService.movimientosCuentaFecha(numeroCuenta, fechaParsed);
            return new ResponseEntity<>(movimientos, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
