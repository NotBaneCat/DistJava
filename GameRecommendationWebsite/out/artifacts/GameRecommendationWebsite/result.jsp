<%--
  Template: Index Page
  Created by: Sean Lewis
--%>

<%--
  *This Result.jsp is where the controller sends it reponse
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="header.jsp" />
</head>
<body>
<h1 align="center">Game Recommendation (JSP)</h1>
<div class="result-container">
    <div class="result-inner">
        <h2>Reformat this page to contain images and desc. when clicked.</h2>
        <p>
                <%
                List recs = (List)request.getAttribute("gameRecommendations");
                Iterator it = recs.iterator();
                while(it.hasNext()) {
                    // Notice we're outputting some HTML. Is that a good idea?
                    // Also, notice we do not cast the object returned by the
                    // iterator to a String. Why?
                    out.print("<br>try: " + it.next());
                }
                %>
        <p><a href="form.jsp">Back</a>
    </div>
</div>




</body>
</html>

