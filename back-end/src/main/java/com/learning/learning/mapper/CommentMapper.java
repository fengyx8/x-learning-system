package com.learning.learning.mapper;

import java.util.List;

import com.learning.learning.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

/**
 * Mapper: comment -- 评论表，有外键约束，需在用户表、心得表之后创建
 * @author jbk-xiao 
 */

@Mapper
@Repository
public interface CommentMapper {

	/**
	 * 增  
	 * @param content 评论内容
	 * @param userId 用户ID
	 * @param noteId 心得ID
	 * @return 受影响行数
	 */
	int add(String content, String userId, String noteId);

	/**
	 * 删  
	 * @param commentId 要删除的数据id
	 * @return 受影响行数 
	 */
	int delete(String commentId);

	/** 
	 * 改  
	 * @param comment 实体对象
	 * @return 受影响行数 
	 */
	int update(Comment comment);

	/** 
	 * 查 - 根据id  
	 * @param commentId 要查询的数据id
	 * @return Comment对象
	 */
	Comment getCommentById(String commentId);

//	/**
//	 * 查集合 - 根据条件（参数为空时代表忽略指定条件）
//	 * @param so 参数集合
//	 * @return Comment列表
//	 */
//	List<Comment> getList(SoMap so);

	/**
	 * 查用户 - 根据用户ID查询comment列表
	 * @param userId 用户ID
	 * @return Comment列表
	 */
	List<Comment> getCommentListByUserId(String userId);

    int updateStatus(String commentId, int status);

    List<Comment> getAllList();
}
