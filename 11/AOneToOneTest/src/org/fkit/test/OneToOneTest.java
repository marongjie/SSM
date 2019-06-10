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
			// 获取PersonMapper实例
			PersonMapper pm = sqlSession.getMapper(PersonMapper.class);
			// 根据id查询Person对象，同时需要获得关联的Card对象
			Person p = pm.selectPersonById(1);
			// 查看查询到的Person对象
			System.out.println(p);
			// 查看查询到的关联的Card对象
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
