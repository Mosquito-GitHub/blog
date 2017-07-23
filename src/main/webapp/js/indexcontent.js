/**
 * 这里组装网页里的内容
 */
var page=1;// 当前页
var pagenum=1;// 页面总数

// 分页按钮点击事件
var selectPage = function(n){
	if(page==n){
		return;
	}
	page=n;
	getArticleList();
}
//选择评论的id
var cmtid=0;
var selectCommentId=function(id,commentid,category){
	if(category!=1){
		cmtid=commentid;
	}else{
		cmtid=id
	}
}
//提交评论
var submitComment=function(articleid){
	var category;
	//debugger;
	if(cmtid==0){
		cmtid=articleid;
		category=1;
	}else{
		category=2
	}
	//alert(cmtid);
	var username = $("#comment-name").val();
	var email = $("#email").val();
	var url = $("#comment-url").val();
	var content = $("#comment-body").val();
	
	$.ajax({
		type: "POST", 
		url:"/myblog/comments/submitComments",
		data:{commentid:cmtid,username:username,email:email,url:url,content:content,category:category},
		
		success:function(data){
			cmtid=0;
			showPage(articleid);
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
		}
	});
}
// 打开文章
var showPage = function(id){
	$.ajax({
		type: "POST", 
		url:"/myblog/article/getArticle",
		data:{articleid:id},
		dataType:"json",
		success:function(data){
			$("#article_list").html("");// 清空info内容
			var article = data.article;
			var commentscount = data.commentscount;
			var comments = data.comments;
			//博文部分
			$("#article_list").append(
					"<article class='blog-post'>"+
                    "<div class='body'>"+
                        "<h1>"+article.title+"</h1>"+
                        "<div class='meta'>"+
                            "<i class='fa fa-user'></i> "+ article.author+" <i class='fa fa-calendar'></i>"+article.modifytime+"<i class='fa fa-comments'></i><span class='data'><a href='#comments'>"+commentscount+" Comments</a></span>"+
                        "</div>"+
                        article.context+
                    "</div>"+
                "</article>"
			);
			if(commentscount !=0){
				//评论部分
				$("#article_list").append(
					"<aside class='comments' id='comments'>"+
                    "<hr>"+
                    "<h2><i class='fa fa-comments'></i> "+commentscount+" Comments</h2>"+
                    "</aside>"
					);
				$.each(comments, function(i, item) {
					var commentsCategory = "comment";
					if(item.category!=1){
						commentsCategory="comment reply";
					}
					$("#comments").append(
						"<article class='"+commentsCategory+"'>"+
                        "<header class='clearfix'>"+
                            "<img src='"+item.headpic+"' alt='A Smart Guy' class='avatar'>"+
                            "<div class='meta'>"+
                                "<h3><a href='#'>"+item.username+"</a></h3>"+
                                "<span class='date'>"+
                                item.commtime.substring(0,16)+
                                "</span>"+
                                "<span class='separator'>"+
                                    "-"+
                                "</span>"+
                                "<a href='#create-comment' class='reply-link' onclick='selectCommentId("+item.id+","+item.commentid+","+item.category+")'>回复</a>"+                
                            "</div>"+
                            "</header>"+
                            "<div class='body'>"+
                            item.content+
                        "</div>"+
                        "</article>"
						);
				});
				
			}
			$("#article_list").append(
					"<aside class='create-comment' id='create-comment'>"+
                    "<hr>"+
                    "<h2><i class='fa fa-pencil'></i> Add Comment</h2>"+
                        "<div class='row'>"+
                            "<div class='col-md-6'>"+
                                "<input type='text' name='name' id='comment-name' placeholder='Your Name' class='form-control input-lg'>"+    
                            "</div>"+
                            "<div class='col-md-6'>"+
                                "<input type='email' name='email' id='comment-email' placeholder='Email' class='form-control input-lg'>"+    
                            "</div>"+
                        "</div>"+
                        "<input type='url' name='name' id='comment-url' placeholder='Website' class='form-control input-lg'>"+
                        "<textarea rows='10' name='message' id='comment-body' placeholder='Your Message' class='form-control input-lg'></textarea>"+
                        "<div class='buttons clearfix'>"+
                            "<button type='button' class='btn btn-xlarge btn-clean-one' onclick='submitComment("+article.id+")'>提交</button>"+
                        "</div>"+
                    
                "</aside>"
					);
		}
	});
}
// 获取数据成功回调函数
// var success =
// 获取数据
var getArticleList = function(){
	$.ajax({
		type: "POST", 
		url:"/myblog/article/getArticleList",
		data:{page:page,pagecount:5},
		success:function(data){
			//debugger;
			$("#article_list").html("");// 清空info内容
			var articleCount = data.count;
			pagenum = Math.ceil(articleCount/5);
			$.each(data.list, function(i, item) {
				$("#article_list").append(
							"<div class='row' style=\"background-image: url('img/article_list_bg.PNG');\">"+
							"<article class=' blog-teaser'>"+
							"<h2 class='entry-title'>"+
							"<a href='javascript:void(0);' onclick='showPage("+item.id+")'>"+item.title+"</a></h2><p>"+
							item.abstractContext+"</p><br>"+
							"<span class='fa fa-calendar'>&nbsp;"+item.createtime+",</span>&nbsp;"+
							"<span class='fa fa-user'>&nbsp;"+item.author+"</span>&nbsp;"+ 
							"<span class='fa fa-eye'>&nbsp;"+item.readnum+"</span><hr>"+
							"</article>"+
							"</div>"+
							"<div class='row'><br><br></div>"
						);
			});
			var licontent="";
			for(var i=1;i<= pagenum;i++){
				licontent +="<li><a href='javascript:void(0);' onclick='selectPage("+i+")'>"+i+"</a></li>";
			}
			$("#article_list").append(
					"<div class='row'>"+
							"<nav aria-label='Page navigation'>"+
							"<ul class='pagination'>"+
								"<li><a href='#' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li>"+
								licontent+
								"<li><a href='#' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li>"+
							"</ul>"+
							"</nav>"+
							"</div>"
					);
		},
		dataType:"json"
		});
}

var getNewArticleList=function(id){
	$.ajax({
		type:"POST", 
		url:"/myblog/article/getNewArticleList",
		dataType:"json",
		success:function(data){
			$("#newArticleList").html("");// 清空info内容
			$.each(data.list, function(i, item) {
				$("#newArticleList").append(
						"<li><a href='javascript:void(0);' onclick='showPage("+item.id+")'>"+item.title+"</a></li>"
						);
			});
		}
	});
}