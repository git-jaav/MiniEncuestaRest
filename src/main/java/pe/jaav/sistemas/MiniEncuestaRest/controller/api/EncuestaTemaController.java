package pe.jaav.sistemas.MiniEncuestaRest.controller.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaTema;
import pe.jaav.sistemas.miniencuesta.service.MeEncuestaTemaService;


@RestController
@CrossOrigin
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("api/encuestatema")
public class EncuestaTemaController {
	
	private static final Logger logger = LoggerFactory.getLogger(EncuestaTemaController.class);

	@Autowired
	private MeEncuestaTemaService meEncuestaTemaService;
	
	@GetMapping(value="listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MeEncuestaTema>> obtenerTodos(Pageable pageable){
		try {
			return new ResponseEntity<List<MeEncuestaTema>>(
					meEncuestaTemaService.listar(new MeEncuestaTema(), false), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="guardar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MeEncuestaTema> guardar(
			@RequestBody MeEncuestaTema negocio){
		try {
			int result =  meEncuestaTemaService.guardar(negocio);
			if(result > 0){
				return new ResponseEntity<MeEncuestaTema>(negocio, HttpStatus.OK);	
			}else{
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}			
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MeEncuestaTema> actualizar(
			@RequestBody MeEncuestaTema negocio){
		try {
			int result =  meEncuestaTemaService.actualizar(negocio);
			if(result > 0){
				return new ResponseEntity<MeEncuestaTema>(negocio, HttpStatus.OK);	
			}else{
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}			
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MeEncuestaTema> eliminar(
			@PathVariable int id){
		try {
			MeEncuestaTema objDel = meEncuestaTemaService.obtenerPorId(id);			
			int result =  meEncuestaTemaService.eliminar(objDel);
			if(result > 0){
				return new ResponseEntity<MeEncuestaTema>(objDel, HttpStatus.OK);	
			}else{
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}					
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
