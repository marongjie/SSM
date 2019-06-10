package org.fkit.test;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fkit.domain.User;

public class MyBatisTest {

	public static void main(String[] args) {
		// 创建Session实例
		SqlSession sqlSession = null;
		try (// 读取mybatis-config.xml文件
				InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			){
			// 初始化mybatis，创建SqlSessionFactory类的实例
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(is);
			sqlSession = sqlSessionFactory.openSession();
			// 创建User对象
			User user = new User("admin", "男", 26);
			// 插入数据
			sqlSession.insert("org.fkit.mapper.UserMapper.save", user);
			// 提交事务
			sqlSession.commit();
		} catch (Exception e) {
			// 回滚事务
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			try {
				// 关闭sqlSession
				if(sqlSession != null) sqlSession.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
