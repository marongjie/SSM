package org.fkit.test;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.fkit.factory.FKSqlSessionFactory;

public class SelectMapTest {

	public static void main(String[] args) {
		// 定义SqlSession变量
		SqlSession sqlSession = null;
		try {
			// 创建SqlSession实例
			sqlSession = FKSqlSessionFactory.getSqlSession();
			// 查询TB_USER表所有数据返回List集合,集合中的每个元素都是一个Map
			List<Map<String,Object>> list 
				= sqlSession.selectList("org.fkit.mapper.UserMapper.selectUser");
			// 遍历List集合，打印每一个Map对象
			list.forEach(row -> System.out.println(row));
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
