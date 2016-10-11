package ort.geekstagram_student.service;

import java.util.List;

import ort.geekstagram_student.model.User;

/**
 *
 * @author christophe
 */
public interface IUserService {

    /**
     *
     * @param u
     * @return
     */
    public boolean add(User u);

    /**
     *
     * @param id
     */
    public void remove(Long id);

    /**
     *
     * @return
     */
    public List<User> getAll();

    /**
     *
     * @param id
     * @return
     */
    public User getById(Long id);

    /**
     *
     * @param id
     * @param entity
     * @return
     */
    public User update(Long id, User entity);
}
