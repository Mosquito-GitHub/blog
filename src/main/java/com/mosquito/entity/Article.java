package com.mosquito.entity;

public class Article {
	private int id;//id
	private String author;//作者
	private String title;//标题
	private String modifytime;//最后修改时间
	private String createtime;//创建时间
	private String keyword;//关键字
	private String tags;//标签
	private String context;//内容
	private String abstractContext;
	private String readnum;//浏览量

	public Article(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int articleId) {
		this.id = articleId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getModifytime() {
		return modifytime;
	}

	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}

	
	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getReadnum() {
		return readnum;
	}

	public void setReadnum(String readnum) {
		this.readnum = readnum;
	}

	public String getAbstractContext() {
		return abstractContext;
	}

	public void setAbstractContext(String abstractContext) {
		this.abstractContext = abstractContext;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", author=" + author + ", title=" + title + ", modifytime="
				+ modifytime + ", createtime=" + createtime + ", keyword=" + keyword + ", tags=" + tags + ", context="
				+ context + ", abstractContext=" + abstractContext + ", readnum=" + readnum + "]";
	}

	
}
