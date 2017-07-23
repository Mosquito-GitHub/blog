package com.mosquito.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mosquito.entity.User;
import com.mosquito.service.CommentsService;
import com.mosquito.service.UserService;

@Controller
@RequestMapping("/comments") // url:/模块/资源/{id}/细分 /seckill/list
public class CommentsController {

	@Autowired
	private UserService userservice;

	@Autowired
	private CommentsService commentsservice;

	@RequestMapping("/submitComments")
	public @ResponseBody String submitComments(int commentid,String username,String email,String url,String content,String category){
		User user = userservice.getUserByName(username);
		if(user==null){
			userservice.addUser(username, email, "", "2", "img/head1.png", url);
			user = userservice.getUserByName(username);
		}
		DateFormat df = DateFormat.getDateTimeInstance();
		String commtime = df.format(new Date());
		commentsservice.addComments(commentid, user.getId(), commtime, content, category);
		return "success";
	}
}
