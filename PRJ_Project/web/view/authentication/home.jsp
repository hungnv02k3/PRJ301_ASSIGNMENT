<%-- 
    Document   : home
    Created on : Nov 9, 2023, 1:49:34 AM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
             <a href="timetable">timetable</a>
            <c:if test="${sessionScope['account'].roles eq 'student'}"><a href="profile">Profile</a></c:if>
    </body>
</html>
