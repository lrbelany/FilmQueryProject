package com.skilldistillery.filmquery.database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	String user = "student";
	String pwd = "student";
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	public DatabaseAccessorObject() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Film film = new Film();

		String sql = "SELECT film.*, language.name FROM film JOIN language ON film.language_id = language.id WHERE film.id = ?";
		Connection conn = DriverManager.getConnection(URL, user, pwd);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, filmId);
		ResultSet filmResult = pstmt.executeQuery();
		if (filmResult.next()) {
			film = new Film(); // Create the object
			// Here is our mapping of query columns to our object fields:
			film.setFilmId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setDescrption(filmResult.getString("description"));
			film.setReleaseYear(filmResult.getShort("release_year"));
			film.setRentalDuration(filmResult.getInt("rental_duration"));
			film.setRentalRate(filmResult.getDouble("rental_rate"));
			film.setLength(filmResult.getInt("length"));
			film.setReplacementCost(filmResult.getDouble("replacement_cost"));
			film.setRating(filmResult.getString("rating"));
			film.setSpecialFeatures(filmResult.getString("special_features"));
			film.setLanguage(filmResult.getString("name"));
		} else if (filmResult.wasNull()) {
			film.setFilmId(filmResult.getInt("Invalid Selection"));
			film.setTitle(filmResult.getString("Invalid Selection"));
			film.setDescrption(filmResult.getString("Invalid Selection"));
			film.setReleaseYear(filmResult.getShort("Invalid Selection"));
			film.setRentalDuration(filmResult.getInt("Invalid Selection"));
			film.setRentalRate(filmResult.getDouble("Invalid Selection"));
			film.setLength(filmResult.getInt("Invalid Selection"));
			film.setReplacementCost(filmResult.getDouble("Invalid Selection"));
			film.setRating(filmResult.getString("Invalid Selection"));
			film.setSpecialFeatures(filmResult.getString("Invalid Selection"));
			film.setLanguage(filmResult.getString("Invalid Selection"));
		}

		filmResult.close();
		conn.close();
		return film;
	}

	public Actor findActorById(int actorId) throws SQLException {
		Actor actor = new Actor();
		// ...
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";

		// String user = "student";
		// String pwd = "student";

		Connection conn = DriverManager.getConnection(URL, user, pwd);

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, actorId);

		ResultSet actorResult = pstmt.executeQuery();

		if (actorResult.next()) {
			actor = new Actor(); // Create the object

			// Here is our mapping of query columns to our object fields:

			actor.setId(actorResult.getInt("id"));
			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));
//			actor.setFilms(findFilmByActorId(actorId));// an actor has films
		}
		actorResult.close();
		conn.close();
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub

		return null;
	}

	public List<Film> findFilmByKeyWord(String keyWord) throws SQLException {
		List<Film> searchKeyWord = new ArrayList<>();
		Connection conn = DriverManager.getConnection(URL, user, pwd);
		String sql = "SELECT film.*, language.name FROM film JOIN language ON film.language_id = language.id WHERE title LIKE ? OR description LIKE ?";
		//String sql = "SELECT * FROM film WHERE film.title LIKE ? OR film.description LIKE ?";
		// "select film.*, language.name from film join language on film.language_id =
		// language.id where title like ? or description like ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + keyWord + "%");
		pstmt.setString(2, "%" + keyWord + "%");
		ResultSet keyWordResult = pstmt.executeQuery();
		while (keyWordResult.next()) {
			Film film = new Film();
			film.setFilmId(keyWordResult.getInt("id"));
			film.setTitle(keyWordResult.getString("title"));
			film.setDescrption(keyWordResult.getString("description"));
			film.setReleaseYear(keyWordResult.getShort("release_year"));
			film.setRentalDuration(keyWordResult.getInt("rental_duration"));
			film.setRentalRate(keyWordResult.getDouble("rental_rate"));
			film.setLength(keyWordResult.getInt("length"));
			film.setReplacementCost(keyWordResult.getDouble("replacement_cost"));
			film.setRating(keyWordResult.getString("rating"));
			film.setSpecialFeatures(keyWordResult.getString("special_features"));
			film.setLanguage(keyWordResult.getString("name"));
			searchKeyWord.add(film);
		}
		keyWordResult.close();
		conn.close();
		return searchKeyWord;
	}

	public List<Film> findFilmsByActorId(int actorId) {
		try {
			List<Film> films = new ArrayList<Film>();

			Film film = new Film();

			Connection conn = DriverManager.getConnection(URL, user, pwd);
			String sql = "SELECT * FROM film JOIN film_actor ON film.id = film_actor.film_id " + " WHERE actor_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, actorId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int rentalDuration = rs.getInt("rental_duration");
				double rentalRate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double replacementCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String specialFeatures = rs.getString("special_features");
				String language = rs.getString("language");
				String actors = rs.getString("actors");
				films.add(film);
			}
			rs.close();
			pstmt.close();
			conn.close();
			return films;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
