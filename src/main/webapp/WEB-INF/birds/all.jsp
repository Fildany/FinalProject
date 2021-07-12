<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Birds List</title>
</head>
<body>
<a href="/birds/add">Add</a>
<table border="1">
    <thead>
    <th>name</th>
    <th>localization</th>
    <th></th>
    <th></th>
    </thead>
    <tbody>
    <c:forEach items="${birds}" var="bird">
        <tr>
            <td><c:out value="${bird.name}"/></td>
            <td></td>
            <td>
                <a href="<c:url value="/birds/${bird.id}/edit"/>">Edit</a>
            </td>
            <td>
                <a href="<c:url value="/birds/${bird.id}/delete"/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

