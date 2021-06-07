package com.learning.learning.mapper;

import java.util.List;

import com.learning.learning.entity.Note;
import com.learning.learning.util.so.SoMap;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

/**
 * Mapper: note -- 心得表，有外键约束，需在用户表之后创建
 * @author jbk-xiao 
 */

@Mapper
@Repository
public interface NoteMapper {

	/**
	 * 增  
	 * @param content 心得内容
	 * @param userId 用户ID
	 * @return 受影响行数 
	 */
	int add(String content, String userId);

	/**
	 * 删  
	 * @param noteId 要删除的数据id
	 * @return 受影响行数 
	 */
	int delete(String noteId);

	/** 
	 * 改  
	 * @param note 实体对象
	 * @return 受影响行数 
	 */
	int update(Note note);

	/** 
	 * 查 - 根据id  
	 * @param noteId 要查询的数据id
	 * @return Note对象
	 */
	Note getNoteById(String noteId);

//	/**
//	 * 查集合 - 根据条件（参数为空时代表忽略指定条件）
//	 * @param so 参数集合
//	 * @return Note列表
//	 */
//	List<Note> getList(SoMap so);

	/**
	 * 查集合 - 查询所有Note
	 * @return Note列表
	 */
	List<Note> getAllList();

	/**
	 * 查用户 - 根据用户ID查询某用户发布过的所有心得的列表
	 * @param userId 用户Id
	 * @return Note列表
	 */
	List<Note> getNoteListByUserId(String userId);

	int updateStatus(String noteId, int status);
}
