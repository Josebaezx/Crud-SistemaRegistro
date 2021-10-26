package py.com.jbx.solo.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.jbx.solo.model.entity.Empleado;

public interface IEmpleadoDao extends JpaRepository<Empleado, Long>{
	

}
