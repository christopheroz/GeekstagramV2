package ort.geekstagram_student.service;

import ort.geekstagram_student.model.PostStagram;

/**
 * @author Jessica MANGINI
 * @interface IPostService
 */
public interface IPostService
{
	public Iterable<PostStagram> getAllPosts();
	public Iterable<PostStagram> getAllPostsByIdUser(Long id_user);
	public PostStagram getPostByIdPost(int id_post);
	public PostStagram getPostByIdUser(Long id_user);
	public boolean addPost(PostStagram post, long id_user) throws Exception;
	public boolean updatePost(int id_post, PostStagram post) throws Exception;
	public boolean removePost(int id_post) throws Exception;
}
