package br.com.ibfc.geracao.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ibfc.geracao.models.Responsavel;
import br.com.ibfc.geracao.models.PaginatedList;

@Repository
public class ResponsavelDao {

	   @PersistenceContext
	   private EntityManager manager;

	   public List<Responsavel> all()
	   {
	      return manager.createQuery("select c from Responsavel c", Responsavel.class).getResultList();
	   }

	   public void save(Responsavel responsavel)
	   {
	      manager.persist(responsavel);
	   }

	   public Responsavel findById(Integer id)
	   {
	      return manager.find(Responsavel.class, id);
	   }

	   public void remove(Responsavel responsavel)
	   {
	      manager.remove(responsavel);
	   }

	   public void update(Responsavel responsavel)
	   {
	      manager.merge(responsavel);
	   }

	   public PaginatedList paginated(int page, int max)
	   {
	      return new PaginatorQueryHelper().list(manager, Responsavel.class, page, max);
	   }

}
