package us.seanlewis.game.controller;

import us.seanlewis.game.model.GameItem;
import us.seanlewis.game.model.GameList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GenreController extends HttpServlet {
    private static final String RESULT_PAGE = "genre.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String selectGenreName = request.getParameter("games");


        // Create a new instance of a model object
        // For some applications, we would not want to create a new one each time.
        GameList gameList = new GameList();
        // Always a good idea to trim and/or validate input data
        List<GameItem> result = gameList.getItemGenre(selectGenreName);

        // Parameters are read only Request object properties, but attributes
        // are read/write. We can use attributes to store data for use on
        // another page.
        request.setAttribute("gamesInGenre", result);

        Cookie genre = new Cookie("genre", selectGenreName);
        genre.setMaxAge(60*60*24);
        response.addCookie(genre);
        // Set expiry date after 24 Hrs for both the cookies.


        // This object lets you forward both the request and response
        // objects to a destination page
        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }
}
