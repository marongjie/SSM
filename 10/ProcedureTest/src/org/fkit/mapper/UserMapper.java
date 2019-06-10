package org.fkit.mapper;

import java.util.List;
import org.fkit.domain.User;

public interface UserMapper {

	/**
	 * 插入数据
	 * @param user 包含要查询的User信息
	 */
	void saveUser(User user);
	
	/**
	 * 查询所有数据
	 * @return List<User> 包含所有User数据的List集合
	 */
	List<User> selectUser();
	
	/**
	 * 根据id查询对应的数据
	 * @param id 用户的id
	 * @return User 包含用户信息的User对象
	 */
	User selectUserById(Integer id);
	
	/**
	 * 修改数据
	 * @param user 包含要修改的User信息
	 */
	void modifyUser(User user);
	
	/**
	 * 删除数据
	 * @param user 包含要修改的User信息
	 */
	void removeUser(User user);
	
	
	
}
