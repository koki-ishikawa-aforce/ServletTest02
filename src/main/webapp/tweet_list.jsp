<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ツイート一覧</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<%@taglib prefix="c" uri="jakarta.tags.core"%>
	<div class="container">
		<h1>ツイート一覧</h1>

		<c:if test="${not empty sessionScope.result}">
			<p>${sessionScope.result}</p>
			<c:remove var="result" scope="session" />
		</c:if>



		<%-- 新規投稿 --%>
		<p>
			<a href="new_tweet.jsp">新規投稿</a>
		</p>
		<p>
			<a href="search_tweet.jsp">ツイートの検索</a>
		</p>

		<%-- ツイート一覧の表示 --%>



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
