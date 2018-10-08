package pe.jaav.sistemas.MiniEncuestaRest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.jaav.sistemas.miniencuesta.utiles.Constant;


@RestController
@CrossOrigin
@RequestMapping("status")
public class StatusController {

	@GetMapping(value="verificar")
	public ResponseEntity<String> verificarToken(){
		return new ResponseEntity<String>(Constant.RESULT_OK, HttpStatus.OK);
	}
}
