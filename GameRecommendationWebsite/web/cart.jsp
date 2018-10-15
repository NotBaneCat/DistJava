<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="us.seanlewis.game.model.GameItem" %><%--
  Template: Cart Page
  Created by: Sean Lewis
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
        <form action="gimme.bill">
            <table>
                <%
                    List recs = (List) request.getAttribute("catalog");
                    Iterator it = recs.iterator();
                    double total = 0;
                    while (it.hasNext()) {
                        GameItem item = (GameItem) it.next();
                        out.print("<tr class='purch'><td> " + item.getName() + " </td><td>" +
                                String.format("$%3.2f",item.getPrice()) + "</td></tr>");
                        total+=item.getPrice();
                    }
                    out.print("<tr class='total' ><td>Total:</td><td>" +
                            String.format("$%3.2f",total) + "</td></tr>");
                %>
            </table>
            <input type="submit" value="Complete">
        </form>
    </div>
</div>
</body>
<jsp:include page="footer.jsp" />
</html>

