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
        <style>
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
    </head>
    <body>


        <form action="StudentGrade" method="get">
            <input type="hidden" name="subid" value="${subid}">
            <input type="hidden" name="gid" value="${gid}">
            <button id="back" type="submit">
                <svg height="16" width="16" xmlns="http://www.w3.org/2000/svg" version="1.1" viewBox="0 0 1024 1024"><path d="M874.690416 495.52477c0 11.2973-9.168824 20.466124-20.466124 20.466124l-604.773963 0 188.083679 188.083679c7.992021 7.992021 7.992021 20.947078 0 28.939099-4.001127 3.990894-9.240455 5.996574-14.46955 5.996574-5.239328 0-10.478655-1.995447-14.479783-5.996574l-223.00912-223.00912c-3.837398-3.837398-5.996574-9.046027-5.996574-14.46955 0-5.433756 2.159176-10.632151 5.996574-14.46955l223.019353-223.029586c7.992021-7.992021 20.957311-7.992021 28.949332 0 7.992021 8.002254 7.992021 20.957311 0 28.949332l-188.073446 188.073446 604.753497 0C865.521592 475.058646 874.690416 484.217237 874.690416 495.52477z"></path></svg>
                <span>Back</span>
            </button>
        </form>  

            <form action="StudentGrade" method="POST" id="formAdd">
            <input type="hidden" name="gid" value="${gid}">
            <input type="hidden" name="subid" value="${subid}">

            Id: <input type="text" name="sid"><br/>
            Name: <input type="text" name="sname"><br/>
            <input type="submit" value="Add"/>
        </form>
    </body>
</html>
