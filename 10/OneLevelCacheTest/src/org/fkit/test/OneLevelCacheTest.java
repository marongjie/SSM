package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.UserMapper;

public class OneLevelCacheTest {

	public static void main(String[] args)  {

		// 定义SqlSession变量
		SqlSession sqlSession = null;
		try {
			// 创建SqlSession实例
			sqlSession = FKSqlSessionFactory.getSqlSession();
			OneLevelCacheTest t = new OneLevelCacheTest();

//			t.testCache1(sqlSession);
//			t.testCache2(sqlSession);
//			t.testCache3(sqlSession);
			t.testCache4();
			
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
	
	 /*
	  * 一级缓存: 也就Session级的缓存(默认开启)
	  */
	public void testCache1 (SqlSession sqlSession){
		// 获得UserMapping对象
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		// 查询id为1的User对象，会执行select语句
		User user = um.selectUserById(1);
		System.out.println(user);
		// 再次查询id为1的User对象,因为是同一个SqlSession,所以会从之前的一级缓存中查找数据
		User user2 = um.selectUserById(1);
		System.out.println(user2);
	}
	
	// 测试一级缓存执行DML语句并提交
	public void testCache2 (SqlSession sqlSession){
		// 获得UserMapping对象
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		// 查询id为1的User对象，会执行select语句
		User user = um.selectUserById(1);
		System.out.println(user);
		// 执行delete操作
		um.deleteUserById(5);
		// commit提交
		sqlSession.commit();
		// 再次查询id为1的User对象,因为DML操作会清空SqlSession缓存,所以会再次执行select语句
		User user2 = um.selectUserById(1);
		System.out.println(user2);
	}
	
	// 测试一级缓存clearCache
	public void testCache3 (SqlSession sqlSession){
		// 获得UserMapping对象
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		// 查询id为1的User对象，会执行select语句
		User user = um.selectUserById(1);
		System.out.println(user);
		// 清空一级缓存
		sqlSession.clearCache();
		// 再次获得UserMapping对象
		um = sqlSession.getMapper(UserMapper.class);
		// 再次访问，因为SqlSession一级缓存已经清空,所以会再次执行select语句
		User user2 = um.selectUserById(1);
		System.out.println(user2);
	}
	
	// 测试一级缓存close
	public void testCache4 (){
		// 使用工厂类获得SqlSession对象
		SqlSession sqlSession = FKSqlSessionFactory.getSqlSession();
		// 获得UserMapping对象
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		// 查询id为1的User对象，会执行select语句
		User user = um.selectUserById(1);
		System.out.println(user);
		// 关闭一级缓存
		sqlSession.close();
		// 再次访问,重新获取一级缓存，然后才能查找数据，否则会抛出异常
		SqlSession sqlSession2 = FKSqlSessionFactory.getSqlSession();
		// 再次获得UserMapping对象
		um = sqlSession2.getMapper(UserMapper.class);
		// 再次访问，因为现在使用的是一个新的SqlSession对象,所以会再次执行select语句
		User user2 = um.selectUserById(1);
		System.out.println(user2);
		// 关闭SqlSession对象
		sqlSession2.close();
	}

}
