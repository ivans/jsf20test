package hr.ivan.wa1.data.dao;

import hr.ivan.wa1.model.User;
import hr.ivan.wa1.qualifiers.JsfTestDatabase;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author ivan
 */
@SessionScoped
public class UserDao implements Serializable {

    @Inject
    @JsfTestDatabase
    EntityManager em;

    public List<User> findAllUsers() {
        return em.createQuery("from User").getResultList();
    }
}
