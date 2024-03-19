<%-- 
    Document   : updateScore
    Created on : Mar 20, 2024, 12:47:06 AM
    Author     : Hoàng Sơn
--%>
<%@page import="entity.Score"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
    Score s = (Score) request.getAttribute("score");
    %>
    <body>
        <form method="POST" action="updates">
            ActiveLearning <input name="ActiveLearning" type="number"  value="<%= s.getActive_learning().getValue()%>"/> <br/>
            Presentation <input name="Presentation" type="number" step="any" value="<%= s.getPresentation().getValue()%>"/> <br/>
            ComputerProject <input name="ComputerProject" type="number" step="any" value="<%= s.getComputer_Project().getValue()%>"/><br/>
            Assignment1 <input name="Assignment1" type="number" step="any" value="<%= s.getAssignment_1().getValue()%>"/> <br/>
            Assignment2 <input name="Assignment2" type="number" step="any" value="<%= s.getAssignment_2().getValue()%>"/> <br/>
            PT1 <input type="number" name="PT1" step="any" value="<%= s.getPT_1().getValue()%>"/> <br/>
            PT2 <input type="number" name="PT2" step="any" value="<%= s.getPT_2().getValue()%>"/> <br/>
            PT3 <input type="number" name="PT3" step="any" value="<%= s.getPT_3().getValue()%>"/> <br/>
            Project <input type="number" name="Project" step="any" value="<%= s.getProject().getValue()%>"/> <br/>
            PE <input type="number" name="PE" step="any" value="<%= s.getPE().getValue()%>"/> <br/>
            FE <input type="number" name="FE" step="any" value="<%= s.getFE().getValue()%>"/> <br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
