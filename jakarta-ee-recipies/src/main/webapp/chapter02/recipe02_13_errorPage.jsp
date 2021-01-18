<%-- 
    Document   : recipe01_21_errorPage
    Author     : juneau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
           prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Error Page</title>
</head>
<body>
<h1>Error Encountered</h1>
<br/>
<br/>
<p>
    The application has encountered the following error:
    <br/>
    <fmt:bundle basename="org.jakartaeerecipes.chapter02.recipe02_13.Messages">
        <fmt:message key="ServerError"/>: ${pageContext.errorData.statusCode}
    </fmt:bundle>

</p>
</body>
</html>
