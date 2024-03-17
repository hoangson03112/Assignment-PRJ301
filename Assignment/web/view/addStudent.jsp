<%-- 
    Document   : addStudent
    Created on : Mar 17, 2024, 8:12:02 PM
    Author     : Hoàng Sơn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="StudentGrade" method="POST">
            <input type="hidden" name="gid" value="${gid}">
            <input type="hidden" name="subid" value="${subid}">

            Id: <input type="text" name="sid"><br/>
            Name: <input type="text" name="sname"><br/>
            <input type="submit" value="Add"/>
        </form>
    </body>
</html>
