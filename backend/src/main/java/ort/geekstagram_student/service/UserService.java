package ort.geekstagram_student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ort.geekstagram_student.model.User;
import ort.geekstagram_student.repository.IUserRepository;

/**
 * 
 * @author christophe
 */
@Component
@Qualifier("UserService")
public class UserService implements IUserService {

    private List<User> liste;

    //@Autowired
    //protected FauxUserService repository;
    /**
     * 
     * @param u
     * @return 
     */
    @Override
    public boolean add(User u) {
        // TODO Auto-generated method stub
        //repository.save(u);
        return true;
    }

    /**
     * 
     * @param id 
     */
    @Override
    public void remove(Long id) {
        // TODO Auto-generated method stub
        //repository.delete(id);
    }

    /**
     * 
     * @return 
     */
    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        //repository.findAll();
        return null;
    }

    /**
     * 
     * @param id
     * @return 
     */
    @Override
    public User getById(Long id) {
        // TODO Auto-generated method stub
        return null;//repository.findOne(id);
    }

    /**
     * 
     * @param id
     * @param entity
     * @return 
     */
    @Override
    public User update(Long id, User entity) {
        // TODO Auto-generated method stub
        return null;
    }

}
