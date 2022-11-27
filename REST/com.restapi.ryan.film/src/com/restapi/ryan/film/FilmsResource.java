package com.restapi.ryan.film;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;



@Path("films")
public class FilmsResource {
	
	FilmDAO filmDAO = new FilmDAO();
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Film> getFilmsBrowser() {
		List<Film> films = new ArrayList<Film>();
		films = (List<Film>) filmDAO.getAllFilms();	
		return films; 
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Film> getFilms() {
		List<Film> films = new ArrayList<Film>();
		films = (List<Film>) filmDAO.getAllFilms();
		return films; 
	}

	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = filmDAO.countFilms();
		return String.valueOf(count);
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newFilm(
			@FormParam("id") String id,
			@FormParam("title") String title,
			@FormParam("year") String year,
			@FormParam("director") String director,
			@FormParam("stars") String stars,
			@FormParam("review") String review,
			@Context HttpServletResponse servletResponse
	) throws IOException, SQLException {
		Film film = new Film(Integer.parseInt(id), title, Integer.parseInt(year), director, stars, review);
		filmDAO.insertFilm(film);
		
		servletResponse.sendRedirect("../create_film.html");
	}
	
	@Path("{film}")
	public FilmResource getFilm(
			@PathParam("film") String id) {
		return new FilmResource(uriInfo, request, id);
	}
	
}
