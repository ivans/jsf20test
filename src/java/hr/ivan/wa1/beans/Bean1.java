/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivan.wa1.beans;

import hr.ivan.wa1.data.dao.UserDao;
import hr.ivan.wa1.model.User;
import hr.ivan.wa1.qualifiers.LoggedIn;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Transient;
import org.jboss.weld.conversation.ConversationManager;

/**
 *
 * @author ivans
 */
@Named("bean1")
@SessionScoped
public class Bean1 implements Serializable {

    @Inject
    private Event<FieldAccess> fieldAccess;
    @Inject
    @LoggedIn
    User currentUser;
    @EJB
    UserDao userDao;
    private User selectedUser;

    public String getTrenutniUser() {
        return currentUser != null ? currentUser.toString() : "Nema korisnika";
    }

    public void observerFieldAccess(@Observes FieldAccess fa) {
        System.out.println("Accessed field: " + fa);
    }
    private Random rand = new Random();

    @Produces
    @Named("randomBroj")
    public String getNekiBroj() {
        return Integer.toString(rand.nextInt());
    }

    public List<User> getAllUsers() {
        return userDao.findAllUsers();
    }

    public String saveSelectedUser() {
        System.out.println("Saving user " + selectedUser.getUsername());
        userDao.save(selectedUser);
        return "";
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
}
