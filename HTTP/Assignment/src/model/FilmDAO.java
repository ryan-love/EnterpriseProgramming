package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.*;
import javax.naming.NamingException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;




import java.util.ArrayList;
import java.util.List;


public class FilmDAO implements FilmAPI {




	Film oneFilm = null;
	boolean delete;
	boolean insert;
	boolean update;
	Connection connection;
	Statement statement;
	String user = "cbp25056";
	String password = "313+64bnkwc5lx90";
	// Note none default port used, 6306 not 3306
	String url = "jdbc:db2://dashdb-txn-sbox-yp-lon02-01.services.eu-gb.bluemix.net:50000/BLUDB" ;
	String title = null;




	private void openConnection () {
			// loading jdbc driver for mysql
			try {
				Class.forName("com.ibm.db2.jcc.DB2Driver");
			} catch (Exception e) {
				System.out.println(e);
			}

			// connecting to database
			try {
				// connection string for demos database, username demos, password demos
				Connection connection = DriverManager.getConnection(url,user,password);
				 Statement statement = connection.createStatement();
				System.out.println(connection);

			} catch (SQLException se) {
				System.out.println(se);
			}
		}
		private void closeConnection () {
			try {

				connection.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public Film getNextFilm (ResultSet rs){
			Film thisFilm = null;
			try {
				thisFilm = new Film(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getInt("year"),
						rs.getString("director"),
						rs.getString("stars"),
						rs.getString("review"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return thisFilm;
		}

		@Override
		public ArrayList<Film> getAllFilms () {

			ArrayList<Film> allFilms = new ArrayList<Film>();
			String selectSQL = "select * from films.films";
			// Create select statement and execute it
			try(Connection conn = DataSource.getConnection();
				PreparedStatement pst = conn.prepareStatement(selectSQL);
				ResultSet rs1 = pst.executeQuery();) {

				// Retrieve the results
				while (rs1.next()) {
					oneFilm = getNextFilm(rs1);
					allFilms.add(oneFilm);


				}

			} catch (SQLException se) {
				System.out.println(se);
			}



			return allFilms;
		}
		@Override
		public Film getFilmByID ( int id){

			oneFilm = null;
			String selectSQL = "select * from films.films where id=" + id;
			// Create select statement and execute it
			try (Connection conn = DataSource.getConnection();
				 PreparedStatement pst = conn.prepareStatement(selectSQL);
				 ResultSet rs1 = pst.executeQuery();){

				// Retrieve the results
				while (rs1.next()) {
					oneFilm = getNextFilm(rs1);
				}



			} catch (SQLException se) {
				System.out.println(se);
			}

			return oneFilm;
		}
		@Override
		public boolean deleteFilm (Film film) throws SQLException {
			String sql = "DELETE FROM films.films where id = ?";
			try (Connection conn = DataSource.getConnection();
				 PreparedStatement pst = conn.prepareStatement(sql);) {

				pst.setInt(1, film.getId());

				delete = pst.executeUpdate() > 0;


			} catch (SQLException se){
				System.out.println(se);
			}
			return delete;
		}
		@Override
		public boolean insertFilm (Film film) throws SQLException {
			String sql = "INSERT INTO films.films (id, title, year, director, stars,review) VALUES (?, ?, ?, ?, ?, ?)";
			try (Connection conn = DataSource.getConnection();
				 PreparedStatement pst = conn.prepareStatement(sql);) {
				pst.setInt(1, film.getId());
				pst.setString(2, film.getTitle());
				pst.setInt(3, film.getYear());
				pst.setString(4, film.getDirector());
				pst.setString(5, film.getStars());
				pst.setString(6, film.getReview());

				insert = pst.executeUpdate() > 0;
			} catch (SQLException se){
				System.out.println(se);
			}
			return insert;
		}
		@Override
		public boolean updateFilm (Film film) throws SQLException {
			String sql = "UPDATE films.films SET  title = ?, year = ?, director = ?, stars = ?, review = ? ";
			sql += " WHERE id = ?";

			try (Connection conn = DataSource.getConnection();
				 PreparedStatement pst = conn.prepareStatement(sql);) {
				pst.setString(1, film.getTitle());
				pst.setInt(2, film.getYear());
				pst.setString(3, film.getDirector());
				pst.setString(4, film.getStars());
				pst.setString(5, film.getReview());
				pst.setInt(6, film.getId());

				update = pst.executeUpdate() > 0;
			} catch (SQLException se){
				System.out.println(se);
			}
			return update;
		}
		@Override
		public ArrayList<Film> searchFilms(String title){
			ArrayList<Film> al = null;
			oneFilm = null;
			al= new ArrayList<>();
			String SQLsearch = "select * from films.films";
			try (Connection conn = DataSource.getConnection();
				 PreparedStatement pst = conn.prepareStatement(SQLsearch);){
					al= new ArrayList<>();

					if(title !=null && !title.equals("")){
						 SQLsearch = "select * from films.films where title like '%" + title + "%'";
					}
					ResultSet rs1 = pst.executeQuery(SQLsearch);
					// Retrieve the results
					int i = 0;
					while (rs1.next()) {

						oneFilm = getNextFilm(rs1);
						al.add(oneFilm);



						System.out.println("al :: " + al+ i);
						System.out.println(title);

					}
				} catch (SQLException se) {
					System.out.println(se);
				}
			return al;
			}

	}






