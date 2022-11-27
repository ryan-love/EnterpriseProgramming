package model;

import javax.xml.bind.annotation.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(namespace = "com.ryanlove")
@XmlAccessorType(XmlAccessType.FIELD)
public interface FilmAPI {
    @XmlElementWrapper(name="films")
    @XmlElement(name="film")
    public Film getNextFilm (ResultSet rs);
    public ArrayList<Film> getAllFilms ();
    public boolean deleteFilm (Film film) throws SQLException;
    public Film getFilmByID ( int id);
    public boolean insertFilm (Film film) throws SQLException;
    public boolean updateFilm (Film film) throws SQLException;
    public ArrayList<Film> searchFilms (String title);




}

