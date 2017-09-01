package br.com.ibfc.geracao.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ibfc.geracao.model.PaginatedList;
import br.com.ibfc.geracao.model.Turma;

@Repository
public class TurmaDao {

	   @PersistenceContext
	   private EntityManager manager;

	   public List<Turma> all()
	   {
	      return manager.createQuery("select c from Turma c", Turma.class).getResultList();
	   }

	   public void save(Turma turma)
	   {
	      manager.persist(turma);
	   }

	   public Turma findById(Integer id)
	   {
	      return manager.find(Turma.class, id);
	   }

	   public void remove(Turma turma)
	   {
	      manager.remove(turma);
	   }

	   public void update(Turma turma)
	   {
	      manager.merge(turma);
	   }

	   public PaginatedList paginated(int page, int max)
	   {
	      return new PaginatorQueryHelper().list(manager, Turma.class, page, max);
	   }

}
