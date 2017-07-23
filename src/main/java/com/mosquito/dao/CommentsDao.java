package com.mosquito.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mosquito.entity.Comments;

public interface CommentsDao {

	/**
	 * 获取所有的评论
	 * @return
	 */
	public List<Comments> getAllComments();
	
	/**
	 * 根据被评论对象的id获取评论
	 * @param id
	 * @return
	 */
	public List<Comments> getCommentsById(@Param("commentid")int commentid);
	
	/**
	 * 添加评论
	 * @param comm
	 */
	public void addComments(@Param("commentid")int commentid,@Param("userid")int userid,@Param("commtime")String commtime,@Param("content")String content,@Param("category")String category);
	
	/**
	 * 删除评论
	 * @param id
	 */
	public void deleteComments(@Param("id")int id);
	
}
