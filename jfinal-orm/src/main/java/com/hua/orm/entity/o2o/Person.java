/**
 * 描述: 
 * Person.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.orm.entity.o2o;

import com.jfinal.plugin.activerecord.Model;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * Person
 */
@SuppressWarnings({"unchecked"})
public final class Person extends Model<Person>
{
	
	private static final long serialVersionUID = 1L;
	
	public static final Person dao = new Person();
	
	/**
	 * 
	 * @description 
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	public Person get(final String id)
	{
		return dao.findById(id);
	}
}
