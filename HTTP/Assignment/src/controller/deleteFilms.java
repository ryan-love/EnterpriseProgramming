package controller;

import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import model.Film;
import model.FilmDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deleteFilms extends HttpServlet {
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
                default:deleteFilm(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }

    }
    private void deleteFilm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Film removeFilm = new Film(id);
        filmDAO.deleteFilm(removeFilm);
        response.sendRedirect("GUI");

    }


}
