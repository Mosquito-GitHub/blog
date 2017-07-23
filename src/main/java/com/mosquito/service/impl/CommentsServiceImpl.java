package com.mosquito.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mosquito.dao.CommentsDao;
import com.mosquito.entity.Comments;
import com.mosquito.service.CommentsService;
@Service
public class CommentsServiceImpl implements CommentsService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommentsDao commdao;
	
	
	public List<Comments> getAllComments() {
		return commdao.getAllComments();
	}

	
	public List<Comments> getCommentsById(int commentid) {
		return commdao.getCommentsById(commentid);
	}

	
	public void addComments(int commentid, int userid, String commtime, String content, String category) {
		commdao.addComments(commentid, userid, commtime, content, category);
		
	}

	
	public void deleteComments(int id) {
		commdao.deleteComments(id);
		
	}

}
