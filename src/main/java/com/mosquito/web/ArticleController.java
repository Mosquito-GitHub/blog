package com.mosquito.web;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mosquito.entity.Article;
import com.mosquito.entity.Comments;
import com.mosquito.service.ArticleService;
import com.mosquito.service.CommentsService;
import com.mosquito.utils.Tools;

@Controller
@RequestMapping("/article") // url:/模块/资源/{id}/细分 /seckill/list
public class ArticleController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired//它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法
	private ArticleService articleService;
	
	@Autowired
	private CommentsService commentsService;
	
	DateFormat df = DateFormat.getDateTimeInstance();
	
	/**
	 * 获取首页博文列表
	 * @param request
	 * @param response
	 * @param page
	 * @param pagecount
	 * @return
	 */
	@RequestMapping("/getArticleList")
	public @ResponseBody Map<String,Object> getByPage(HttpServletRequest request,HttpServletResponse response,int page,int pagecount,String searchtype,String param){
		Map<String,Object> map = new HashMap<String,Object>();
		int offset = (page-1)*pagecount;
		int limit = page*pagecount;
		List<Article> list=null;
		char tp = searchtype.charAt(0);
		switch(tp){
			case 'c':
				int classID = Integer.parseInt(param);
				list = articleService.getByClass(classID, offset, limit);
				break;
			case 't':
				list = articleService.getByTag(param, offset, limit);
				break;
			default:
				list = articleService.getByPage(offset, limit);
				
		}
		
		map.put("list", list);
		return map;
	}
	
	/**
	 * 获取最新博文列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getNewArticleList")
	public @ResponseBody Map<String,Object> getNewArticleList(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Article> list = articleService.getNewArticle(0, 5);
		map.put("list", list);
		return map;
	}
	
	/**
	 * 获取博文内容及评论
	 * @param articleid
	 * @return
	 */
	@RequestMapping("/getArticle")
	public @ResponseBody Map<String,Object> getCommentsByArticle(HttpServletRequest request,HttpServletResponse response,int articleid){
		Map<String,Object> map = new HashMap<String,Object>();
		String guestIp = request.getRemoteAddr();
		Article article = articleService.getById(articleid);
		//获取跟文章相关的评论
		List<Comments> list = commentsService.getCommentsById(articleid);
		List<Comments> listfinal = new ArrayList<Comments>();
		for(Comments commt:list){
			listfinal.add(commt);
			List<Comments> l = commentsService.getCommentsById(commt.getId());
			if(l.size()!=0){
				listfinal.addAll(l);
			}
		}
		int commentscount = listfinal.size();
		
		map.put("article", article);
		map.put("commentscount", commentscount);
		map.put("comments", listfinal);
		//阅读次数加1
		articleService.readArticle(articleid);
		return map;
	}
	@RequestMapping("/saveArticle")
	public @ResponseBody String saveArticle(String author,String title,String keywords,String classify,String content){
		Article article = articleService.getByTitle(title);
		String modifytime = df.format(new Date());
		String abstractcontext = Tools.findAbstractEnd(content);
		
		if(article==null){
			String createtime=modifytime;
			articleService.saveArticle(author, title, modifytime, createtime, keywords, classify, content, abstractcontext);
		}else{
			articleService.updateArticle(article.getId(), title, modifytime, keywords, classify, content, abstractcontext);
		}
		return "success";
	}
	
	/**
	 * 获取博文列表总数
	 * @return
	 */
	@RequestMapping("/getArticleCount")
	public @ResponseBody Map<String,Object> getArticleCount(String searchtype,String param){
		Map<String,Object> map = new HashMap<String,Object>();
		int count = 0;
		char tp = searchtype.charAt(0);
		switch(tp){
		case 'c':
			int classID = Integer.parseInt(param);
			count = articleService.countByClass(classID);
			break;
		case 't':
			count = articleService.countByTag(param);
			break;
		default:
			count = articleService.countAll();
			
	}
	map.put("count", count);
		return map;
	}
}
