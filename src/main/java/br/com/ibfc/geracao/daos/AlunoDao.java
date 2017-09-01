package br.com.ibfc.geracao.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ibfc.geracao.model.Aluno;
import br.com.ibfc.geracao.model.PaginatedList;

@Repository
public class AlunoDao {
	@PersistenceContext
	   private EntityManager manager;

	   public List<Aluno> all()
	   {
	      return manager.createQuery("select c from Aluno c", Aluno.class).getResultList();
	   }

	public void save(Aluno aluno)
	   {
	      manager.persist(aluno);
	   }

	   public Aluno findById(Integer id)
	   {
	      return manager.find(Aluno.class, id);
	   }

	   public void remove(Aluno aluno)
	   {
	      manager.remove(aluno);
	   }

	   public void update(Aluno aluno)
	   {
	      manager.merge(aluno);
	   }

	   public PaginatedList paginated(int page, int max)
	   {
	      return new PaginatorQueryHelper().list(manager, Aluno.class, page, max);
	   }
}
