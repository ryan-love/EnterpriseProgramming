package controller;


import model.Film;
import model.FilmDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class createFilms extends HttpServlet {
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
                default:createFilms(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }

    }

    private void createFilms(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        int year = Integer.parseInt(request.getParameter("year"));
        String director = request.getParameter("director");
        String stars = request.getParameter("stars");
        String review = request.getParameter("review");


        Film newFilm = new Film(id,title, year, director,stars,review);
        filmDAO.insertFilm(newFilm);
        response.sendRedirect("GUI");
    }

    }
