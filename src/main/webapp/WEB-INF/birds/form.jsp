<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bird form</title>
</head>
<body>
<form:form method="post" modelAttribute="bird">
    <label>name</label>
    <form:input path="name"/>
    <label>latin name</label>
    <form:input path="latin"/>
    <form:select path="city" items="${cities}" itemValue="id" itemLabel="name"/>
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
