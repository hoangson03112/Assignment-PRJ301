<%-- 
    Document   : viewscore
    Created on : Mar 14, 2024, 4:57:44 AM
    Author     : Hoàng Sơn
--%>

<%@page import="entity.StudentGroup"%>
<%@page import="data.GroupContext"%>
<%@page import="entity.Subject"%>
<%@page import="entity.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Score Page</title>
        <style>

            #dele {
                margin: 0 5px;
                position: relative;
                background-color: rgb(230, 34, 77);
                border-radius: 5px;
                box-shadow: rgb(121, 18, 55) 0px 4px 0px 0px;
                text-align: center;
                background-repeat: no-repeat;
                cursor: pointer;
                box-sizing: border-box;
                width: 3rem;
                height: 1.5rem;
                color: #fff;
                border: none;

                transition: all 0.3s ease-in-out;
                z-index: 1;
                overflow: hidden;
            }

            #dele ::before {
                content: "";
                background-color: rgb(248, 50, 93);
                width: 0;
                height: 100%;
                position: absolute;
                top: 0;
                left: 0;
                z-index: -1;
                transition: width 700ms ease-in-out;
                display: inline-block;
            }

            #dele :hover::before {
                width: 100%;
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
                background:#c9c1c1;
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

            .button {
                margin-left: 22rem;
                margin-bottom: .6rem;
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 6px 12px;
                gap: 4px;
                height: 1.8rem;
                width: 8.7rem;
                border: none;
                background: #1b1b1cd0;
                border-radius: 20px;
                cursor: pointer;
            }

            .lable {
                line-height: 22px;
                font-size: 9px;
                color: #DE8A2A;
                font-family: sans-serif;
                letter-spacing: 1px;
            }

            .button:hover {
                background: #1b1b1cea;
            }

            .button:hover .svg-icon {
                animation: rotate 1.3s linear infinite;
            }

            @keyframes rotate {
                0% {
                    transform: rotate(0deg);
                }

                25% {
                    transform: rotate(10deg);
                }

                50% {
                    transform: rotate(0deg);
                }

                75% {
                    transform: rotate(-10deg);
                }

                100% {
                    transform: rotate(0deg);
                }
            }



        </style>


        <% ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students");
            int subid = (int) request.getAttribute("subid");
            ArrayList<Subject> subs = (ArrayList<Subject>) request.getAttribute("subs");
            GroupContext dbgr = new GroupContext();
            ArrayList<StudentGroup> grs = dbgr.list(subid);
            int gid = Integer.parseInt(request.getParameter("gid"));
        %>
    </head>

    <body>

        <form action="Grade" method="get">
            <input type="hidden" name="subid" value="${param.subid}">
            <button id="back" type="submit">
                <svg height="16" width="16" xmlns="http://www.w3.org/2000/svg" version="1.1" viewBox="0 0 1024 1024"><path d="M874.690416 495.52477c0 11.2973-9.168824 20.466124-20.466124 20.466124l-604.773963 0 188.083679 188.083679c7.992021 7.992021 7.992021 20.947078 0 28.939099-4.001127 3.990894-9.240455 5.996574-14.46955 5.996574-5.239328 0-10.478655-1.995447-14.479783-5.996574l-223.00912-223.00912c-3.837398-3.837398-5.996574-9.046027-5.996574-14.46955 0-5.433756 2.159176-10.632151 5.996574-14.46955l223.019353-223.029586c7.992021-7.992021 20.957311-7.992021 28.949332 0 7.992021 8.002254 7.992021 20.957311 0 28.949332l-188.073446 188.073446 604.753497 0C865.521592 475.058646 874.690416 484.217237 874.690416 495.52477z"></path></svg>
                <span>Back</span>
            </button>
        </form>  

        <% for (StudentGroup gr : grs) {
               
                if (gr.getId()== gid) {%>
        <h1><%=gr.getName()%>_<%=gr.getSubject().getName()%>_<%=gr.getLecturer().getName()%></h1>
        <%  }
            }
        %>    


        <form action="addstudent" method="POST">
            <input type="hidden" name="gid" value="${param.gid}">          
            <input type="hidden" name="subid" value="${param.subid}">

            <button type="submit" class="button">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" viewBox="0 0 20 20" height="20" fill="none" class="svg-icon"><g stroke-width="1.5" stroke-linecap="round" stroke="#de8a2a"><circle r="7.5" cy="10" cx="10"></circle><path d="m9.99998 7.5v5"></path><path d="m7.5 9.99998h5"></path></g></svg>
                <span class="lable">Add Student</span>
            </button>
        </form>


        <table border="1px" style="text-align: center;width: 500px">
            <tr>
                <td>ID</td>
                <td>Name</td>




            </tr>
            <% for (Student student : students) {%>
            <tr>

                <td><%=student.getSid()%></td> 
                <td><%=student.getSname()%></td> 
                <td><a style=" text-decoration: none; " href="ViewGrade?gid=<%=gid %>&sid=<%=student.getSid()%>&subid=<%=subid%>">View Grade</a></td> 
                <td> <form method="POST" action="deletestudent">
                        <input type="hidden" name="gid" value="${param.gid}">
                        <input type="hidden" name="subid" value="${param.subid}">
                        <input type="hidden" name="sid" value="<%=student.getSid()%>">
                        <button id="dele" type="submit">Delete</button>
                    </form>
                </td>
            </tr>
            <% }%>

        </table>




    </body>
</html>
