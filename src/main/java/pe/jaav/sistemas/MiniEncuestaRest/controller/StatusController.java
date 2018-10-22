package pe.jaav.sistemas.MiniEncuestaRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.jaav.sistemas.miniencuesta.service.MeEncuestaTemaService;
import pe.jaav.sistemas.miniencuesta.utiles.Constant;


@RestController
@CrossOrigin
@RequestMapping("status")
public class StatusController {

	@Autowired
	private MeEncuestaTemaService meEncuestaTemaService;
	
//	@GetMapping(value="verificar")
//	public ResponseEntity<String> verificarStatus(){
//		return new ResponseEntity<String>(Constant.RESULT_OK, HttpStatus.OK);
//	}
	
	@GetMapping(value="verificar")
	public ResponseEntity<String> verificarStatusDB(){
		boolean statusOk = meEncuestaTemaService.verificarStatusDB();
		if(statusOk){
			return new ResponseEntity<String>(Constant.RESULT_OK, HttpStatus.OK);	
		}else{
			return new ResponseEntity<String>(Constant.RESULT_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
