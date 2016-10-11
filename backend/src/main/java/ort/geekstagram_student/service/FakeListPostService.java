package ort.geekstagram_student.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ort.geekstagram_student.model.PostStagram;

/**
 * 
 * @author Jessica MANGINI
 */
@Component
@Qualifier("FakeListPostService")
public class FakeListPostService implements IPostService
{
	private int id=0;
	public static ArrayList<PostStagram> liste = new ArrayList<PostStagram>();
	
	/**
	 * Get the full list of posts
	 *            
	 * @returns The full list of posts
	 */
	@Override
	public Iterable<PostStagram> getAllPosts()
	{
		return this.liste;
	}

	/**
	 * Get list of posts by id_user
	 * 
	 * @param id_user
	 *            The ID user of the post
	 *            
	 * @returns The list of posts 
	 */
	@Override
	public Iterable<PostStagram> getAllPostsByIdUser(Long id_user)
	{
		ArrayList<PostStagram> return_user_post = new ArrayList<PostStagram>();
		Iterable<PostStagram> allPosts = this.liste;
		for(PostStagram tmp_post : allPosts)
		{
			if(tmp_post.getId_user() == id_user)
			{
				return_user_post.add(tmp_post);
			}
		}
		return return_user_post;
	}

	/**
	 * Get one post by id_post
	 * 
	 * @param id_post
	 *            The ID of the post
	 *            
	 * @returns The post
	 */
	@Override
	public PostStagram getPostByIdPost(int id_post)
	{
		PostStagram return_post = new PostStagram();
		Iterable<PostStagram> allPosts = this.liste;
		for(PostStagram tmp_post : allPosts)
		{
			if(tmp_post.getId_post() == id_post)
			{
				return_post = tmp_post;
			}
		}
		return return_post;
	}

	/**
	 * Get one post by id_user
	 * 
	 * @param id_user
	 *            The ID user of the post
	 *            
	 * @returns The post of the user
	 */
	@Override
	public PostStagram getPostByIdUser(Long id_user)
	{
		PostStagram return_post = new PostStagram();
		Iterable<PostStagram> allPosts = this.liste;
		for(PostStagram tmp_post : allPosts)
		{
			if(tmp_post.getId_user() == id_user)
			{
				return_post = tmp_post;
			}
		}
		return return_post;
	}

	/**
	 * Add one post
	 * 
	 * @param post
	 *            The post
	 *            
	 * @returns true if insert is ok or false
	 */
	@Override
	public boolean addPost(PostStagram post,long id_user) throws Exception
	{
		if(!this.liste.contains(post))
		{
			post.setId_post(this.id++);
			post.setDate_post(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			if(id_user != 0){
				post.setId_user(id_user);
			}
			this.liste.add(post);
			return true;
		}
		else
		{
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
	@Override
	public boolean updatePost(int id_post, PostStagram post) throws Exception
	{
		//edit
		Iterable<PostStagram> allPosts = this.liste;
		for(PostStagram tmp_post : allPosts)
		{
			if(tmp_post.getId_post() == id_post)
			{
				if(post.getContent_post() != null)
				{
					tmp_post.setContent_post(post.getContent_post());
				}
				
				if(post.getId_user() != 0)
				{
					tmp_post.setId_user(post.getId_user());
				}
				else
				{
					tmp_post.setId_user(123456);
				}
				
				if(post.getDate_post() != null)
				{
					tmp_post.setDate_post(post.getDate_post());
				}
				
			}
		}
		
		//check edit
		PostStagram new_post = getPostByIdPost(id_post);
		boolean test = true;
		if(post.getContent_post() != null)
		{
			if(!new_post.getContent_post().equals(post.getContent_post()))
			{
				test = false;
			}
		}
		if(post.getId_user() != 0)
		{
			if(new_post.getId_user() != post.getId_user())
			{
				test = false;
			}
		}
		if(post.getDate_post() != null)
		{
			if(new_post.getDate_post().equals(post.getDate_post()))
			{
				test = false;
			}
		}
		return test;
	}

	/**
	 * Remove one post by id_post
	 * 
	 * @param id_post
	 *            The ID of the post
	 *            
	 * @returns true if delete is ok or false
	 */
	@Override
	public boolean removePost(int id_post) throws Exception
	{
		//delete
		this.liste.remove(id_post);

		//check delete
		PostStagram delete_post = getPostByIdPost(id_post);
		if(this.liste.contains(delete_post))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
