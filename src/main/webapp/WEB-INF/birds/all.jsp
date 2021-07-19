<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Birds List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-md">
<a href="/birds/add">Add</a>
<table class="table table-striped" border="1">
    <thead>
    <th scope="col">Name</th>
    <th scope="col">Latin</th>
    <th scope="col">Voivodeship</th>
    <th scope="col">City</th>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</div>
</body>
</html>

