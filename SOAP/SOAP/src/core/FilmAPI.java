package core;

import java.sql.ResultSet;
import java.sql.SQLException;



public interface FilmAPI {
   
    public Film getNextFilm (ResultSet rs);
    public Film[] getAllFilms ();
    public boolean deleteFilm (Film film) throws SQLException;
    public Film getFilmByID ( int id);
    public boolean insertFilm (Film film) throws SQLException;
    public boolean updateFilm (Film film) throws SQLException;
    public Film[] searchFilms (String title);




}

