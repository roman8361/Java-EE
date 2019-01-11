<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.title}</title>
    <style>
        body {
            margin: 0px;
            padding: 0;
        }
        a {
            /*color: black;*/
            color: white;
        }
        button {
            font-size: 1.1em;
            background-color: green;
            border: none;
            color: white;
            padding: 10px 28px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        input[type="text"], input[type="date"], input[type="number"], input[type="password"]{
            border: 1px solid black;
            border-radius: 3px;
            -webkit-border-radius: 3px;
            -moz-border-radius: 3px;
            -khtm-border-radius: 3px;
            background: #ffffff !important;
            outline: none;
            height: 34px;
            width: 350px;
            font-family: "Times New Roman", serif;
            color: black;
            font-size: 1.6em;
        }

    </style>
</head>
<body>
<jsp:include page="main-menu.jsp" />
<table width="100%" cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td width="20" nowrap="nowrap">&nbsp;</td>
        <td width="100%">
        </td>
    </tr>
</table>
</body>
</html>