package ort.geekstagram_student.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author christophe
 * @class User
 *
 */
@Entity
@Table(name = "user_stagram")
public class User implements Serializable {

    /**
     * The ID of the User, auto generated
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The name of the user
     */
    @NotNull
    private String name;

    /**
     * The email of the user
     */
    @NotNull
    private String email;

    /**
     * The password of the user
     */
    @NotNull
    private String password;

    /**
     * The token of the user connection
     */
    private String token;

    public User() {
        super();
    }

    /**
     * Standard constructor
     *
     * @constructor
     * @param name String of the user
     * @param email String of the user
     * @param password String of the user
     */
    public User(String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

/**
 * Get id user
 * @return user id
 */
    public long getId() {
        return id;
    }

    /**
     * Set id user
     * @param id 
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get name user
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     * Set user name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get email user
     * @return email user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set user email
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get password user
     * @return password user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set user password
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get user token
     * 
     * @return token user
     */
    public String getToken() {
        return token;
    }

    /**
     * Set user Token
     * @param token 
     */
    public void setToken(String token) {
        this.token = token;
    }
}
