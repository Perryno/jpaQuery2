package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.EventoDao;
import dao.LocationDao;
import dao.PartecipazioneDao;
import dao.PersonaDao;
import entities.Evento;
import entities.Location;
import entities.Partecipazione;
import entities.Persona;
import entities.Sesso;
import entities.TipoEvento;
import lombok.extern.slf4j.Slf4j;
import utils.JpaUtil;

@Slf4j
public class Application {
	private static EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		log.info("Hello World!");
		System.out.println();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EventoDao eventoDao = new EventoDao(entityManager);
		PersonaDao personaDao = new PersonaDao(entityManager);
		LocationDao locationDao = new LocationDao(entityManager);
		PartecipazioneDao partecipazioneDao = new PartecipazioneDao(entityManager);

		Evento primoEvento = new Evento("Cena con la regina", LocalDate.now(), "En evento leggendario", 15,
				TipoEvento.PRIVATO, );
		eventoDao.saveEvent(primoEvento);

		Persona primaPersona = new Persona("Ilario", "Caserecci", "ilariocaserecci99@gmail.com", Sesso.MASCHIO,
				LocalDate.now());
		personaDao.salvaPersona(primaPersona);
		Location primaLocation = new Location(0, "Catania", "Via particolare");
		locationDao.saveLocation(primaLocation);
		Partecipazione primaPartecipazione = new Partecipazione();

		entityManager.close();
		entityManagerFactory.close();

	}

}
