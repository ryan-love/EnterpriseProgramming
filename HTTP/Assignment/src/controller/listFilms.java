package controller;


import model.Film;
import model.FilmDAO;
import com.google.gson.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet(
        urlPatterns = "/filmAPI",
        loadOnStartup = 1,
        asyncSupported = true
)
public class listFilms extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FilmDAO filmDAO;



    public void init(){
        filmDAO = new FilmDAO();
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String action = request.getServletPath();
        try {
            switch(action) {
                default:listFilm(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }

    }




    private void listFilm(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            List<Film> allFilms = filmDAO.getAllFilms();
            request.setAttribute("allFilms", allFilms);
        String format = request.getParameter("format");
        String out = null;

        if(format == null || "json".equals(format)){
            response.setContentType("application/json");
            out = "filmJSON.jsp";
        }
        if ("text".equals(format)){
            out = "filmText.jsp";
        }
        if("xml".equals(format)){
            response.setContentType("text/xml");
            out = "filmXML.jsp";

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(out);
        dispatcher.include(request, response);
    }

}
    

