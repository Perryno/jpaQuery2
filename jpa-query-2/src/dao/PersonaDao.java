package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Persona;

public class PersonaDao {
	private final EntityManager entityManager;

	public PersonaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void SalvaPersona(Persona persona) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(persona);
		transaction.commit();
		System.out.println("Persona salvata");
	}
}
