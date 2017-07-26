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

		@Override
		public Article getById(int id) {
			return articleDao.getById(id);
		}

		@Override
		public List<Article> getAll() {
			return articleDao.getAll();
		}

		@Override
		public List<Article> getByPage(int offset, int limit) {
			return articleDao.getByPage(offset, limit);
		}

		@Override
		public void readArticle(int id) {
			articleDao.readArticle(id);
			
		}

		@Override
		public int countAll() {
			return articleDao.countAll();
		}

		@Override
		public List<Article> getNewArticle(int offset, int limit) {
			return articleDao.getNewArticle(offset, limit);
		}

		@Override
		public Article getByTitle(String title) {
			return articleDao.getByTitle(title);
		}

		@Override
		public void updateArticle(int id, String title, String modifytime, String keyword,
				String tags, String content, String abstractcontext) {
			articleDao.updateArticle(id, title, modifytime, keyword, tags, content, abstractcontext);
			
		}

		@Override
		public void saveArticle(String author, String title, String modifytime, String createtime, String keyword,
				String tags, String content, String abstractcontext) {
			articleDao.saveArticle(author, title, modifytime, createtime, keyword, tags, content, abstractcontext);
			
		}

		@Override
		public List<Article> getByClass(int classId, int offset, int limit) {
			
			return articleDao.getByClass(classId, offset, limit);
		}

		@Override
		public List<Article> getByTag(String tags, int offset, int limit) {
			
			return articleDao.getByTag(tags, offset, limit);
		}

		@Override
		public int countByClass(int classId) {
			
			return articleDao.countByClass(classId);
		}

		@Override
		public int countByTag(String tags) {
			
			return articleDao.countByTag(tags);
		}



		
}
