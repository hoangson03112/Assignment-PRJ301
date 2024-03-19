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
        <%
            Score score = (Score) request.getAttribute("score");


        %>
    </head>

    <body>

        <form method="POST" action="addscore">
            <input type="hidden" name="sid" value="${param.sid}">
            <input type="hidden" name="subid" value="${param.subid}">
            Active_learning <input name="Active_learning" type="number" step="any" value="<%=score.getActive_learning().getValue()%>" /><br/>
            Presentation  <input name="Presentation" type="number" step="any" value="<%=score.getPresentation().getValue()%>" /><br/>
            Computer_Project  <input name="Computer_Project" type="number" step="any" value="<%=score.getComputer_Project().getValue()%>" /><br/>
            Assignment_1 <input name="Assignment_1" type="number" step="any" value="<%=score.getAssignment_1().getValue()%>" /><br/>
            Assignment_2 <input name="Assignment_2" type="number" step="any" value="<%=score.getAssignment_2().getValue()%>"  /><br/>
            PT_1 <input type="number" name="PT_1" step="any" value="<%=score.getPT_1().getValue()%>" /> <br/>
            PT_2 <input type="number"  name="PT_2" step="any" value="<%=score.getPT_2().getValue()%>" /> <br/>
            PT_3  <input type="number" name="PT_3" step="any" value="<%=score.getPT_3().getValue()%>" /> <br/>
            Project <input type="number"  name="Project" step="any " value="<%=score.getProject().getValue()%>" /> <br/>
            PE <input type="number" name="PE" step="any" value="<%=score.getPE().getValue()%>" /> <br/>
            FE  <input type="number" name="FE" step="any"value="<%=score.getFE().getValue()%>" /> <br/>

            <input  type="submit" value="Save"/>
        </form>


    </body>
</html>
