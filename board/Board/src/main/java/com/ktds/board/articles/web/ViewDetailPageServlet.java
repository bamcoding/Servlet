package com.ktds.board.articles.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.board.articles.biz.ArticlesBiz;
import com.ktds.board.articles.biz.ArticlesBizImpl;
import com.ktds.board.articles.dao.ArticlesDao;
import com.ktds.board.articles.dao.ArticlesDaoImpl;
import com.ktds.board.articles.vo.ArticlesVO;
import com.ktds.board.support.Param;

public class ViewDetailPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticlesBiz biz;
	private ArticlesDao dao;
	public ViewDetailPageServlet() {
		super();
		biz = new ArticlesBizImpl();
		dao = new ArticlesDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String articlesId = Param.getStringParam(request, "articleId");
		String recommand = Param.getStringParam(request, "recommand");
		if(recommand.length() == 0){
			recommand="";
		}
		
		if(articlesId.length() == 0){
			articlesId="";
		}
		
		if(recommand.equals("1")){
			dao.updateRecommandCount(articlesId);
		}
		
		ArticlesVO articles= biz.getArticleBy(articlesId);
		String viewPath = "/WEB-INF/view/articles/detail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("articles", articles);
		rd.forward(request, response);
	}

}
