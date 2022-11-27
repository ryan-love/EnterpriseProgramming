package com.restapi.ryan.film;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public interface FilmAPI {
   
    public Film getNextFilm (ResultSet rs);
    public ArrayList<Film> getAllFilms ();
    public boolean deleteFilm (String id) throws SQLException;
    public Film getFilmByID ( int id);
    public boolean insertFilm (Film film) throws SQLException;
    public boolean updateFilm (Film film) throws SQLException;
    public ArrayList<Film> searchFilms (String title);
    public int countFilms();




}

