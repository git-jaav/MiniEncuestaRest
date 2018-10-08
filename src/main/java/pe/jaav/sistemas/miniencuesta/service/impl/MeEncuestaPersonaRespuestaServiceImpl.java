package pe.jaav.sistemas.miniencuesta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jaav.sistemas.miniencuesta.model.dao.MeEncuestaPersonaRespuestaDao;
import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaPersonaRespuesta;
import pe.jaav.sistemas.miniencuesta.service.MeEncuestaPersonaRespuestaService;

@Service
@Transactional(readOnly = true)
public class MeEncuestaPersonaRespuestaServiceImpl implements MeEncuestaPersonaRespuestaService {

	@Autowired
	MeEncuestaPersonaRespuestaDao meEncuestaPersonaRespuestaService;
	
	@Override
	public MeEncuestaPersonaRespuesta obtenerPorId(Long id) {		
		return meEncuestaPersonaRespuestaService.findById(id);
	}

	@Override
	public int contarListado(MeEncuestaPersonaRespuesta objDao) {		
		return meEncuestaPersonaRespuestaService.contarListado(objDao);
	}

	@Override
	public List<MeEncuestaPersonaRespuesta> listar(MeEncuestaPersonaRespuesta objDao, boolean paginable) {
		return meEncuestaPersonaRespuestaService.listar(objDao, paginable);
	}

	@Override
	@Transactional(readOnly = false)
	public long guardar(MeEncuestaPersonaRespuesta objDao) {	
		return meEncuestaPersonaRespuestaService.guardar(objDao);
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(MeEncuestaPersonaRespuesta objDao) {
		meEncuestaPersonaRespuestaService.update(objDao);
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(MeEncuestaPersonaRespuesta objDao) {
		meEncuestaPersonaRespuestaService.delete(objDao);
		return 1;
	}

}
