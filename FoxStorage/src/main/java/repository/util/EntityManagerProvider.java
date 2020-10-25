package repository.util;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public final class EntityManagerProvider {

	@PersistenceContext(unitName = "FoxDS")
	private EntityManager em;
	
	public EntityManager getEntityManager() {
		return em;
	}
}
