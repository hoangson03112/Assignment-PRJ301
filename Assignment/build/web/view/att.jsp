<%-- 
    Document   : att
    Created on : Mar 5, 2024, 2:22:36 AM
    Author     : Hoàng Sơn
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entity.Attendence"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendance</title>
        <link rel="stylesheet" href="view/att.css"/>
        <% int leid=(int)request.getAttribute("leid");
         
          
        %>
        <style>
            .container {
                transform-style: preserve-3d;
                perspective: 100px;
            }

            .pane {
                outline: 2px solid #00ff6a;
                box-shadow: 0 0 10px #00ff6a77, inset 0 0 10px #00ff6a77;
                height: 1cm;

                border-radius: 5px;
                position: relative;
                overflow: hidden;
                transition: 0.7s ease;
            }

            .input {
                display: none;
            }

            .label {
                height: 1cm;
                width: 1.5cm;
                float: left;
                font-weight: 600;
                letter-spacing: -1px;
                font-size: 14px;
                padding: 0px;
                position: relative;
                z-index: 1;
                color: #00ff6a;
                text-align: center;
                padding-top: 10px;
            }

            .selection {
                display: none;
                position: absolute;
                height: 1cm;
                width: calc(4.5cm / 3);
                z-index: 0;
                left: 0;
                top: 0;
                box-shadow: 0 0 10px #00ff6a77;
                transition: .15s ease;
            }

            .label:has(input:checked) {
                color: #212121;
            }

            .label:has(input:checked) ~ .selection {
                background-color: #00ff6a;
                display: inline-block;
            }

            .label:nth-child(1):has(input:checked) ~ .selection {
                transform: translateX(calc(4.5cm * 0/3));
            }

            .label:nth-child(2):has(input:checked) ~ .selection {
                transform: translateX(calc(4.5cm * 1/3));
            }


            body {
                overflow: hidden;
            }
            #save {
                position: fixed;
                right: 14rem;
                margin-top:1rem;
                background: #fbca1f;
                font-family: inherit;
                padding: 0.6em 1.3em;
                font-weight: 900;
                font-size: 18px;
                border: 3px solid black;
                border-radius: 0.4em;
                box-shadow: 0.1em 0.1em;
                cursor: pointer;

            }
            #save:hover {
                transform: translate(-0.05em, -0.05em);
                box-shadow: 0.15em 0.15em;
            }

            #save:active {
                transform: translate(0.05em, 0.05em);
                box-shadow: 0.05em 0.05em;
            }
            .container {
                transform-style: preserve-3d;
                perspective: 100px;
            }

            .pane {
                outline: 2px solid #00ff6a;
                box-shadow: 0 0 10px #00ff6a77, inset 0 0 10px #00ff6a77;
                height: 1cm;

                border-radius: 5px;
                position: relative;
                overflow: hidden;
                transition: 0.7s ease;
            }

            .input {
                display: none;
            }

            .label {
                height: 1cm;
                width: 1.5cm;
                float: left;
                font-weight: 600;
                letter-spacing: -1px;
                font-size: 14px;
                padding: 0px;
                position: relative;
                z-index: 1;
                color: #948e8e;
                text-align: center;
                padding-top: 10px;
            }

            .selection {
                display: none;
                position: absolute;
                height: 1cm;
                width: calc(4.5cm / 3);
                z-index: 0;
                left: 0;
                top: 0;
                box-shadow: 0 0 10px #000000;
                transition: .15s ease;
            }

            .label:has(input:checked) {
                color: #fff7f7;
            }

            .label:has(input:checked) ~ .selection {
                background-color: #000000;

                display: inline-block;
            }

            .label:nth-child(1):has(input:checked) ~ .selection {
                transform: translateX(calc(4.5cm * 0/3));
            }

            .label:nth-child(2):has(input:checked) ~ .selection {
                transform: translateX(calc(4.5cm * 1/3));
            }
            #back {
                display: flex;
                height: 3em;
                width: 100px;
                align-items: center;
                justify-content: center;
                background-color: #eeeeee4b;
                border-radius: 3px;
                letter-spacing: 1px;
                transition: all 0.2s linear;
                cursor: pointer;
                border: none;
                background: #c9c1c1;
            }

            #back > svg {
                margin-right: 5px;
                margin-left: 5px;
                font-size: 20px;
                transition: all 0.4s ease-in;
            }

            #back:hover > svg {
                font-size: 1.2em;
                transform: translateX(-5px);
            }

            #back:hover {
                box-shadow: 9px 9px 33px #d1d1d1, -9px -9px 33px #ffffff;
                transform: translateY(-2px);
                background-color: #e80505;
                color: wheat;
            }


        </style>
    </head>
    <body>
        <form action="ScheduleOfWeek" method="get">
            <input type="hidden" name="lid" value="${param.lid}">
            <button id="back" type="submit">
                <svg height="16" width="16" xmlns="http://www.w3.org/2000/svg" version="1.1" viewBox="0 0 1024 1024"><path d="M874.690416 495.52477c0 11.2973-9.168824 20.466124-20.466124 20.466124l-604.773963 0 188.083679 188.083679c7.992021 7.992021 7.992021 20.947078 0 28.939099-4.001127 3.990894-9.240455 5.996574-14.46955 5.996574-5.239328 0-10.478655-1.995447-14.479783-5.996574l-223.00912-223.00912c-3.837398-3.837398-5.996574-9.046027-5.996574-14.46955 0-5.433756 2.159176-10.632151 5.996574-14.46955l223.019353-223.029586c7.992021-7.992021 20.957311-7.992021 28.949332 0 7.992021 8.002254 7.992021 20.957311 0 28.949332l-188.073446 188.073446 604.753497 0C865.521592 475.058646 874.690416 484.217237 874.690416 495.52477z"></path></svg>
                <span>Back</span>
            </button>
        </form>


        <form action="attendance" method="POST"> 
            <input type="hidden" name="leid" value="<%=leid%>"/>
            <input type="hidden" name="lid" value="${param.lid}">
            <input type="hidden" name="sid" value="${param.studentId}">



            <div class="container">

                <div class="table">
                    <div class="table-header">
                        <div class="header__item"><a id="name" class="filter__link" href="#">ID</a></div>
                        <div class="header__item"><a id="wins" class="filter__link filter__link--number" href="#">Name</a></div>
                        <div class="header__item"><a id="draws" class="filter__link filter__link--number" href="#">Is Presented</a></div>
                        <div class="header__item"><a id="losses" class="filter__link filter__link--number" href="#">Description</a></div>
                        <div class="header__item"><a id="total" class="filter__link filter__link--number" href="#">Att Time</a></div>
                    </div>
                    <div class="table-content">

                        <c:forEach items="${requestScope.atts}" var="a">
                            <input type="hidden" name="student${a.student.sid}" value="${a.student.sid}">


                            <div class="table-row">      
                                <div class="table-data">${a.student.sid}</div>
                                <div class="table-data">${a.student.sname}</div>

                                <div class="table-data">
                                    <input type="radio" 
                                           ${!a.present?"checked=\"checked\"":""}
                                           name="present${a.student.sid}" value="no"/> No
                                    <input type="radio" 
                                           ${a.present?"checked=\"checked\"":""}
                                           name="present${a.student.sid}" value="yes"/> Yes
                                </div>
                                <div class="table-data">
                                    <input type="text" name="description${a.student.sid}" value="${a.description}"/>
                                </div>

                                <div class="table-data">${a.time}</div>
                            </div>   
                        </c:forEach>



                    </div>
                </div>
            </div>




            <input id="save" type="submit" value="Save"/>
        </form>
    </body>
</body>
</html>
