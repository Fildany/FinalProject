<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Birds List</title>
</head>
<body>
<a href="/birds/all">Back to list</a>

<div>
    Name
    <div><c:out value="${bird.name}"/></div>
</div>
<div>
    Latin
    <div><c:out value="${bird.latin}"/></div>
</div>
<div>
    Voivodeship
    <div><c:out value="${bird.city.voivodeship.name}"/></div>
</div>
<div>
    City
    <div><c:out value="${bird.city.name}"/></div>
</div>
</body>
</html>

