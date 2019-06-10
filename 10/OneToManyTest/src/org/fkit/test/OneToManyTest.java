package org.fkit.test;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Clazz;
import org.fkit.domain.Student;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.ClazzMapper;
import org.fkit.mapper.StudentMapper;

public class OneToManyTest {

	public static void main(String[] args) {
		
		// 定义SqlSession变量
		SqlSession sqlSession = null;
		try {
			// 创建SqlSession实例
			sqlSession = FKSqlSessionFactory.getSqlSession();
			OneToManyTest t = new OneToManyTest();
			t.testSelectClazzById(sqlSession);
//			t.testSelectStudentById(sqlSession);
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
	
	// 测试一对多，查询班级Clazz（一）的时候级联查询学生Student（多）  
	public void testSelectClazzById(SqlSession sqlSession){
		// 获得ClazzMapper接口的代理对象
		ClazzMapper cm = sqlSession.getMapper(ClazzMapper.class);
		// 调用selectClazzById方法
		Clazz clazz = cm.selectClazzById(1);
		// 查看查询到的clazz对象信息
		System.out.println(clazz.getId() + " "+ clazz.getCode() + " "+clazz.getName());
		// 查看clazz对象关联的学生信息
		List<Student> students = clazz.getStudents();
		students.forEach(stu -> System.out.println(stu));
	}
	
	// 测试多对一，查询学生Student（多）的时候级联查询 班级Clazz（一）
	public void testSelectStudentById(SqlSession sqlSession){
		// 获得StudentMapper接口的代理对象
		StudentMapper sm = sqlSession.getMapper(StudentMapper.class);
		// 调用selectStudentById方法
		Student stu = sm.selectStudentById(1);
		// 查看查询到的Student对象信息
		System.out.println(stu);
		// 查看Student对象关联的班级信息
		System.out.println(stu.getClazz());
	}

}
