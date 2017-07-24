package com.mosquito.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mosquito.entity.Article;

public interface ArticleService {

	/**
	 * 获取一篇文章
	 * @param id
	 * @return
	 */
	Article getById(int id);
	/**
	 * 获取一篇文章
	 * @param id
	 * @return
	 */
	Article getByTitle(String title);
	/**
	 * 获取所有文章
	 * @return
	 */
	List<Article> getAll();
	/**
	 * 根据限制数量获取文章
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Article> getByPage(int offset,int limit);
	
	/**
	 * 获取最新文章
	 * @return
	 */
	
	/**
	 * 根据分类获取文章
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Article> getByClass(int classId,int offset,int limit);
	
	/**
	 * 根据标签获取文章
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Article> getByTag(String tags,int offset,int limit);
	
	
	List<Article> getNewArticle(int offset,int limit);
	/**
	 * 阅读次数
	 * @param id
	 */
	
	/**
	 * 插入文章
	 * @param author
	 * @param title
	 * @param modifytime
	 * @param createtime
	 * @param keywords
	 * @param tags
	 * @param content
	 * @param abstractcontext
	 */
	void saveArticle(String author,String title,String modifytime,String createtime,String keyword,String tags,String content,String abstractcontext);
	
	/**
	 * 更新文章
	 * @param id
	 * @param title
	 * @param modifytime
	 * @param createtime
	 * @param keyword
	 * @param tags
	 * @param content
	 * @param abstractcontext
	 */
	void updateArticle(int id,String title,String modifytime,String keyword,String tags,String content,String abstractcontext);
	
	int countAll();
	
	/**
	 * 根据分类获取文章总数
	 * 
	 * @return
	 */
	int countByClass(int classId);

	/**
	 * 根据标签获取文章总数
	 * 
	 * @return
	 */
	int countByTag(String tags);

	void readArticle(int id);
	
}
