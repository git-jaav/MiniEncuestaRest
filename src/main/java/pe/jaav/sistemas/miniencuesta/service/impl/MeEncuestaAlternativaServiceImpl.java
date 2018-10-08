package pe.jaav.sistemas.miniencuesta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jaav.sistemas.miniencuesta.model.dao.MeEncuestaAlternativaDao;
import pe.jaav.sistemas.miniencuesta.model.domain.MeEncuestaAlternativa;
import pe.jaav.sistemas.miniencuesta.service.MeEncuestaAlternativaService;

@Service
@Transactional(readOnly = true)
public class MeEncuestaAlternativaServiceImpl implements MeEncuestaAlternativaService{

	@Autowired
	MeEncuestaAlternativaDao meEncuestaAlternativaDao;
	
	@Override
	public MeEncuestaAlternativa obtenerPorId(Integer id) {		
		return meEncuestaAlternativaDao.findById(id);
	}

	@Override
	public int contarListado(MeEncuestaAlternativa objDao) {		
		return meEncuestaAlternativaDao.contarListado(objDao);
	}

	@Override
	public List<MeEncuestaAlternativa> listar(MeEncuestaAlternativa objDao, boolean paginable) {
		return meEncuestaAlternativaDao.listar(objDao,paginable);
	}

	@Override
	@Transactional(readOnly = false)
	public int guardar(MeEncuestaAlternativa objDao) {		
		return meEncuestaAlternativaDao.guardar(objDao);
	}

	@Override
	@Transactional(readOnly = false)
	public int actualizar(MeEncuestaAlternativa objDao) {
		meEncuestaAlternativaDao.update(objDao);
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int eliminar(MeEncuestaAlternativa objDao) {
		meEncuestaAlternativaDao.delete(objDao);
		return 1;
	}

}
