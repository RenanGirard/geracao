package br.com.ibfc.geracao.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ibfc.geracao.model.Aulas;
import br.com.ibfc.geracao.model.PaginatedList;

@Repository
public class AulasDao {
	@PersistenceContext
	private EntityManager manager;

	public List<Aulas> all() {
		return manager.createQuery("select c from Aulas c", Aulas.class).getResultList();
	}

	public void save(Aulas aulas) {
		manager.persist(aulas);
	}

	public Aulas findById(Integer id) {
		return manager.find(Aulas.class, id);
	}

	public void remove(Aulas aulas) {
		manager.remove(aulas);
	}

	public void update(Aulas aulas) {
		manager.merge(aulas);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Aulas.class, page, max);
	}
}
