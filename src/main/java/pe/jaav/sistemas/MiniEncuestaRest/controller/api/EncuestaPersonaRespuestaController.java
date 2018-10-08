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
import pe.jaav.sistemas.MiniEncuestaRest.model.MeEncuestaPersonaRespuestaJson;
import pe.jaav.sistemas.MiniEncuestaRest.util.JsonViewAssembler;
import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaAlternativa;
import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaPersonaRespuesta;
import pe.jaav.sistemas.miniencuesta.service.MeEncuestaPersonaRespuestaService;

@RestController
@CrossOrigin
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("api/encuestapersrespuesta")
public class EncuestaPersonaRespuestaController {

	private static final Logger logger = LoggerFactory.getLogger(EncuestaPersonaRespuestaController.class);

	@Autowired
	private MeEncuestaPersonaRespuestaService meEncuestaAlternativaService;
    
	private JsonViewAssembler<MeEncuestaPersonaRespuesta, MeEncuestaPersonaRespuestaJson> jsonAssemb = 
			 new JsonViewAssembler<MeEncuestaPersonaRespuesta, MeEncuestaPersonaRespuestaJson>(MeEncuestaPersonaRespuestaJson.class);
	
	private JsonViewAssembler<MeEncuestaPersonaRespuestaJson, MeEncuestaPersonaRespuesta> jsonAssembInverso = 
			 new JsonViewAssembler<MeEncuestaPersonaRespuestaJson, MeEncuestaPersonaRespuesta>(MeEncuestaPersonaRespuesta.class);
	
	
	/** ACCIONES */

	@GetMapping(value="id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MeEncuestaPersonaRespuestaJson> obtenerPorId(@PathVariable Long id){
		try {
			MeEncuestaPersonaRespuesta objResult = meEncuestaAlternativaService.obtenerPorId(id);					
			return new ResponseEntity<MeEncuestaPersonaRespuestaJson>(jsonAssemb.getJsonObject(objResult), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(value="listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MeEncuestaPersonaRespuestaJson>> obtenerTodos(Pageable pageable){
		try {
			List<MeEncuestaPersonaRespuesta> lista = meEncuestaAlternativaService.listar(new MeEncuestaPersonaRespuesta(), false);						
			return new ResponseEntity<List<MeEncuestaPersonaRespuestaJson>>(jsonAssemb.getJsonList(lista), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value="listar/{enteCodigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MeEncuestaPersonaRespuestaJson>> listarTemaCodigo(
			@PathVariable String enteCodigo){
		try {
			MeEncuestaPersonaRespuesta filtro = new MeEncuestaPersonaRespuesta();
			MeEncuestaAlternativa altFiltro = new MeEncuestaAlternativa();
			altFiltro.setEnteCodigo(enteCodigo);
			filtro.setMeEncuestaAlternativa(altFiltro);						
			List<MeEncuestaPersonaRespuesta> lista = meEncuestaAlternativaService.listar(filtro, false);						
			return new ResponseEntity<List<MeEncuestaPersonaRespuestaJson>>(jsonAssemb.getJsonList(lista), HttpStatus.OK);
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@PostMapping(value="guardar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MeEncuestaPersonaRespuestaJson> guardar(
			@RequestBody MeEncuestaPersonaRespuestaJson objJson){
		try {
			MeEncuestaPersonaRespuesta objPersist =  jsonAssembInverso.getJsonObject(objJson);
			long result =  meEncuestaAlternativaService.guardar(objPersist);
			if(result > 0){
				return new ResponseEntity<MeEncuestaPersonaRespuestaJson>(objJson, HttpStatus.OK);	
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
	public ResponseEntity<MeEncuestaPersonaRespuestaJson> actualizar(
			@RequestBody MeEncuestaPersonaRespuestaJson objJson){
		try {
			MeEncuestaPersonaRespuesta objPersist =  jsonAssembInverso.getJsonObject(objJson);
			int result =  meEncuestaAlternativaService.actualizar(objPersist);
			if(result > 0){
				return new ResponseEntity<MeEncuestaPersonaRespuestaJson>(objJson, HttpStatus.OK);	
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
	public ResponseEntity<MeEncuestaPersonaRespuestaJson> eliminar(
			@PathVariable Long id){
		try {
			MeEncuestaPersonaRespuesta objDel = meEncuestaAlternativaService.obtenerPorId(id);			
			int result =  meEncuestaAlternativaService.eliminar(objDel);
			if(result > 0){
				MeEncuestaPersonaRespuestaJson objDelJson =  jsonAssemb.getJsonObject(objDel);
				return new ResponseEntity<MeEncuestaPersonaRespuestaJson>(objDelJson, HttpStatus.OK);	
			}else{
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}					
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
