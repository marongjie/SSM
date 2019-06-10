package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.UserMapper;
public class UpdateTest {

	public static void main(String[] args)  {
		// 定义SqlSession变量
		SqlSession sqlSession = null;
		try {
			// 创建SqlSession实例
			sqlSession = FKSqlSessionFactory.getSqlSession();
			// 创建UserMapper实例
			UserMapper um = sqlSession.getMapper(UserMapper.class);
			// 查询id=5的User对象
			User user = um.selectUserById(5);
			// 修改查询到的User对象
			user.setName("update");
			user.setSex("女");
			user.setAge(19);
			// 修改User对象
			um.modifyUser(user);
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

}
