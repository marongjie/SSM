package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;
import org.fkit.domain.User;
public interface UserMapper {

	/**
	 * 插入数据
	 * @param user 包含要查询的User信息
	 */
	@Insert("{call insert_user(#{id,mode=OUT,jdbcType=INTEGER},"
			+ "#{name,mode=IN},#{sex,mode=IN},#{age,mode=IN})}")
	@Options(statementType=StatementType.CALLABLE)
	void saveUser(User user);
	
	/**
	 * 查询所有数据
	 * @return List<User> 包含所有User数据的List集合
	 */
	@Select("{call select_user()}")
	@Options(statementType=StatementType.CALLABLE)
	List<User> selectUser();
	
	/**
	 * 根据id查询对应的数据
	 * @param id 用户的id
	 * @return User 包含用户信息的User对象
	 */
	@Select("{call select_user_by_id(#{id,mode=IN})}")
	@Options(statementType=StatementType.CALLABLE)
	User selectUserById(Integer id);
	
	/**
	 * 修改数据
	 * @param user 包含要修改的User信息
	 */
	@Update("{call update_user(#{id,mode=IN},#{name,mode=IN},#{sex,mode=IN},#{age,mode=IN})}")
	@Options(statementType=StatementType.CALLABLE)
	void modifyUser(User user);
	
	/**
	 * 删除数据
	 * @param user 包含要修改的User信息
	 */
	@Delete("{call delete_user_by_id(#{id,mode=IN})}")
	@Options(statementType=StatementType.CALLABLE)
	void removeUser(User user);
	
	
	
}
