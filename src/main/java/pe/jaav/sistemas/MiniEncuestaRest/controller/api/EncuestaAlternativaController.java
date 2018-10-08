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

import pe.jaav.sistemas.MiniEncuestaRest.model.MeEncuestaAlternativaJson;
import pe.jaav.sistemas.MiniEncuestaRest.util.JsonViewAssembler;
import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaAlternativa;
import pe.jaav.sistemas.miniencuesta.service.MeEncuestaAlternativaService;
import pe.jaav.sistemas.miniencuesta.utiles.Constant;

@RestController
@CrossOrigin
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("api/encuestaalternativa")
public class EncuestaAlternativaController {

	
	private static final Logger logger = LoggerFactory.getLogger(EncuestaAlternativaController.class);

	@Autowired
	private MeEncuestaAlternativaService meEncuestaAlternativaService;
    
	private JsonViewAssembler<MeEncuestaAlternativa, MeEncuestaAlternativaJson> jsonAssemb = 
			 new JsonViewAssembler<MeEncuestaAlternativa, MeEncuestaAlternativaJson>(MeEncuestaAlternativaJson.class);
	
	private JsonViewAssembler<MeEncuestaAlternativaJson, MeEncuestaAlternativa> jsonAssembInverso = 
			 new JsonViewAssembler<MeEncuestaAlternativaJson, MeEncuestaAlternativa>(MeEncuestaAlternativa.class);
	
	
	/** ACCIONES */

	@GetMapping(value="id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MeEncuestaAlternativaJson> obtenerPorId(@PathVariable Integer id){
		try {
			MeEncuestaAlternativa objResult = meEncuestaAlternativaService.obtenerPorId(id);					
			return new ResponseEntity<MeEncuestaAlternativaJson>(jsonAssemb.getJsonObject(objResult), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(value="listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MeEncuestaAlternativaJson>> obtenerTodos(Pageable pageable){
		try {
			List<MeEncuestaAlternativa> lista = meEncuestaAlternativaService.listar(new MeEncuestaAlternativa(), false);						
			return new ResponseEntity<List<MeEncuestaAlternativaJson>>(jsonAssemb.getJsonList(lista), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value="listar/{enteCodigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MeEncuestaAlternativaJson>> listarTemaCodigo(
			@PathVariable String enteCodigo){
		try {
			MeEncuestaAlternativa filtro = new MeEncuestaAlternativa();
			filtro.setEnteCodigo(enteCodigo);
			filtro.setEnaltEstado(Constant.ACTIVO_db);
			List<MeEncuestaAlternativa> lista = meEncuestaAlternativaService.listar(filtro, false);						
			return new ResponseEntity<List<MeEncuestaAlternativaJson>>(jsonAssemb.getJsonList(lista), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value="guardar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MeEncuestaAlternativaJson> guardar(
			@RequestBody MeEncuestaAlternativaJson objJson){
		try {
			MeEncuestaAlternativa objPersist =  jsonAssembInverso.getJsonObject(objJson);
			int result =  meEncuestaAlternativaService.guardar(objPersist);
			if(result > 0){
				return new ResponseEntity<MeEncuestaAlternativaJson>(objJson, HttpStatus.OK);	
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
	public ResponseEntity<MeEncuestaAlternativaJson> actualizar(
			@RequestBody MeEncuestaAlternativaJson objJson){
		try {
			MeEncuestaAlternativa objPersist =  jsonAssembInverso.getJsonObject(objJson);
			int result =  meEncuestaAlternativaService.actualizar(objPersist);
			if(result > 0){
				return new ResponseEntity<MeEncuestaAlternativaJson>(objJson, HttpStatus.OK);	
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
	public ResponseEntity<MeEncuestaAlternativaJson> eliminar(
			@PathVariable Integer id){
		try {
			MeEncuestaAlternativa objDel = meEncuestaAlternativaService.obtenerPorId(id);			
			int result =  meEncuestaAlternativaService.eliminar(objDel);
			if(result > 0){
				MeEncuestaAlternativaJson objDelJson =  jsonAssemb.getJsonObject(objDel);
				return new ResponseEntity<MeEncuestaAlternativaJson>(objDelJson, HttpStatus.OK);	
			}else{
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}					
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
