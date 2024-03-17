<%-- 
    Document   : score
    Created on : Mar 12, 2024, 5:13:03 PM
    Author     : Hoàng Sơn
--%>
<%@page import="entity.Subject"%>



<%@page import="java.util.ArrayList"%>
<%@page import="entity.StudentGroup"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Score Page</title>
        <%
            ArrayList<Subject> sus = (ArrayList<Subject>) request.getAttribute("sus");
            int subid = (int) request.getAttribute("subid");
            ArrayList<StudentGroup> grs = (ArrayList<StudentGroup>) request.getAttribute("grs");
        %>
        <style>
            .navigation-card {
                width: fit-content;
                height: fit-content;
                display: flex;
                align-items: center;
                justify-content: center;
                gap: 30px;
                background-color: rgb(255, 255, 255);
                padding: 15px 20px;
                border-radius: 50px;
            }
            .tab {
                display: flex;
                align-items: center;
                justify-content: center;
                width: 1rem;
                height: 1rem;
                overflow: hidden;
                background-color: rgb(252, 252, 252);
                padding: 15px;
                border-radius: 50%;
                cursor: pointer;
                text-decoration: none;
                transition: all 0.3s;
            }
            .tab:hover {
                background-color: rgb(223, 223, 223);
            }
        </style>
        <script>
            function submit() {
                document.getElementById("form").submit();
            }
            function redirectToTab() {
                window.location.href = "http://localhost:9999/assignment/home";
            }
        </script>
    </head>
    <body>
        <div class="navigation-card" onclick="redirectToTab()">
            <a href="#" class="tab">
                <svg
                    class="svgIcon"
                    viewBox="0 0 104 100"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                    >
                <path
                    d="M100.5 40.75V96.5H66V68.5V65H62.5H43H39.5V68.5V96.5H3.5V40.75L52 4.375L100.5 40.75Z"
                    stroke="black"
                    stroke-width="7"
                    ></path>
                </svg>
            </a>


        </div>
        <form action="Grade" method="get" id="form">
            Choose Subject: <select name="subid" onchange="submit()" >
                <option value="0"> </option>
                <%  for (Subject su : sus) {
                %>
                <option 
                    value="<%=su.getId()%>" <%=(su.getId() == subid) ? "selected" : ""%>
                    ><%=su.getName()%> </option>
                <%}%>
            </select>
            <hr/>
        </form>
        <%if (subid !=0){%>
        <table border="1px" style="text-align: center">
            <tr>
                <td>Index</td>
                <td>Name</td>
                <td>Name lecturer</td>
                <td></td>
            </tr>
            <% for(int i = 0; i < grs.size(); i++) { %>
            <tr>
                <td><%= i + 1 %></td> 
                <td><%= grs.get(i).getName() %></td> 
                <td><%= grs.get(i).getLecturer().getName() %></td> 
                <td><a style=" text-decoration: none; " href="StudentGrade?subid=<%=subid%>&gid=<%= grs.get(i).getId() %>">View</a></td> 
            </tr>
            <% } %>

        </table>
        <%}%>






    </body>
</html>
