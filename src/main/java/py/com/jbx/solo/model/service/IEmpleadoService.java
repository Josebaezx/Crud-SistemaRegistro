package py.com.jbx.solo.model.service;

import java.util.List;

import py.com.jbx.solo.model.entity.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> listar();
	public void guardar(Empleado empleado);
	public Empleado buscar(Long id);
	public void eliminar(Long id);

}
