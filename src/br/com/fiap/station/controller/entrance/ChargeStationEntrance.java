package br.com.fiap.station.controller.entrance;

import br.com.fiap.station.model.ChargeStation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ChargeStationEntrance {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("chargeStation");

	EntityManager manager = factory.createEntityManager();
	
	public void inserir(ChargeStation estacaoRecarga) {
		manager.getTransaction().begin();
		manager.persist(estacaoRecarga);
		manager.getTransaction().commit();
	}
	
	public void delecao(ChargeStation estacaoRecarga) {
		manager.getTransaction().begin();
		manager.remove(manager.merge(estacaoRecarga));
		manager.getTransaction().commit();
	}

	public List<ChargeStation> listarEstacoes(){
		String jpql = "SELECT esr FROM ChargeStation esr";
		TypedQuery<ChargeStation> busca = manager.createQuery(jpql , ChargeStation.class);

		return busca.getResultList();
	}
}
