/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivan.wa1.beans;

import hr.ivan.wa1.model.User;
import hr.ivan.wa1.qualifiers.LoggedIn;
import java.io.Serializable;
import java.util.Random;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import org.jboss.weld.conversation.ConversationManager;

/**
 *
 * @author ivans
 */
@Named("bean1")
@ConversationScoped
public class Bean1 implements Serializable {

    @Inject
    private Event<FieldAccess> fieldAccess;
    @Inject
    @LoggedIn
    User currentUser;

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
}
