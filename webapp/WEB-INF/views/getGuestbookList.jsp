<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/hellospring/addGuestbook" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" width="100%"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password" width="100%"></td>
			</tr>
			<tr>
				<td colspan=4 >
					<textarea name="content" cols=60 rows=5 style="width: 100%"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="확인"></td>
			</tr>
		</table>
	</form>

	<c:forEach items="${guestbookList}" var="guestbook">
		<table border=1 cellpadding=0 cellspacing=0 style="width: 35%">
			<tr>
				<th>no</th>
				<td>${guestbook.no}</td>
				<th>작성일</th>
				<td>${guestbook.regDate}</td>
			</tr>
			<tr>
				<th>name</th>
				<td colspan="3">${guestbook.name}</td>
			</tr>
			<tr>
				<th>content</th>
				<td colspan="3">${guestbook.content}</td>
			</tr>
			<tr>
				<td colspan="4">
					<a href="/hellospring/gbDeleteConfirm/${guestbook.no}">삭제</a>
				</td>
			</tr>
		</table>
		<br/>
	</c:forEach>


</body>
</html>