package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.dao.TweetDAO;

@WebServlet("/new_tweet")
public class NewTweetServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String content = request.getParameter("content");
		String author = request.getParameter("author");
		HttpSession session=request.getSession();
		TweetDAO tweetDAO = new TweetDAO();
		try {
			tweetDAO.addTweet(content, author);
			session.setAttribute("result", "投稿が完了しました。");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("result", "投稿に失敗しました。");
		}
		
		response.sendRedirect("tweet_list");
		
		
	}
}
