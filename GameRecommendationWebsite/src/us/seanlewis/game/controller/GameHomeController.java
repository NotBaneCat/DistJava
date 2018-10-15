package us.seanlewis.game.controller;

import us.seanlewis.game.model.GameItem;
import us.seanlewis.game.model.GameList;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.List;
import javax.servlet.RequestDispatcher;

public class GameHomeController extends HttpServlet {

    private final String RESULT_PAGE = "home.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Create a new instance of a model object
        GameList gameShop = new GameList();

        List<GameItem> result = gameShop.getFeaturedItemCatalog();

        // Parameters are read only Request object properties, but attributes
        // are read/write. We can use attributes to store data for use on
        // another page.
        request.setAttribute("gameIsFeatured", result);

        // This object lets you forward both the request and response
        // objects to a destination page
        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");


    }
}
