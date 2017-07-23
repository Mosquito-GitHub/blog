package com.mosquito.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mosquito.entity.Article;

public interface ArticleDao {

	/**
	 * 获取一篇文章
	 * @param id
	 * @return
	 */
	Article getById(@Param("articleId") int articleId);
	/**
	 * 获取一篇文章
	 * @param id
	 * @return
	 */
	Article getByTitle(@Param("title") String title);
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
	List<Article> getByPage(@Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 获取最新文章列表
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Article> getNewArticle(@Param("offset") int offset, @Param("limit") int limit);
	/**
	 * 阅读次数
	 * @param id
	 */
	/**
	 * 获取文章总数
	 * @return
	 */
	int countAll();
	void readArticle(@Param("id") int id);
	
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
	void saveArticle(@Param("author")String author,@Param("title")String title,@Param("modifytime")String modifytime,@Param("createtime")String createtime,@Param("keyword")String keyword,@Param("tags")String tags,@Param("context")String context,@Param("abstractcontext")String abstractcontext);
	
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
	void updateArticle(@Param("id")int id,@Param("title")String title,@Param("modifytime")String modifytime,@Param("keyword")String keyword,@Param("tags")String tags,@Param("context")String context,@Param("abstractcontext")String abstractcontext);
}
