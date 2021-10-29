package py.com.jbx.solo.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.jbx.solo.model.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
	Usuario findByUsername(String username);

}
