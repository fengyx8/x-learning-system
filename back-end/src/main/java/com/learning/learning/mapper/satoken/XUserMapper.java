package com.learning.learning.mapper.satoken;

import com.learning.learning.entity.satoken.XUser;
import com.learning.learning.util.so.SoMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Mapper: 系统管理员表
 * @author jbk-xiao
 */
@Mapper
public interface XUserMapper {


	/**
	 * 增 #{name}, #{password}, #{roleId} 
	 * @param obj
	 * @return
	 */
	int add(XUser obj);

	/**
	 * 删 
	 * @param id
	 * @return
	 */
	int delete(String id);

	/**
	 * 改 
	 * @param obj
	 * @return
	 */
	int update(XUser obj);

	/**
	 * 查 
	 * @param id 用户ID
	 * @return
	 */
	XUser getById(String id);

	/**
	 * 查  
	 * @param so
	 * @return
	 */
	List<XUser> getList(SoMap so);

	/**
	 * 查询，根据name 
	 * @param name
	 * @return
	 */
	XUser getByName(String name);
	
	/**
	 * 查询，根据 mail
	 * @param mail
	 * @return
	 */
	XUser getByMail(String mail);



}
