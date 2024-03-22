<%-- 
    Document   : schedule
    Created on : Oct 9, 2023, 7:46:45 AM
    Author     : User
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>
        .centered {
            margin: auto;
            width: 50%;
            text-align: center;
            padding: 20px;
        }
    </style>
    </head>
    <body>
        <div class="centered">
        <form action="timetable" method="GET">
            From <input type="date" name="from" value="${requestScope.from}"/> <br/>
            To <input type="date" name="to" value="${requestScope.to}"/>
            <input type="hidden" value="${param.id}" name="id"/>
            <input type="submit" value="View"/>
        </form>
        <table border="1px">
            <tr>
                <td></td>
                <c:forEach items="${requestScope.dates}" var="d">
                    <td>
                        <fmt:formatDate value="${d}" pattern="dd-MM-yyyy" var="formattedDate" />
                        <p>${formattedDate}</p>
                    </td>
                </c:forEach>
            </tr>
            <c:forEach items="${requestScope.slots}" var="s">
                <tr>
                    <td>${s.description}</td>
                    <c:forEach items="${requestScope.dates}" var="d">
                        <td>
                            <c:forEach items="${requestScope.sessions}" var="se">
                                <c:if test="${se.time.tid eq s.tid and se.date eq d}">
                                    <a href="attendance?id=${se.seid}"> ${se.group.gname}-${se.subject.sname}-${se.room.rid}</a></br>
                                    <c:if test="${se.isatt}">(attended)</c:if>
                                    <c:if test="${!se.isatt}">(Not yet)</c:if>
                                </c:if>
                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>  
            </c:forEach>
        </table>    
        </div>
    </body>
</html>
