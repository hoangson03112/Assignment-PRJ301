<%-- 
    Document   : viewgrade
    Created on : Mar 15, 2024, 12:25:18 AM
    Author     : Hoàng Sơn
--%>

<%@page import="entity.StudentGroup"%>
<%@page import="data.GroupContext"%>
<%@page import="entity.Score"%>
<%@page import="java.lang.reflect.Field"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Score score = (Score) request.getAttribute("score");
            GroupContext dbGroup = new GroupContext();
            StudentGroup group = dbGroup.get(Integer.parseInt(request.getParameter("gid")));
                                       int count =0;
                                        double total=0;

        %>

    </head>
    <body>
        <form action="StudentGrade" method="get">
            <input type="hidden" name="subid" value="${param.subid}">
            <input type="hidden" name="gid" value="${param.gid}">
            <input type="submit" value="Back"/>
        </form>


        <h1><%=score.getSubject().getName()%>_<%=group.getName()%>_<%=score.getStudent().getSname()%></h1>


        <form action="updatescore" method="get">
            <input type="hidden" name="subid" value="${param.subid}">
            <input type="hidden" name="gid" value="${param.gid}">
            <input type="hidden" name="sid" value="${param.sid}">
            <input type="submit" value="Edit"/>
        </form>

        <table border="1px" style="text-align: center;
               width: 300px">
            <tr>
                <td>Grade Item</td>
                <td>Value</td>
            </tr>

            <%
              if (score != null) {

                    Field[] fields = score.getClass().getDeclaredFields();

                    for (Field field : fields) {
                        try {

                            field.setAccessible(true);
                            Object value = field.get(score);
                            if (value != null && !field.getType().isPrimitive()) {
                                Field[] subFields = value.getClass().getDeclaredFields();
                                for (Field subField : subFields) {
                                    try {
                                        
                                        subField.setAccessible(true);
                                        Object subValue = subField.get(value);
                                        if (subValue != null && !field.getName().equals("student") && !field.getName().equals("subject")) {
                                            total=total+(double)subValue;
                                            count++;

            %>
            <tr>
                <td><%=field.getName()%></td>   
                <td><%=subValue%></td>   

            </tr>
            <%}
   } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
           
            }
       
            %>

        </table>
        <h1>Total: <%=Math.round(10.0*total/count)/10.0 %></h1>   
    </body>
</html>
