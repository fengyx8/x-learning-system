package com.learning.learning.mapper;

import java.util.List;

import com.learning.learning.entity.Question;
import com.learning.learning.util.so.SoMap;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

/**
 * Mapper: question -- 题目表
 * @author jbk-xiao 
 */

@Mapper
@Repository
public interface QuestionMapper {

	/**
	 * 增  
	 * @param question 实体对象
	 * @return 受影响行数 
	 */
	int add(Question question);

	/**
	 * 删  
	 * @param queId 要删除的数据id
	 * @return 受影响行数 
	 */
	int delete(String queId);

	/** 
	 * 改  
	 * @param question 实体对象
	 * @return 受影响行数 
	 */
	int update(Question question);

	/** 
	 * 查 - 根据id  
	 * @param queId 要查询的数据id
	 * @return 实体对象 
	 */
	Question getById(String queId);

	/**
	 * 查集合 - 根据条件（参数为空时代表忽略指定条件）
	 * @param so 参数集合 
	 * @return 数据列表 
	 */
	List<Question> getList(SoMap so);


}
