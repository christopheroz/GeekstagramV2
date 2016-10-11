package ort.geekstagram_student.model;


import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Jessica MANGINI
 * @class PostStagram
 */
@Entity
@Table(name = "post_stagram")
public class PostStagram
{
	/**
	 * The ID of the post, auto generated
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_post;
	/**
	 * The ID of the user
	 */
	@NotNull
	private long id_user;
	/**
	 * The date (SimpleDateFormat) when the post has been published
	 */
	@NotNull
	private SimpleDateFormat date_post;
	/**
	 * The content of the post
	 */
	@NotNull
	private String content_post;
	
	/**
	 * Default constructor
	 */
	public PostStagram()
	{
		super();
	}
	
	/**
	 * Standard constructor
	 * 
	 * @constructor
	 * @param content_post
	 *            Content of the post
	 */
	public PostStagram(String content_post)
	{
		super();
		this.date_post = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.content_post = content_post;
	}

	/**
	 * Complete constructor
	 * 
	 * @constructor
	 * @param id_user
	 *            ID of the user
	 * @param content_post
	 *            Content of the post
	 */
	public PostStagram(long id_user, String content_post)
	{
		super();
		this.id_user = id_user;
		this.date_post = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.content_post = content_post;
	}
	

	/**
	 * Date getter
	 * 
	 * @returns The date of the post
	 */
	public SimpleDateFormat getDate_post() {
		return date_post;
	}
	/**
	 * Date setter
	 * 
	 * @param content
	 *            The date of the post
	 */
	public void setDate_post(SimpleDateFormat date_post) {
		this.date_post = date_post;
	}
	
	/**
	 * Post getter
	 * 
	 * @returns The content of the post
	 */
	public String getContent_post() {
		return content_post;
	}
	/**
	 * Post setter
	 * 
	 * @param content
	 *            The content of the post
	 */
	public void setContent_post(String content_post) {
		this.content_post = content_post;
	}
	

	/**
	 * ID post getter
	 * 
	 * @returns The ID of the post
	 */
	public int getId_post() {
		return id_post;
	}

	/**
	 * ID post setter
	 * 
	 * @param id_post
	 *            The ID of the post
	 */
	public void setId_post(int id_post) {
		this.id_post = id_post;
	}

	/**
	 * ID user getter
	 * 
	 * @returns The ID of the user
	 */
	public long getId_user() {
		return id_user;
	}


	/**
	 * ID user setter
	 * 
	 * @param id_user
	 *            The ID user of the post
	 */
	public void setId_user(long id_user) {
		this.id_user = id_user;
	}
}
