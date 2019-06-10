package org.fkit.mapper;


import org.fkit.domain.User;

public interface UserMapper {
	
	// 根据id查询User
	User selectUserById(Integer id);
	
	// 根据id删除User
	void deleteUserById(Integer id);

}
