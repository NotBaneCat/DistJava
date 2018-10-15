<%--
    Template: Form.jsp
    Created By: Sean Lewis
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Game Advice Home (HTML)</title>
    <jsp:include page="header.jsp" />
</head>
<body>
<h1 align="center">What Genre Do You Want To Search For?</h1>
<form class="form-genre" id="form1" name="form1" method="POST" action="gimme.genre">
    <p>Select game genre<p>
    <p>Genres:
        <!-- the name attribute is set to 'color' which is the
             parameter to be retrieved by the servlet -->
        <select id="games" name="games" size ="1">
            <option value="action">action</option>
            <option value="adventure">adventure</option>
        </select>
    </p>
    <center>
        <input id="beerSubmit" name="beerSubmit" type="submit" value="Get Advice">
    </center>
</form>
</body>

