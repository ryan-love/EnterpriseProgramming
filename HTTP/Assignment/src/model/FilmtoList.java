package model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(namespace = "com.ryanlove")
@XmlAccessorType(XmlAccessType.FIELD)
public class FilmtoList {
    @XmlElement(name = "film")
    private List<Film> films;

    public void setFilms(List<Film> films){
        this.films = films;
    }
    public List<Film> getFilms(){
        return films;
    }


    public FilmtoList(){
        super();
    }
}
