package com.restapi.ryan.film;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;


public class FilmResource {
	
	FilmDAO filmDAO = new FilmDAO();

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;
	Film ID;
	public FilmResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Film getFilm() {
		Film film = filmDAO.getFilmByID(Integer.parseInt(id));
		if(film==null)
			throw new RuntimeException("Get: Film with " + id + " not found");
		return film;
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Film getFilmHTML() {
		Film film = filmDAO.getFilmByID(Integer.parseInt(id));
		if(film==null)
			throw new RuntimeException("Get: Film with " + id + " not found");
		return film;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putFilm(JAXBElement<Film> film) throws SQLException {
		Film c = film.getValue();
		return putAndGetResponse(c);
	}
	
	@DELETE
	public void deleteFilm() throws SQLException {
		boolean c = filmDAO.deleteFilm(id);
		if(c==false)
			throw new RuntimeException("Delete: Film with " + id 
					+ " not found");
	}
	
	private Response putAndGetResponse(Film film) throws SQLException {
		Response res;
		int fid = film.getId();
		System.out.println(fid);
		if(fid != filmDAO.getFilmByID(fid).getId()) {
			res = Response.noContent().build();
		} else {
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}
		filmDAO.updateFilm(film);
		return res;
	}
}
