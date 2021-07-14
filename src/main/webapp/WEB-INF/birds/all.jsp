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
    <th>Name</th>
    <th>Latin</th>
    <th>Voivodeship</th>
    <th>City</th>
    <th></th>
    <th></th>
    </thead>
    <tbody>
    <c:forEach items="${birds}" var="bird">
        <tr>
            <td>
                <a href="<c:url value="/birds/${bird.id}/details"/>">
                    <c:out value="${bird.name}"/>
                </a>
            </td>
            <td><c:out value="${bird.latin}"/></td>
            <td><c:out value="${bird.city.voivodeship.name}"/></td>
            <td><c:out value="${bird.city.name}"/></td>
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

