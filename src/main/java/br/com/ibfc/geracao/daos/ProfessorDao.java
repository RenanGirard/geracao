package br.com.ibfc.geracao.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ibfc.geracao.models.Professor;
import br.com.ibfc.geracao.models.PaginatedList;

@Repository
public class ProfessorDao {
	@PersistenceContext
	   private EntityManager manager;

	   public List<Professor> all()
	   {
	      return manager.createQuery("select c from Professor c", Professor.class).getResultList();
	   }

	   public void save(Professor professor)
	   {
	      manager.persist(professor);
	   }

	   public Professor findById(Integer id)
	   {
	      return manager.find(Professor.class, id);
	   }

	   public void remove(Professor professor)
	   {
	      manager.remove(professor);
	   }

	   public void update(Professor professor)
	   {
	      manager.merge(professor);
	   }

	   public PaginatedList paginated(int page, int max)
	   {
	      return new PaginatorQueryHelper().list(manager, Professor.class, page, max);
	   }
}
