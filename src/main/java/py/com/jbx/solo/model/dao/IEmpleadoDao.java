package py.com.jbx.solo.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.jbx.solo.model.entity.Empleado;

public interface IEmpleadoDao extends JpaRepository<Empleado, Long> {
	
	public List<Empleado> findByNombreIgnoreCase(String nombre);

}
