package org.fkit.test;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.UserMapper;
public class SelectAllTest {

	public static void main(String[] args)  {
		// 定义SqlSession变量
		SqlSession sqlSession = null;
		try {
			// 创建SqlSession实例
			sqlSession = FKSqlSessionFactory.getSqlSession();
			// 创建UserMapper实例
			UserMapper um = sqlSession.getMapper(UserMapper.class);
			// 根据id查询User对象
			List<User> list = um.selectAllUser();
			// 查看查询到的User对象
			list.forEach(user->System.out.println(user));
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
