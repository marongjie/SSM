package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.UserMapper;

public class ATwoLevelCacheTest {

	public static void main(String[] args)  {
		// 使用工厂类获得SqlSession对象
		SqlSession sqlSession1 = FKSqlSessionFactory.getSqlSession();
		// 获得UserMapping对象
		UserMapper um = sqlSession1.getMapper(UserMapper.class);
		// 查询id为1的User对象，会执行select语句
		User user = um.selectUserById(1);
		System.out.println(user);
		// 关闭一级缓存
		sqlSession1.close();
		// 重新获取一级缓存
		SqlSession sqlSession2 = FKSqlSessionFactory.getSqlSession();
		// 再次获得UserMapping对象
		um = sqlSession2.getMapper(UserMapper.class);
		// 再次查询id为1的User对象，虽然现在使用的是一个新的SqlSession对象,但是二级缓存中缓存了数据，所以不会执行再次select语句
		User user2 = um.selectUserById(1);
		System.out.println(user2);
		// 关闭SqlSession对象
		sqlSession2.close();
	}

}
