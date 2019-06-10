package org.fkit.domain;

import java.io.Serializable;
import java.util.List;

/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Dept> depts;

	public List<Dept> getDepts() {
		return depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}

	
	
	
}
