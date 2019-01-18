<%@ page import="java.util.Collection" %>
<%@ page import="ru.kravchenko.enterprise.entity.Project" %>
<%@ page import="ru.kravchenko.enterprise.constant.FieldConst" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="prefix.jsp">
    <jsp:param name="title" value="PROJECTS" />
</jsp:include>

<h1>PROJECT MANAGEMENT</h1>

<%
    final Object projectsObject = request.getAttribute(FieldConst.PROJECTS);
    final Collection<Project> projects = (Collection<Project>) projectsObject;
%>
<table width="100%" cellpadding="10" cellspacing="10" border="1" style="...">
    <tr>
        <th width="60" nowrap="nowrap" >№</th>
        <th width="200" nowrap="nowrap" align="left">NAME</th>
        <th width="100%" align="left">DESCRIPRION</th>
        <th nowrap="nowrap"></th>
        <th nowrap="nowrap"></th>
        <th nowrap="nowrap"></th>
    </tr>
<% int index = 1; %>
    <% for (final Project project: projects) { %>
    <tr>
        <td align="center"><%=index%>.</td>
        <td align="left"><%=project.getName()%></td>
        <td align="left"><%=project.getDescription()%></td>
        <td align="center">
            <a href="task-list?projectId=<%=project.getId()%>" target="_blank" style="color: black">TASKS</a>
        </td>
        <td align="center">
            <a href="project-edit?id=<%=project.getId()%>" style="color: black">EDIT</a>
        </td>
        <td align="center">
            <a href="project-remove?id=<%=project.getId()%>" style="color: black">REMOVE</a>
        </td>
    </tr>
    <% index++;%>
<% } %>
</table>

<br />

<table width="100%" cellspacing="0" cellpadding="0" border="0">
    <tr>
        <td nowrap="nowrap">
            <form action="project-create">
                <button type="submit" class="green">CREATE PROJECT</button>
            </form>
        </td>
    <td width="20" nowrap="nowrap">&nbsp;</td>
    <td nowrap="nowrap">
        <form>
            <input type="hidden" name="time" value="<%=System.currentTimeMillis()%>" />
            <button type="submit" class="gray">REFRESH</button>
        </form>
    </td>
        <td width="100%">
            &nbsp;
        </td>
    <tr/>
</table>

<jsp:include page="posfix.jsp" />

