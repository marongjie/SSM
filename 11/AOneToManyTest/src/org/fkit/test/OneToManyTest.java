package org.fkit.test;

import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Clazz;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.ClazzMapper;
public class OneToManyTest {

	public static void main(String[] args) {
		// 定义SqlSession变量
		SqlSession sqlSession = null;
		try {
			// 创建SqlSession实例
			sqlSession = FKSqlSessionFactory.getSqlSession();
			// 获取ClazzMapper实例
			ClazzMapper cm = sqlSession.getMapper(ClazzMapper.class);
			// 根据id查询Clazz对象
			Clazz clazz = cm.selectById(1);
			// 查看查询到的Clazz对象
			System.out.println(clazz.getId() + " "+ clazz.getCode() + " "+clazz.getName());
			// 查看关联的学生集合，因为配置使用的是LAZY懒加载，所以当使用时才执行SQL语句
			clazz.getStudents().forEach(student->System.out.println(student));
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
