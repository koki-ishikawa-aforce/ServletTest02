package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.aforce.beans.Tweet;
import jp.co.aforce.dao.TweetDAO;

@WebServlet("/tweet_success")
public class TweetSuccessServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TweetDAO tweetDAO = new TweetDAO();
		try {
			List<Tweet> tweets = tweetDAO.getAllTweets();
			String test = request.getParameter("<p>"+"test"+"</p>");
			request.setAttribute("tweets", tweets);
			request.setAttribute("test", test);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("tweet_list_success.jsp").forward(request, response);
	}
}
