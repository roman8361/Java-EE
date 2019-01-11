<%@ page import="ru.kravchenko.enterprise.constant.FieldConst" %>
<%@ page import="ru.kravchenko.enterprise.entity.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="prefix.jsp">
    <jsp:param name="title" value="TASKS" />
</jsp:include>

<h1>EDIT TASK</h1>

<%
    final Object projectObject = request.getAttribute(FieldConst.TASK);
    final Task task = (Task) projectObject;
%>

<form action="task-save" method="post">
    <table width="100%" cellspacing="10" cellpadding="10" border="1" style="...">
        <tr>
            <td width="300" nowrap="nowrap" align="left">
                ID:
            </td>
            <td width="100%" align="left">
                <input type="text" readonly="readonly" name="id" value="<%=task.getId()%>"/>
            </td>
        </tr>
        <tr>
            <td align="left">
                NAME:
            </td>
            <td align="left">
                <input type="text" name="name" value="<%=task.getDescription()%>"/>
            </td>
        </tr>
        <tr>
            <td align="left">
                DESCRIPTION:
            </td>
            <td align="left">
                <input type="text" name="description" value="<%=task.getDescription()%>"/>
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
                <button class="gray" formaction="task-list">TASKS</button>
            </td>
            <td width="100%">&nbsp;</td>
        </tr>
    </table>
</form>

<jsp:include page="posfix.jsp" />
