package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.UserMapper;

public class InsertTest {

	public static void main(String[] args) {
		// 定义SqlSession变量
		SqlSession sqlSession = null;
		try {
			// 创建SqlSession实例
			sqlSession = FKSqlSessionFactory.getSqlSession();
			
			// 创建UserMapper实例
			UserMapper um = sqlSession.getMapper(UserMapper.class);
			// 创建User对象并设置属性
			User user = new User();
			user.setName("test");
			user.setSex("男");
			user.setAge(18);
			// 插入数据
			um.saveUser(user);
			// 查看插入数据生成的主键
			System.out.println("插入数据生成的主键id为：" + user.getId());
			
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
