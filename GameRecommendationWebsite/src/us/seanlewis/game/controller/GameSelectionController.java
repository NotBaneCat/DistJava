package us.seanlewis.game.controller;

import us.seanlewis.game.model.GameExpert;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.List;
import javax.servlet.RequestDispatcher;

public class GameSelectionController extends HttpServlet {
    private static final String RESULT_PAGE = "result.jsp";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        // parameters are name attributes in view pages
        // Here we're retrieving form content from form.jsp
        String formSelectName = request.getParameter("games");

        // Create a new instance of a model object
        // For some applications, we would not want to create a new one each time.
        GameExpert be = new GameExpert();
        // Always a good idea to trim and/or validate input data
        List result = be.getGames(formSelectName.trim());

        // Parameters are read only Request object properties, but attributes
        // are read/write. We can use attributes to store data for use on
        // another page.
        request.setAttribute("gameRecommendations", result);

        // This object lets you forward both the request and response
        // objects to a destination page
        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }
}
