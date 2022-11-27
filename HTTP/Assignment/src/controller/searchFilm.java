package controller;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Film;
import model.FilmDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

public class searchFilm extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private FilmDAO filmDAO;

        public void init() {
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
                switch (action) {

                    default:
                        searchFilm(request, response);
                }
            } catch (IOException | JAXBException e) {
                throw new ServletException(e);
            }

        }


        private void searchFilm(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException, JAXBException {
            String title = request.getParameter("title");
            String format = request.getParameter("format");
            ArrayList<Film> search = filmDAO.searchFilms(title);
            request.setAttribute("search", search);
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


