package hr.ivan.wa1.beans;

import hr.ivan.wa1.qualifiers.JsfTestDatabase;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ivan
 */
public class JsfDatabaseProducer {

    @Produces
    @JsfTestDatabase
    @PersistenceContext
    EntityManager jsfEntityManager;
}
