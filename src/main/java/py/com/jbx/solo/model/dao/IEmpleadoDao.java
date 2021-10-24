package py.com.jbx.solo.model.dao;

import java.util.List;

import py.com.jbx.solo.model.entity.Empleado;

public interface IEmpleadoDao {
	public List<Empleado> findAll();
	public void save(Empleado empleado);
	public Empleado findOne(Long id);
	public void delete(Long id);

}
