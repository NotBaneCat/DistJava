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
                            // Notice we're outputting some HTML. Is that a good idea?
                            // Also, notice we do not cast the object returned by the
                            // iterator to a String. Why?
                            out.print("<div class='parent'><div class='child'>" +
                                    "<img src='" + item.getImage() + "' class='game-img'>" +
                                    "<div class='buttons'>"+
                                    "<div class='name'>" +
                                    "<p>" + item.getName() + "</p>" +
                                    "</div> " +
                                    "<a href='description.jsp'><div class='desc'>" +
                                    "<p>" + item.getDescription() + "</p>" +
                                    "</div></a>" +
                                    "<a href='cart.jsp'><div class='cart'>" +
                                    "<p>Add To Cart</p>" +
                                    "</div></a></div></div>" +
                                    "</div>");
                        }
                    %>
            </form>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp" />
</html>
