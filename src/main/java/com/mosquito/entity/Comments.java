package com.mosquito.entity;

public class Comments {

	private int id;
	private int commentid;
	private int userid;
	private String username;
	private String headpic;
	private String commtime;
	private String content;
	private String category;

	public Comments() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHeadpic() {
		return headpic;
	}

	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}

	public String getCommtime() {
		return commtime;
	}

	public void setCommtime(String commtime) {
		this.commtime = commtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", commentid=" + commentid + ", userid=" + userid + ", username=" + username
				+ ", headpic=" + headpic + ", commtime=" + commtime + ", content=" + content + ", category=" + category
				+ "]";
	}

}
