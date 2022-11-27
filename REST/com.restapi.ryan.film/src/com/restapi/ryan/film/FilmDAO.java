package com.restapi.ryan.film;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;



public class FilmDAO implements FilmAPI, Serializable {




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Film oneFilm = null;
	Connection connection = null;
	Statement statement = null;
	String user = "lovery";
	String password = "yegert7Wa";
	// Note none default port used, 6306 not 3306
	String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/" + user ;
	String title = null;



	
		private void openConnection () {
			// loading jdbc driver for mysql
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception e) {
				System.out.println(e);
			}

			// connecting to database
			try {
				// connection string for demos database, username demos, password demos
				connection = DriverManager.getConnection(url, user, password);
				statement = connection.createStatement();
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
			openConnection();

			// Create select statement and execute it
			try {
				String selectSQL = "select * from film";
				ResultSet rs1 = statement.executeQuery(selectSQL);
				// Retrieve the results
				while (rs1.next()) {
					oneFilm = getNextFilm(rs1);
					allFilms.add(oneFilm);
				}

				statement.close();
				closeConnection();
			} catch (SQLException se) {
				System.out.println(se);
			}

			return allFilms;
		}
		@Override
		public Film getFilmByID ( int id){

			openConnection();
			oneFilm = null;
			// Create select statement and execute it
			try {
				String selectSQL = "select * from film where id=" + id;
				ResultSet rs1 = statement.executeQuery(selectSQL);
				// Retrieve the results
				while (rs1.next()) {
					oneFilm = getNextFilm(rs1);
				}

				statement.close();
				closeConnection();
			} catch (SQLException se) {
				System.out.println(se);
			}

			return oneFilm;
		}
		@Override
		public boolean deleteFilm (String id) throws SQLException {
			String sql = "DELETE FROM film where id ="+ id;
			openConnection();

			PreparedStatement statement = connection.prepareStatement(sql);

			boolean rowDeleted = statement.executeUpdate() > 0;
			statement.close();
			closeConnection();
			return rowDeleted;
		}
		@Override
		public boolean insertFilm (Film film) throws SQLException {
			String sql = "INSERT INTO film (id, title, year, director, stars,review) VALUES (?, ?, ?, ?, ?, ?)";
			openConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, film.getId());
			statement.setString(2, film.getTitle());
			statement.setInt(3, film.getYear());
			statement.setString(4, film.getDirector());
			statement.setString(5, film.getStars());
			statement.setString(6, film.getReview());

			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			closeConnection();
			return rowInserted;
		}
		@Override
		public boolean updateFilm (Film film) throws SQLException {
			String sql = "UPDATE film SET  title = ?, year = ?, director = ?, stars = ?, review = ? ";
			sql += " WHERE id = ?";
			openConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, film.getTitle());
			statement.setInt(2, film.getYear());
			statement.setString(3, film.getDirector());
			statement.setString(4, film.getStars());
			statement.setString(5, film.getReview());
			statement.setInt(6, film.getId());

			boolean rowUpdated = statement.executeUpdate() > 0;
			statement.close();
			closeConnection();
			return rowUpdated;
		}
		@Override
		public ArrayList<Film> searchFilms(String title){
			openConnection();
			ArrayList<Film> al = null;
			oneFilm = null;

				try {
					al= new ArrayList<>();
					String SQLsearch = "select * from film";
					if(title !=null && !title.equals("")){
						 SQLsearch = "select * from film where title like '%" + title + "%'";
					}
					ResultSet rs1 = statement.executeQuery(SQLsearch);
					// Retrieve the results
					int i = 0;
					while (rs1.next()) {

						oneFilm = getNextFilm(rs1);
						al.add(oneFilm);



						System.out.println("al :: " + al+ i);
						System.out.println(title);

					}
					statement.close();
					closeConnection();
				} catch (SQLException se) {
					System.out.println(se);
				}
			return al;
			}
		
		public int countFilms(){
			   
			int count = 0;
			
			openConnection();
			
		 
			try{
			    String selectSQL = "select count(*) from films";
			    ResultSet rs1 = statement.executeQuery(selectSQL);
			    while(rs1.next()){
			    	count = rs1.getInt("count(*)");
			   }
			    statement.close();
			    closeConnection();
			} catch(SQLException se) { 
				System.out.println(se); 
			}
		   return count;
	  }

	}






