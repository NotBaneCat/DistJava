<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.seanlewis.game.model.GameItem" %><%--
    Template: Home Page
    Created By: Sean Lewis
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
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
                        List recs = (List)request.getAttribute("gameIsFeatured");
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
    <jsp:include page="footer.jsp" />
</html>
