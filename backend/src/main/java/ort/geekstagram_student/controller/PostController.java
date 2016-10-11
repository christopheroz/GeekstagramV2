package ort.geekstagram_student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ort.geekstagram_student.model.PostStagram;
import ort.geekstagram_student.service.IPostService;

/**
 * @author Jessica MANGINI
 * @class PostController
 */
@RestController
public class PostController
{
	
	@Autowired
	@Qualifier("FakeListPostService")
	private IPostService post_service;

	
	/**
	 * Get the full list of posts
	 *
	 * @return The list of posts
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET, value = "/api/posts")
	public Iterable<PostStagram> getAllPosts()
	{
		return this.post_service.getAllPosts();
	}
	
	/**
	 * Get the list of posts by id_user
	 *
	 * @param id_user
	 *            The ID user of the post
	 *            
	 * @return The list of posts
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET, value = "/api/posts/user/{id}")
	public Iterable<PostStagram> getAllPostsByIdUser(@PathVariable("id") long id_user)
	{
		return this.post_service.getAllPostsByIdUser(id_user);
	}
	

	/**
	 * Get one post by id_post
	 *
	 * @param id_post
	 *            The ID of the post
	 *            
	 * @return The post
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET, value = "/api/posts/{id}")
	public PostStagram getPostByIdPost(@PathVariable("id") int id_post)
	{
		try
		{
			return this.post_service.getPostByIdPost(id_post);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}		
	}
	

	/**
	 * Get one post by id_user
	 *
	 * @param id_user
	 *            The ID user of the post
	 *            
	 * @return The post
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET, value = "/api/post/user/{id}")
	public PostStagram getPostByIdUser(@PathVariable("id") long id_user)
	{
		try
		{
			return this.post_service.getPostByIdUser(id_user);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}		
	}
	
	/**
	 * Add one post
	 * 
	 * @param post
	 *            The post
	 *            
	 * @returns true if insert is ok or false
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, value = "/api/posts/user/{id}", consumes="application/json")
	public boolean addPost(@RequestBody PostStagram post,@PathVariable("id") Long id)
	{
		try
		{
			this.post_service.addPost(post,id);
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Update one post by id_post
	 * 
	 * @param id_post
	 *            The ID of the post
	 * @param post
	 *            The new post
	 *            
	 * @returns true if update is ok or false
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.PUT, value= "/api/posts/{id}", consumes="application/json")
	public boolean updatePost(@PathVariable("id") int id_post, @RequestBody PostStagram post)
	{
		try
		{
			return this.post_service.updatePost(id_post, post);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * Delete one post by id_post
	 * @param id_post
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.DELETE, value = "/api/posts/{id}")
	public boolean deletePost(@PathVariable("id") int id_post)
	{
		try
		{
			return this.post_service.removePost(id_post);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
