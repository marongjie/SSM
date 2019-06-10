package org.fkit.test;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.UserMapper;


public class ProcedureTest {

	public static void main(String[] args)  {
		// 定义SqlSession变量
		SqlSession sqlSession = null;
		try {
			// 创建SqlSession实例
			sqlSession = FKSqlSessionFactory.getSqlSession();
			ProcedureTest t = new ProcedureTest();
			// 测试插入数据
//			t.testSaveUser(sqlSession);
			// 测试查询所有数据
//			t.testSelectUser(sqlSession);
			// 测试根据id查询对应的数据
//			t.testSelectUserById(sqlSession);
			// 测试修改数据
//			t.testModifyUser(sqlSession);
			// 测试删除数据
			t.testRemoveUser(sqlSession);
			// 提交事务
			sqlSession.commit();
		} catch (Exception e) {
			// 回滚事务
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			// 关闭SqlSession
			if(sqlSession != null) 
				sqlSession.close();
		}
	}
	
	// 测试插入数据
	public void testSaveUser(SqlSession sqlSession){
		// 获得UserMapper接口的代理对象
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		User user = new User("test","男",23);
//		User user = new User("jack","男",20);
//		User user = new User("rose","女",18);
//		User user = new User("tom","男",21);
//		User user = new User("mary","女",19);
//		User user = new User("alice","女",18);
//		User user = new User("scott","男",25);
		// 调用保存User的方法
		um.saveUser(user);
		System.out.println("插入成功，返回的id = " + user.getId());
	}
	
	// 测试查询所有数据
	public void testSelectUser(SqlSession sqlSession){
		// 获得UserMapper接口的代理对象
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		// 调用查询所有User数据的方法
		List<User> users = um.selectUser();
		// 遍历打印每一个User对象
		users.forEach(user -> System.out.println(user));
	}
	
	// 测试根据id查询对应的数据
	public void testSelectUserById(SqlSession sqlSession){
		// 获得UserMapper接口的代理对象
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		// 调用根据id查询User数据的方法
		User user = um.selectUserById(1);
		System.out.println(user);
	}
	
	// 测试修改数据
	public void testModifyUser(SqlSession sqlSession){
		// 获得UserMapper接口的代理对象
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		// 查询出id为1的User对象
		User user = um.selectUserById(1);
		// 修改对象的属性
		user.setName("fkit");
		user.setSex("男");
		user.setAge(19);
		// 调用修改数据的方法
		um.modifyUser(user);
	}
	
	// 测试删除数据
	public void testRemoveUser(SqlSession sqlSession){
		// 获得UserMapper接口的代理对象
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		// 查询出id为1的User对象
		User user = um.selectUserById(1);
		// 调用删除数据的方法
		um.removeUser(user);
	}
	
	
	
	

}
