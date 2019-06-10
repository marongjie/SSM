package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Person;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.PersonMapper;

public class OneToOneTest {

	public static void main(String[] args) {
		// 定义SqlSession变量
		SqlSession sqlSession = null;
		try {
			// 创建SqlSession实例
			sqlSession = FKSqlSessionFactory.getSqlSession();
			// 获得mapper接口的代理对象
			PersonMapper pm = sqlSession.getMapper(PersonMapper.class);
			// 直接调用接口的方法，查询id为1的Peson数据
			Person p = pm.selectPersonById(1);
			// 打印Peson对象
			System.out.println(p);
			// 打印Person对象关联的Card对象
			System.out.println(p.getCard());
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
