<%--
  Template: Index Page
  Created by: Sean Lewis
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
        <jsp:include page="scripts-and-links.jsp" />
        <div class="head-wrapper">
            <nav class="nav">
                <ul>
                    <li><a href="index.jsp" class = "">Home</a></li><span class="nav-spacer">|</span>
                    <li><a href="form.jsp" class= "">Browse</a></li><span class="nav-spacer">|</span>
                    <li><a href="gimme.cart" class="">Cart</a></li><span class="nav-spacer">|</span>
                    <li><label for="search" class="search">Search</label><input id="search" type="search" class="search-box" name="search"></li>
                </ul>
            </nav>
        </div>
</html>
