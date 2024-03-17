<%-- 
    Document   : editScore
    Created on : Mar 18, 2024, 2:26:59 AM
    Author     : Hoàng Sơn
--%>

<%@page import="java.lang.reflect.Field"%>
<%@page import="entity.Score"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
      
    %>
    <body>
        <form method="POST" action="addscore">
            Active_learning <input name="Active_learning" type="number" step="any" /><br/>
            Presentation  <input name="Presentation" type="number" step="any"/><br/>
            Computer_Project  <input name="Computer_Project" type="number" step="any"/><br/>
            Assignment_1 <input name="Assignment_1" type="number" step="any"/><br/>
            Assignment_2 <input name="Assignment_2" type="number" step="any"/><br/>
            PT_1 <input type="number" name="PT_1" step="any"/><br/>
            PT_2 <input type="number"  name="PT_2" step="any"/><br/>
            PT_3  <input type="number" name="PT_3" step="any"/><br/>
            Project <input type="number"  name="Project" step="any"/><br/>
            PE <input type="number" name="PE" step="any"/><br/>
            FE  <input type="number" name="FE" step="any"/><br/>

            <input  type="submit" value="Save"/>
        </form>
    </body>
</html>
