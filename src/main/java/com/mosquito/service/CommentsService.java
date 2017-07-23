package com.mosquito.service;

import java.util.List;

import com.mosquito.entity.Comments;

public interface CommentsService {

	
	/**
	 * 获取所有的评论
	 * @return
	 */
	List<Comments> getAllComments();
	/**
	 * 根据被评论对象的id获取评论
	 * @param id
	 * @return
	 */
	List<Comments> getCommentsById(int commentid);
	
	/**
	 * 添加评论
	 * @param comm
	 */
	void addComments(int commentid,int userid,String commtime,String content,String category);
	
	/**
	 * 删除评论
	 * @param id
	 */
	void deleteComments(int id);
}
