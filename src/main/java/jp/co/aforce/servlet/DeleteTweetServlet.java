package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.beans.Tweet;
import jp.co.aforce.dao.TweetDAO;

@WebServlet("/delete_tweet")
public class DeleteTweetServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		TweetDAO tweetDAO = new TweetDAO();
		HttpSession session=request.getSession();
		int deleteId =Integer.parseInt(request.getParameter("deleteId"));
		try {
			tweetDAO.deleteTweet(deleteId);
			List<Tweet> tweets = tweetDAO.getAllTweets();
			
			request.setAttribute("tweets", tweets);
			session.setAttribute("result", "投稿が1件削除されました。");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("tweet_list");
	}
	
	
}
