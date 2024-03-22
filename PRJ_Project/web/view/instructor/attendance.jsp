<%-- 
    Document   : check
    Created on : Oct 6, 2023, 10:23:29 PM
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
         ${requestScope.ses.group.gname}-${requestScope.ses.subject.sname}-${requestScope.ses.room.rid}
        -${requestScope.ses.time.description}
        <br/>
        <form action="attendance" method="POST">
            <table border="1px"> 
                <tr>
                    <td>Student</td>
                    <td>Status</td>
                    <td>Description</td>
                    <td>Time</td>
                </tr>
                <c:forEach items="${requestScope.atts}" var="a">
                 <tr>
                    <td>${a.student.stname}
                        <input type="hidden" name="stid" value="${a.student.stid}"/>
                    </td>
                    <td>
                        <input type="radio"
                               <c:if test="${!a.status}">checked="checked"
                               </c:if> name="status${a.student.stid}" value="absent"/>absent
                        <input type="radio"
                               <c:if test="${a.status}">
                                   checked="checked"
                               </c:if>
                               name="status${a.student.stid}" value="present"/>present
                        </td>
                    <td>
                        <input type="text" value="${a.description}"
                               name="description${a.student.stid}"/>
                    </td>
                    <td>${a.datetime}</td>
                </tr>   
                    
                </c:forEach>
            </table>
            <input type="hidden" value="${requestScope.ses.seid}" name="seid"/>
            <input type="submit" value="Save"/>
        </form>
        </div>
    </body>
</html>
