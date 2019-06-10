package org.fkit.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */

// 域对象，实现序列化接口
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private String username;
	
	// 对应上传的file，类型为MultipartFile，上传文件会自动绑定到image属性当中
	private MultipartFile image;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	

	
	
}
