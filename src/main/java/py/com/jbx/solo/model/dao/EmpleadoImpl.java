package py.com.jbx.solo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.com.jbx.solo.model.entity.Empleado;

@Repository
public class EmpleadoImpl implements IEmpleadoDao {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		return em.createQuery("from Empleado").getResultList();
	}

	@Override
	@Transactional
	public void save(Empleado empleado) {
		if(empleado.getId() != null && empleado.getId() > 0) {
			em.merge(empleado);
		}else {
			em.persist(empleado);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findOne(Long id) {
		return em.find(Empleado.class, id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id));
	}

}
