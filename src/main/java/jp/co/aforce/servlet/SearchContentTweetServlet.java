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

@WebServlet("/search_content_tweet")
public class SearchContentTweetServlet extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		String searchContent=request.getParameter("search");
		TweetDAO tweetDAO = new TweetDAO();

		try {
			List<Tweet> tweets = tweetDAO.searchContentTweet(searchContent);
			
			request.setAttribute("tweets", tweets);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("search_tweet.jsp").forward(request, response);
	}

}
