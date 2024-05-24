<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<title>ツイートの検索</title>
</head>
<body>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
	<div class="container">
		<h1>ツイートの検索</h1>
		<p>
			<a href="tweet_list">リストに戻る</a>
		</p>
		<form action="search_tweet" method="get">
			<input type="search" name="search"> 
			<input type="submit" value="検索">
		</form>

		<ul class="tweet-list">
			<c:forEach var="i" items="${tweets}">
				<li>
					<div class="tweet-content">
						<p>${i.content}</p>
						<p class="tweet-info">投稿者: ${i.author } - 投稿日時: ${i.postedAt}</p>
						<form action="delete_tweet" method="post">
							<input type="hidden" name="deleteId" value="${i.id }"> <input
								type="submit" value="削除">
						</form>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>