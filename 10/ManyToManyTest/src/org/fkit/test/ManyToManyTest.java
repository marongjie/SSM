package org.fkit.test;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.fkit.domain.Article;
import org.fkit.domain.Order;
import org.fkit.domain.User;
import org.fkit.factory.FKSqlSessionFactory;
import org.fkit.mapper.OrderMapper;
import org.fkit.mapper.UserMapper;


public class ManyToManyTest {

	public static void main(String[] args)  {
		// 定义SqlSession变量
		SqlSession sqlSession = null;
		try {
			// 创建SqlSession实例
			sqlSession = FKSqlSessionFactory.getSqlSession();
			ManyToManyTest t = new ManyToManyTest();
			// 根据用户id查询用户，测试一对多
			t.testSelectUserById(sqlSession);
			// 根据订单id查询订单，测试多对多
//			t.testSelectOrderById(sqlSession);
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
	
	// 测试一对多，查询班级User（一）的时候级联查询订单Order（多）  
	public void testSelectUserById(SqlSession sqlSession){
		// 获得UserMapper接口的代理对象
		UserMapper um = sqlSession.getMapper(UserMapper.class);
		// 调用selectUserById方法
		User user = um.selectUserById(1);
		// 查看查询到的user对象信息
		System.out.println(user.getId() + " " + user.getUsername());
		// 查看user对象关联的订单信息
		List<Order> orders = user.getOrders();
		orders.forEach(order -> System.out.println(order));
	}
	
	// 测试多对多，查询订单Order（多）的时候级联查询订单的商品Article（多）  
	public void testSelectOrderById(SqlSession sqlSession){
		// 获得OrderMapper接口的代理对象
		OrderMapper om = sqlSession.getMapper(OrderMapper.class);
		// 调用selectOrderById方法
		Order order = om.selectOrderById(2);
		// 查看查询到的order对象信息
		System.out.println(order.getId() + " " + order.getCode() + " " + order.getTotal());
		// 查看order对象关联的用户信息
		User user = order.getUser();
		System.out.println(user);
		// 查看order对象关联的商品信息
		List<Article> articles = order.getArticles();
		articles.forEach(article -> System.out.println(article));
	}

}
