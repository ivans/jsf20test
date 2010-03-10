package hr.ivan.wa1.data.dao;

import hr.ivan.wa1.model.User;
import hr.ivan.wa1.qualifiers.JsfTestDatabase;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Transient;

/**
 *
 * @author ivan
 */
@Stateless
public class UserDao {

    @Inject
    @JsfTestDatabase
    EntityManager em;

    public List<User> findAllUsers() {
        return em.createQuery("from User").getResultList();
    }

    @TransactionAttribute
    public void save(User user) {
        user = em.merge(user);
        em.persist(user);
    }
}
