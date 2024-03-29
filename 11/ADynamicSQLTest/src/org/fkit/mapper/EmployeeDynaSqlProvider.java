package org.fkit.mapper;


import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.fkit.domain.Employee;

public class EmployeeDynaSqlProvider {
	
	public String selectWhitParam(Map<String, Object> param){
		return new SQL(){
			{
				SELECT("*");
				FROM("tb_employee");
				if(param.get("id") != null){
					WHERE(" id = #{id} ");
				}
				if(param.get("loginname") != null){
					WHERE(" loginname = #{loginname} ");
				}
				if(param.get("password") != null){
					WHERE("password = #{password}");
				}
				if(param.get("name")!= null){
					WHERE("name = #{name}");
				}
				if(param.get("sex")!= null){
					WHERE("sex = #{sex}");
				}
				if(param.get("age")!= null){
					WHERE("age = #{age}");
				}
				if(param.get("phone")!= null){
					WHERE("phone = #{phone}");
				}
				if(param.get("sal")!= null){
					WHERE("sal = #{sal}");
				}
				if(param.get("state")!= null){
					WHERE("state = #{state}");
				}
				
			}
		}.toString();
	}	
	
	public String insertEmployee(Employee employee){
		
		return new SQL(){
			{
				INSERT_INTO("tb_employee");
				if(employee.getLoginname() != null){
					VALUES("loginname", "#{loginname}");
				}
				if(employee.getPassword() != null){
					VALUES("password", "#{password}");
				}
				if(employee.getName()!= null){
					VALUES("name", "#{name}");
				}
				if(employee.getSex()!= null){
					VALUES("sex", "#{sex}");
				}
				if(employee.getAge()!= null){
					VALUES("age", "#{age}");
				}
				if(employee.getPhone()!= null){
					VALUES("phone", "#{phone}");
				}
				if(employee.getSal()!= null){
					VALUES("sal", "#{sal}");
				}
				if(employee.getState()!= null){
					VALUES("state", "#{state}");
				}
			}
		}.toString();
	}
	
	public String updateEmployee(Employee employee){
		
		return new SQL(){
			{
				UPDATE("tb_employee");
				if(employee.getLoginname() != null){
					SET("loginname = #{loginname}");
				}
				if(employee.getPassword() != null){
					SET("password = #{password}");
				}
				if(employee.getName()!= null){
					SET("name = #{name}");
				}
				if(employee.getSex()!= null){
					SET("sex = #{sex}");
				}
				if(employee.getAge()!= null){
					SET("age = #{age}");
				}
				if(employee.getPhone()!= null){
					SET("phone = #{phone}");
				}
				if(employee.getSal()!= null){
					SET("sal = #{sal}");
				}
				if(employee.getState()!= null){
					SET("state = #{state}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
	public String deleteEmployee(Map<String, Object> param){
		
		return new SQL(){
			{
				DELETE_FROM("tb_employee");
				if(param.get("id") != null){
					WHERE(" id = #{id} ");
				}
				if(param.get("loginname") != null){
					WHERE(" loginname = #{loginname} ");
				}
				if(param.get("password") != null){
					WHERE("password = #{password}");
				}
				if(param.get("name")!= null){
					WHERE("name = #{name}");
				}
				if(param.get("sex")!= null){
					WHERE("sex = #{sex}");
				}
				if(param.get("age")!= null){
					WHERE("age = #{age}");
				}
				if(param.get("phone")!= null){
					WHERE("phone = #{phone}");
				}
				if(param.get("sal")!= null){
					WHERE("sal = #{sal}");
				}
				if(param.get("state")!= null){
					WHERE("state = #{state}");
				}
			}
		}.toString();
	}

	
	
}
