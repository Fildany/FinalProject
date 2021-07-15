<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <label>email</label>
    <form:input path="email"/>
    <label>password</label>
    <form:input path="password"/>
    <button type="submit">save</button>
</form:form>
<c:if test="${errors != null}">
    <c:forEach items="${errors}" var="error">
        <div>
                ${error.field} : ${error.defaultMessage}
        </div>
    </c:forEach>
</c:if>
</body>
</html>
