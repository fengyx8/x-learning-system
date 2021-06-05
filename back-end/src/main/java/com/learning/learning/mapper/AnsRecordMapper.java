package com.learning.learning.mapper;

import java.util.List;

import com.learning.learning.entity.AnsRecord;
import com.learning.learning.util.so.SoMap;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

/**
 * Mapper: ansRecord -- 作答记录表，使用到外键，需要在user表和question表之后创建
 * @author jbk-xiao 
 */

@Mapper
@Repository
public interface AnsRecordMapper {

	/**
	 * 增  
	 * @param ansRecord 实体对象
	 * @return 受影响行数 
	 */
	int add(AnsRecord ansRecord);

	/**
	 * 删  
	 * @param ansId 要删除的数据id
	 * @return 受影响行数 
	 */
	int delete(String ansId);

	/** 
	 * 改  
	 * @param ansRecord 实体对象
	 * @return 受影响行数 
	 */
	int update(AnsRecord ansRecord);

	/** 
	 * 查 - 根据id  
	 * @param ansId 要查询的数据id
	 * @return AnsRecord对象
	 */
	AnsRecord getById(String ansId);

	/**
	 * 查集合 - 根据条件（参数为空时代表忽略指定条件）
	 * @param so 参数集合 
	 * @return 数据列表 
	 */
	List<AnsRecord> getList(SoMap so);

	/**
	 * 查 - 根据queId
	 * @param queId 要查询的作答记录对应的问题id
	 * @return AnsRecord对象
	 */
	AnsRecord getByQueId(String queId);
}
