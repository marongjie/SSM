package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;

public class UpadeTest {

	public static void main(String[] args)  {
		// 定义SqlSession变量
		SqlSession sqlSession = null;
		try {
			// 创建SqlSession实例
			sqlSession = FKSqlSessionFactory.getSqlSession();
			// 根据id查询User对象
			User user = sqlSession.selectOne("org.fkit.mapper.UserMapper.selectUser",1);
			// 修改User对象的属性值
			user.setName("tom");
			user.setAge(25);
			// 修改User对象
			sqlSession.update("org.fkit.mapper.UserMapper.modifyUser", user);
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
