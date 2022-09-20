<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <table border=1 cellpadding=0 cellspacing=0>
    <tr>
      <th>no</th>
      <th>last_name</th>
      <th>first_name</th>
      <th>email</th>
      <th></th>
    </tr>
    
    <c:forEach items="${emailList}" var="email">
    <tr>
      <td>${email.no}</td>
      <td>${email.last_name}</td>
      <td>${email.first_name}</td>
      <td>${email.email}</td>
      <td>
      	<!-- 방법1. controller @PathVariable활용 -->
      	<a href="/hellospring/delete/${email.no}">삭제</a>
      	
      	<!-- 방법2. controller @RequestParam활용 
       	<a href="/hellospring/delete?no=${email.no}">삭제</a>-->
       	
      </td>
    </tr>
    </c:forEach>
      
  </table>
</body>
</html>