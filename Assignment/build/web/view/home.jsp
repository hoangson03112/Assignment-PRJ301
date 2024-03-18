<%-- 
    Document   : home
    Created on : Mar 6, 2024, 6:42:15 PM
    Author     : Hoàng Sơn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="view/home.css"/>
        <style>
            .cards .green {
                background-color: greenyellow;
            }

        </style>


        <script>
            function redirectToTabTimeTable() {
                window.location.href = "http://localhost:9999/assignment/ScheduleOfWeek?lid=" +<%= request.getAttribute("lid")%>;
            }
            function redirectToTabLogin() {
                window.location.href = "http://localhost:9999/assignment/logout";
            }
            function redirectToTabScore() {
                window.location.href = "http://localhost:9999/assignment/Grade";
            }
            function redirectToTabTimeTableSt() {
                window.location.href = "http://localhost:9999/assignment/ScheduleOfWeekStudent?sid=" + <%= request.getAttribute("sid")%>;
            }
        </script>
    </head>
    <body>
        <%= request.getAttribute("lid")%>
        <%= request.getAttribute("sid")%>

        <h2><%= request.getAttribute("displayname")%></h2>
        <div class="cards">
            <div class="card red" onclick="redirectToTabTimeTable()">
                <p class="tip">Timetable of Lecturer</p>

            </div>
            <div class="card green" onclick="redirectToTabTimeTableSt()">
                <p class="tip">Timetable of Student</p>

            </div>
            <div class="card blue" onclick="redirectToTabScore()">
                <p class="tip">Mark Report</p>
            </div>

            <button class="Btn" onclick="redirectToTabLogin()">

                <div class="sign"><svg viewBox="0 0 512 512"><path d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"></path></svg></div>

                <div class="text">Logout</div>
            </button>



        </div>

    </body>
</html>
