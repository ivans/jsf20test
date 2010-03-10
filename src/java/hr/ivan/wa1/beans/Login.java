/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivan.wa1.beans;

import hr.ivan.wa1.model.User;
import hr.ivan.wa1.qualifiers.LoggedIn;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 *
 * @author ivans
 */
@Named
@SessionScoped
public class Login implements Serializable {

    @Produces
    @LoggedIn
    User getCurrentUser() {
        System.out.println("Login.getCurrentUser");
        User user = new User();
        user.setFirstName("Ivan");
        user.setLastName("Senji");
        return user;
    }
}
