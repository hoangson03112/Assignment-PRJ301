<%-- 
    Document   : timetablestudent
    Created on : Mar 16, 2024, 5:10:42 PM
    Author     : Hoàng Sơn
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Lession"%>
<%@page import="entity.TimeSlot"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

            td {
                width: 150px; /* Đặt chiều rộng của các ô là 150px */
                height: 20px;
                padding: 10px; /* Thêm padding để tạo khoảng cách giữa nội dung và viền của ô */
                text-align: center; /* Canh giữa nội dung trong ô */
            }

            /* CSS cho các ô có class là "special" */
            td.special {
                width: 150px;
                background-color: lightblue;
            }

            /* CSS cho ô đầu tiên của mỗi hàng */
            td:first-child {
                font-weight: bold;
            }
            table{
                height: 10px;
            }
            html,body{
                height: 100vh;
            }
            h6{
                margin: 0;
            }
            .button2 {
                display: inline-block;
                transition: all 0.2s ease-in;
                position: relative;
                overflow: hidden;
                z-index: 1;
                color: #090909;
                padding: 0.5em 1.3em;
                cursor: pointer;
                font-size: 12px;
                border-radius: 0.5em;
                background: #e8e8e8;
                border: 1px solid #e8e8e8;

            }

            .button2:active {
                color: #666;
                box-shadow: inset 4px 4px 12px #c5c5c5, inset -4px -4px 12px #ffffff;
            }

            .button2:before {
                content: "";
                position: absolute;
                left: 50%;
                transform: translateX(-50%) scaleY(1) scaleX(1.25);
                top: 100%;
                width: 140%;
                height: 180%;
                background-color: rgba(0, 0, 0, 0.05);
                border-radius: 50%;
                display: block;
                transition: all 0.5s 0.1s cubic-bezier(0.55, 0, 0.1, 1);
                z-index: -1;
            }

            .button2:after {
                content: "";
                position: absolute;
                left: 55%;
                transform: translateX(-50%) scaleY(1) scaleX(1.45);
                top: 180%;
                width: 160%;
                height: 190%;
                background-color: #009087;
                border-radius: 50%;
                display: block;
                transition: all 0.5s 0.1s cubic-bezier(0.55, 0, 0.1, 1);
                z-index: -1;
            }

            .button2:hover {
                color: black;
                border: 1px solid #009087;
            }

            .button2:hover:before {
                top: -35%;
                background-color: #009087;
                transform: translateX(-50%) scaleY(1.3) scaleX(0.8);
            }

            .button2:hover:after {
                top: -45%;
                background-color: #009087;
                transform: translateX(-50%) scaleY(1.3) scaleX(0.8);
            }
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
            function redirectToTab() {
                window.location.href = "http://localhost:9999/assignment/home";
            }
        </script>
        <%
            int sid = (int) request.getAttribute("sid");
            String displayname= (String )request.getAttribute("displayname");

        %>

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

        <form action="ScheduleOfWeekStudent" method="get">
            <br/>          
            <input type="hidden" name="sid" value="${param.sid}">
            From: <input type="date" name="from" value="${requestScope.from}">
            To: <input type="date" name="to" value="${requestScope.to}">

            <input type="submit" value="View" class="button2"/>
            <hr/>
        </form> 

        <table border="1px">
            <tr>
                <td></td>
                <c:forEach items="${requestScope.dates}" var="d">
                    <td >${d} </td>
                </c:forEach>
            </tr>
            <c:forEach items = "${requestScope.slots}" var="slot">
                <tr>
                    <td>${slot.name}</td>
                    <c:forEach items="${requestScope.dates}" var="d">
                        <td>
                            <c:forEach items="${requestScope.lessions}" var="les">
                                <c:if test="${(les.getDate() eq d) and (les.slot.id eq slot.id)}">
                                    ${les.group.name} - ${les.group.subject.name}
                                    <c:forEach items="${requestScope.atts}" var="att">
                                        <c:if test="${(att.lession.id eq les.id) }">
                                            ${att.present?"present":"absent"}
                                        </c:if >

                                    </c:forEach>
                                </c:if >



                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>

        </table>




    </body>
</html>
