package model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import javax.xml.bind.annotation.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Film {
   public Film(int id, String title, int year, String director, String stars,
			String review) {

		super();
	   this.id = id;
	   this.title = title;
		this.year = year;
		this.director = director;
		this.stars = stars;
		this.review = review;
	}

	public Film(int id) {
	super();
	this.id = id;
}

	@com.google.gson.annotations.SerializedName("id")
	int id;
	@com.google.gson.annotations.SerializedName("title")
   String title;
	@com.google.gson.annotations.SerializedName("year")
   int year;
	@com.google.gson.annotations.SerializedName("director")
   String director;
	@com.google.gson.annotations.SerializedName("stars")
   String stars;
	@com.google.gson.annotations.SerializedName("review")
   String review;

	public Film(String title) {
		super();
		this.title=title;
	}

	public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}
public String getStars() {
	return stars;
}
public void setStars(String stars) {
	this.stars = stars;
}
public String getReview() {
	return review;
}
public void setReview(String review) {
	this.review = review;
}
@Override
public String toString() {
	return "Film [id=" + id + ", title=" + title + ", year=" + year
			+ ", director=" + director + ", stars=" + stars + ", review="
			+ review + "]";
}   
}
