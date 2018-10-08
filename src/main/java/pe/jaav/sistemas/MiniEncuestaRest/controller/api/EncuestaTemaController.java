package pe.jaav.sistemas.MiniEncuestaRest.controller.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.jaav.sistemas.MiniEncuestaRest.model.MeEncuestaTemaJson;
import pe.jaav.sistemas.MiniEncuestaRest.util.JsonViewAssembler;
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

    
	private JsonViewAssembler<MeEncuestaTema, MeEncuestaTemaJson> jsonAssemb = 
			 new JsonViewAssembler<MeEncuestaTema, MeEncuestaTemaJson>(MeEncuestaTemaJson.class);
	
	private JsonViewAssembler<MeEncuestaTemaJson, MeEncuestaTema> jsonAssembInverso = 
			 new JsonViewAssembler<MeEncuestaTemaJson, MeEncuestaTema>(MeEncuestaTema.class);
	
	
	/** ACCIONES */

	@GetMapping(value="id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MeEncuestaTemaJson> obtenerPorId(@PathVariable String id){
		try {
			MeEncuestaTema objResult = meEncuestaTemaService.obtenerPorId(id);						
			return new ResponseEntity<MeEncuestaTemaJson>(jsonAssemb.getJsonObject(objResult), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(value="listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MeEncuestaTemaJson>> obtenerTodos(Pageable pageable){
		try {
			List<MeEncuestaTema> lista = meEncuestaTemaService.listar(new MeEncuestaTema(), false);						
			return new ResponseEntity<List<MeEncuestaTemaJson>>(jsonAssemb.getJsonList(lista), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value="guardar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MeEncuestaTemaJson> guardar(
			@RequestBody MeEncuestaTemaJson objJson){
		try {
			MeEncuestaTema objPersist =  jsonAssembInverso.getJsonObject(objJson);
			int result =  meEncuestaTemaService.guardar(objPersist);
			if(result > 0){
				return new ResponseEntity<MeEncuestaTemaJson>(objJson, HttpStatus.OK);	
			}else{
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}			
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value="actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MeEncuestaTemaJson> actualizar(
			@RequestBody MeEncuestaTemaJson objJson){
		try {
			MeEncuestaTema objPersist =  jsonAssembInverso.getJsonObject(objJson);
			int result =  meEncuestaTemaService.actualizar(objPersist);
			if(result > 0){
				return new ResponseEntity<MeEncuestaTemaJson>(objJson, HttpStatus.OK);	
			}else{
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}			
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value="eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MeEncuestaTemaJson> eliminar(
			@PathVariable String id){
		try {
			MeEncuestaTema objDel = meEncuestaTemaService.obtenerPorId(id);			
			int result =  meEncuestaTemaService.eliminar(objDel);
			if(result > 0){
				MeEncuestaTemaJson objDelJson =  jsonAssemb.getJsonObject(objDel);
				return new ResponseEntity<MeEncuestaTemaJson>(objDelJson, HttpStatus.OK);	
			}else{
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}					
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
