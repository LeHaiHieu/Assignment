<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/11/2024
  Time: 4:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Classes</title>
</head>
<body>
<h2>Classes</h2>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
  </tr>
  <c:forEach var="class" items="${classes}">
    <tr>
      <td>${class.id}</td>
      <td>${class.name}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
