package py.com.jbx.solo.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.jbx.solo.model.dao.IEmpleadoDao;
import py.com.jbx.solo.model.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	@Autowired
	private IEmpleadoDao empleadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> listar() {
		return empleadoDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Empleado empleado) {
		empleadoDao.save(empleado);

	}

	@Override
	@Transactional(readOnly = true)
	public Empleado buscar(Long id) {
		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		empleadoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> buscarPorNombre(String nombre) {
		return empleadoDao.findByNombreIgnoreCase(nombre);
	}

}
