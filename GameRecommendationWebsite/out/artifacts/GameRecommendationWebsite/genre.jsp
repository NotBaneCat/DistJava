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
<%@ page import="us.seanlewis.game.model.GameItem" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="header.jsp" />
</head>
<body>
<div class="main-container">
    <div class="main-inner">
        <h1>Welcome to my site!</h1>
    </div>
    <div>
        <h2 class="featured-home">Featured Games</h2>
                <form action="gimme.gimme">
            <%
                List recs = (List)request.getAttribute("gamesInGenre");
                Iterator it = recs.iterator();
                while(it.hasNext()) {
                    GameItem item = (GameItem) it.next();
                    out.print("<div class='parent'><div class='child'>" +
                            "<img src='" + item.getImage() + "' class='game-img'>" +
                            "<div class='buttons'>"+
                            "<div class='name'>" +
                            "<p>" + item.getName() + "</p>" +
                            "</div> " +
                            "<a href='description.jsp'><div class='desc'>" +
                            "<p>" + item.getDescription() + "</p>" +
                            "</div></a>" +
                            "<div class='cart'>Add to Cart<input type='checkbox' name='cartItem' " +
                            "value=" + item.getProductNumber() + ">" +
                            "</div></div></div>" +
                            "</div>");
                }
            %>
            <input type="submit" value="Purchase">
        </form>
    </div>
</div>
</body>
</html>

