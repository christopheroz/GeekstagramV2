package ort.geekstagram_student.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ort.geekstagram_student.model.User;
import ort.geekstagram_student.service.IUserService;

/**
 *
 * @author christophe
 *
 */
@RestController
public class UserRestController {

    /**
     * Faux Repository of the users
     */
    @Autowired
    @Qualifier("FauxUserService")
    private IUserService userService;

    private ResponseEntity response;

    /**
     * Get the full list of comments
     *
     * @return La liste de tous les utilisateurs
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/api/users")
    public Iterable<User> getAll() {
        return userService.getAll();
    }

    /**
     * Ajouter un utilisateur
     *
     * @param User user, Objet utilisateur que l'on souhaite ajouter
     * @return l'id du user ou 1 si une erreur c'est produite
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/api/users")
    public Long add(@RequestBody User user) {
        User entity = null;
        try {
            entity = new User(user.getName(), user.getEmail(), user.getPassword());
            entity.setId(new Date().getTime());

            boolean addUser = userService.add(entity);
            if (addUser) {
                return entity.getId();
            } else {
                return new Long("1");
            }
        } catch (Exception e) {
            return new Long("1");
        }
    }

    /**
     * Modifier un utilisateur
     *
     * @param Long id, correspond à l'id de l'utilisateur
     * @param User user, Objet user que l'on veut modifier
     * @return ResponseEntity response 200 si ok ou 400 en cas d'erreur
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT, value = "/api/users/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody User user) {
        try {
            User entity = new User(user.getName(), user.getEmail(), user.getPassword());
            System.out.println(id + " controller");
            userService.update(id, entity);
            response = ResponseEntity.status(200).build();
        } catch (Exception e) {
            System.out.print(e);
            response = ResponseEntity.status(400).build();
        }

        return response;
    }

    /**
     * Supprimer un utilisateur
     *
     * @param id de l'utilisateur que l'on souhaite supprimer
     * @return ResponseEntity response 200 si ok ou 400 en cas d'erreur
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/users/{id}")
    public ResponseEntity remove(@PathVariable("id") long id) {
        try {
            userService.remove(id);
            response = ResponseEntity.status(200).build();
        } catch (Exception e) {
            response = ResponseEntity.status(400).build();
        }

        return response;
    }

    /**
     * Récupérer un utilisateur
     *
     * @param id
     * @return Retourne l'utilisateur demandé
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/api/users/{id}")
    public User getById(@PathVariable("id") Long id) {
        try {
            return userService.getById(id);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Tester l'API
     *
     * @return Retourne un utilisateur
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/api/users/test")
    public User test() {
        return new User("Test content", "test@test.fr", "mon mot de passe");
    }

    /**
     * Connecxion d'un utilisateur
     *  Envoie des informations de connexion de l'utilisateur
     * 
     * @param user
     * @return String token
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/api/users/connect")
    public String connect(@RequestBody User user) {
        String token = "1";
        //System.out.println(user.getEmail());

        for (User u : userService.getAll()) {
            if (u != null && user != null) {
                if (u.getEmail().equalsIgnoreCase(user.getEmail()) && u.getPassword().equalsIgnoreCase(user.getPassword())) {
                    token = UUID.randomUUID().toString();
                    u.setToken(token);
                }
            }
        }

        return token;
    }

    /**
     * Déconnection de l'utilisateur
     * @param id
     * @return 
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/api/users/disconect/{id}")
    public ResponseEntity disconnect(@PathVariable("id") long id) {

        try {
            for (User u : userService.getAll()) {
                if (u.getId() == id) {
                    if (!u.getToken().equalsIgnoreCase("")) {
                        u.setToken("1");
                        response = ResponseEntity.status(200).build();
                    } else {
                        response = ResponseEntity.status(400).build();
                    }
                }
            }

        } catch (Exception e) {
            response = ResponseEntity.status(400).build();
        }

        return response;

    }
}
