package pe.jaav.sistemas.miniencuesta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jaav.sistemas.miniencuesta.model.dao.MeEncuestaTemaDao;
import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaTema;
import pe.jaav.sistemas.miniencuesta.service.MeEncuestaTemaService;

@Service
@Transactional(readOnly = true)
public class MeEncuestaTemaServiceImpl implements MeEncuestaTemaService {

	@Autowired
	MeEncuestaTemaDao meEncuestaTemaDao;
	
	@Override
	public MeEncuestaTema obtenerPorId(String id) {		
		return meEncuestaTemaDao.findById(id);
	}

	@Override
	public int contarListado(MeEncuestaTema objDao) {
		return meEncuestaTemaDao.contarListado(objDao);
	}

	@Override
	public List<MeEncuestaTema> listar(MeEncuestaTema objDao, boolean paginable) {		
		return meEncuestaTemaDao.listar(objDao, paginable);
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(MeEncuestaTema objDao) {
		meEncuestaTemaDao.save(objDao);
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(MeEncuestaTema objDao) {
		meEncuestaTemaDao.update(objDao);
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(MeEncuestaTema objDao) {
		meEncuestaTemaDao.delete(objDao);
		return 1;
	}

	@Override
	public boolean verificarStatusDB() {		
		return meEncuestaTemaDao.getHealthyStatus();
	}

}
