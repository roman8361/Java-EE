<%@ page import="ru.kravchenko.enterprise.constant.FieldConst" %>
<%@ page import="ru.kravchenko.enterprise.entity.Project" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="prefix.jsp">
    <jsp:param name="title" value="PROJECTS" />
</jsp:include>

<h1>EDIT PROJECT</h1>

<%
    final Object projectObject = request.getAttribute(FieldConst.PROJECT);
    final Project project = (Project) projectObject;
%>

<form action="project-save" method="post">
    <table width="100%" cellspacing="10" cellpadding="10" border="1" style="...">
        <tr>
            <td width="300" nowrap="nowrap" align="left">
                ID:
            </td>
            <td width="100%" align="left">
                <input type="text" readonly="readonly" name="id" value="<%=project.getId()%>"/>
            </td>
        </tr>
        <tr>
            <td align="left">
                NAME:
            </td>
            <td align="left">
                <input type="text" name="name" value="<%=project.getDescription()%>"/>
            </td>
        </tr>
        <tr>
            <td align="left">
                DESCRIPTION:
            </td>
            <td align="left">
                <input type="text" name="description" value="<%=project.getDescription()%>"/>
            </td>
        </tr>
    </table>

    <br />

    <table width="100%" cellspacing="0" cellpadding="0" border="0">
        <tr>
            <td nowrap="nowrap" align="center">
                <button type="submit" style="...">SAVE</button>
            </td>
            <td width="20" nowrap="nowrap">&nbsp;</td>
            <td nowrap="nowrap" align="center">
                <button class="gray" formaction="project-list">PROJECTS</button>
            </td>
            <td width="100%">&nbsp;</td>
        </tr>
    </table>
</form>

<jsp:include page="posfix.jsp" />





<%--<html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>
