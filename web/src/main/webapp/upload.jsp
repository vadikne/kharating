<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>File Upload</title>
</head>
<html>

<%! private boolean loggedIn; %>

<%
    String login = request.getParameter("login");
    String password = request.getParameter("password");

    if ("user".equals(login) && "1234".equals(password))
        loggedIn = true;
    else
        loggedIn = false;

    if ( ! loggedIn) {
%>

<form action="upload.jsp" method="POST">
    <input type="text" name="login"><br>
    <input type="text" name="password"><br>
    <button>Send</button>
</form>

<% } else { %>

<form method="post" action="uploadFile" enctype="multipart/form-data">
    Select file to upload:
    <input type="file" name="uploadFile" accept=".xml"/>
    <br/><br/>
    <input type="submit" value="Upload" />
</form>

<% } %>

</html>