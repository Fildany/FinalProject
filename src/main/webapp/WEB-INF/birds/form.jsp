<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="bird">
    <form:input path="name"/>
    <form:input path="latin"/>
    <form:select path="localization"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
