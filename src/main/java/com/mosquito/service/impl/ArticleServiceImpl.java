package com.mosquito.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mosquito.dao.ArticleDao;
import com.mosquito.entity.Article;
import com.mosquito.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 注入Service依赖
		@Autowired
		private ArticleDao articleDao;

		
		public Article getById(int id) {
			return articleDao.getById(id);
		}

		
		public List<Article> getAll() {
			return articleDao.getAll();
		}

		
		public List<Article> getByPage(int offset, int limit) {
			return articleDao.getByPage(offset, limit);
		}

		
		public void readArticle(int id) {
			articleDao.readArticle(id);
			
		}

		
		public int countAll() {
			return articleDao.countAll();
		}

		
		public List<Article> getNewArticle(int offset, int limit) {
			return articleDao.getNewArticle(offset, limit);
		}

		
		public Article getByTitle(String title) {
			return articleDao.getByTitle(title);
		}

		
		public void updateArticle(int id, String title, String modifytime, String keyword,
				String tags, String content, String abstractcontext) {
			articleDao.updateArticle(id, title, modifytime, keyword, tags, content, abstractcontext);
			
		}

		
		public void saveArticle(String author, String title, String modifytime, String createtime, String keyword,
				String tags, String content, String abstractcontext) {
			articleDao.saveArticle(author, title, modifytime, createtime, keyword, tags, content, abstractcontext);
			
		}



		
}
