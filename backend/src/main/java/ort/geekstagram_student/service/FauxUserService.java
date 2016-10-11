package ort.geekstagram_student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ort.geekstagram_student.controller.Tool;
import ort.geekstagram_student.model.User;

/**
 *
 * @author christophe
 */
@Component
@Qualifier("FauxUserService")
public class FauxUserService implements IUserService {

    /**
     * Fausse liste des utilisateurs
     */
    public static List<User> liste = new ArrayList<User>();
    private int error = 0;

    /**
     * Ajouter un utilisateur
     *
     * @param u
     * @return
     */
    @Override
    public boolean add(User u) {
        if (Tool.validateEmail(u.getEmail())) {
            for (User user : liste) {
                if (user.getEmail().equalsIgnoreCase(u.getEmail())) {
                    error++;
                }
            }
        } else {
            error++;
        }
        if (error == 0) {
            liste.add(u);
            return true;
        } else {
            error = 0;
            return false;
        }
    }

    /**
     * Supprimer un utilisateur
     *
     * @param id
     */
    @Override
    public void remove(Long id) {
        for (User user : liste) {
            if (user.getId() == id) {
                liste.remove(user);
            }
        }
    }

    /**
     * @return Liste des utilisateurs
     */
    @Override
    public List<User> getAll() {
        return liste;
    }

    /**
     *
     * @param id
     * @return l'utilisateur selectionné
     */
    @Override
    public User getById(Long id) {
        System.out.println(id);
        User this_user = new User();
        for (User user : liste) {
            if (user.getId() == id) {
                this_user = user;
            }
        }
        return this_user;
    }

    /**
     *
     * @param id
     * @param entity
     * @return L'utilisateur mise à jours
     */
    @Override
    public User update(Long id, User entity) {
        User this_user = new User();
        System.out.println(entity.getName());
        for (User user : liste) {
            System.out.print(user.getId() + " fonction update fauxuserservice " + id);
            if (user.getId() == id) {
                user.setEmail(entity.getEmail());
                user.setName(entity.getName());
                user.setPassword(entity.getPassword());
                return this_user = user;
            }
        }
        System.out.print(this_user.getEmail() + " fonction update fauxuserservice2");
        return this_user;
    }
}
