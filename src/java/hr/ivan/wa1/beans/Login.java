/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivan.wa1.beans;

import hr.ivan.wa1.model.User;
import hr.ivan.wa1.qualifiers.LoggedIn;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ivans
 */
@Named
@SessionScoped
public class Login implements Serializable {

    @Inject
    Credentials credentials;
    @PersistenceContext
    EntityManager entityManager;
    private User user;

    public void login() {
        List<User> results = entityManager.createQuery(
                "select u from User u where u.username = :username and u.password = :password")//
                .setParameter("username", credentials.getUsername())//
                .setParameter("password", credentials.getPassword())//
                .getResultList();

        if (!results.isEmpty()) {
            user = results.get(0);
        } else {
            // perhaps add code here to report a failed login
        }
    }

    public void logout() {
        user = null;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    @Produces
    @LoggedIn
    User getCurrentUser() {
        return user;
    }
}
