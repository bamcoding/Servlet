package com.ktds.board.articles.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.board.articles.biz.ArticlesBiz;
import com.ktds.board.articles.biz.ArticlesBizImpl;
import com.ktds.board.articles.vo.ArticlesVO;
import com.ktds.board.user.vo.UserVO;

public class ViewListPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticlesBiz biz;
	public ViewListPageServlet() {
		super();
		biz = new ArticlesBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ArticlesVO> articles = biz.getAllArticles();
		String viewPath = "/WEB-INF/view/articles/list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("articles", articles);
		rd.forward(request, response);
	}

}
