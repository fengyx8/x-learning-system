package com.learning.learning.mapper.satoken;

import com.learning.learning.entity.satoken.XRole;
import com.learning.learning.util.so.SoMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Mapper: 系统角色表
 * @author jbk-xiao
 */
@Mapper
public interface XRoleMapper {


	/**
	 * 增 
	 * @param obj
	 * @return
	 */
	int add(XRole obj);

	/**
	 * 删
	 * @param id
	 * @return
	 */
	int delete(long id);

	/**
	 * 改 
	 * @param obj
	 * @return
	 */
	int update(XRole obj);

	/**
	 *  查 
	 * @param id
	 * @return
	 */
	XRole getById(long id);

	/**
	 * 查 
	 * @param soMap
	 * @return
	 */
	List<XRole> getList(SoMap soMap);


	/**
	 * 查，根据角色名字
	 * @param name
	 * @return
	 */
	XRole getByRoleName(String name);

}
