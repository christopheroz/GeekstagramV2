package ort.geekstagram_student.repository;

import ort.geekstagram_student.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author christophe
 * User repository, extending CrudRepository from Spring
 */
public interface IUserRepository extends CrudRepository<User,Long>{

}
