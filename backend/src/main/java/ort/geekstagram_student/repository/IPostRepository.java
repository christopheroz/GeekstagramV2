package ort.geekstagram_student.repository;

import ort.geekstagram_student.model.PostStagram;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Jessica MANGINI
 * Post repository, extending CrudRepository from Spring
 */
public interface IPostRepository extends CrudRepository<PostStagram, Integer>{

}
