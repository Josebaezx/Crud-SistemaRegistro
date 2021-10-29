package py.com.jbx.solo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import py.com.jbx.solo.model.dao.IUsuarioDao;
import py.com.jbx.solo.model.entity.Usuario;

@SpringBootTest
class CrudPracticoSoloApplicationTests {
	@Autowired
	private IUsuarioDao repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
		
	@Test
	public void crearUsuario() {
		Usuario us= new Usuario();
		us.setUsername("Admin");
		us.setPassword(encoder.encode("unida2021"));
		
		Usuario retorno=repo.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
