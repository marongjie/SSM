package org.fkit.test;


import org.apache.ibatis.session.SqlSession;
import org.fkit.factory.FKSqlSessionFactory;

public class DeleteTest {

	public static void main(String[] args)  {
		// 定义SqlSession变量
		SqlSession sqlSession = null;
		try {
			// 创建SqlSession实例
			sqlSession = FKSqlSessionFactory.getSqlSession();
			// 删除id为1的User对象
			sqlSession.delete("org.fkit.mapper.UserMapper.removeUser", 1);
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
