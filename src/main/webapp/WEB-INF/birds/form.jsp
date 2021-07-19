<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bird form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<form:form method="post" modelAttribute="bird">
    <label>name</label>
    <form:input path="name"/>
    <label>latin name</label>
    <form:input path="latin"/>
    <form:select path="city" items="${cities}" itemValue="id" itemLabel="name"/>
    <button type="submit" class="btn btn-primary">save</button>
</form:form>
<c:if test="${errors != null}">
    <c:forEach items="${errors}" var="error">
        <div>
                ${error.field} : ${error.defaultMessage}
        </div>
    </c:forEach>
</c:if>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
