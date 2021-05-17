package com.learning.learning.mapper;

import java.util.List;

import com.learning.learning.entity.User;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

/**
 * Mapper: user -- 一般用户表，用户从登录表中激活后方可加入此表
 * @author jbk-xiao
 */

@Mapper
@Repository
public interface UserMapper {

	/**
	 * 增  
	 * @param user 实体对象
	 * @return 受影响行数 
	 */
	int add(User user);

	/**
	 * 删  
	 * @param userId 要删除的数据id
	 * @return 受影响行数 
	 */
	int delete(String userId);	 

	/** 
	 * 改  
	 * @param user 实体对象
	 * @return 受影响行数 
	 */
	int update(User user);

	/** 
	 * 查 - 根据id  
	 * @param userId 要查询的数据id
	 * @return 实体对象 
	 */
	User getUserInfoById(String userId);

	/**
	 * 查集合 - 根据条件（参数为空时代表忽略指定条件）
	 * @param so 参数集合 
	 * @return 数据列表 
	 */
//	List<User> getList(SoMap so);


}
