package com.skilldistillery.filmquery.database;

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
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	@Override
	public Film findFilmById(int filmId) {
		return null;
	}

	public Actor findActorById(int actorId) {
		Actor actor = null;
		// ...
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, actorId);

		System.out.println(pstmt);

		ResultSet actorResult = pstmt.executeQuery();

		if (actorResult.next()) {
			actor = new Actor(); // Create the object

			// Here is our mapping of query columns to our object fields:

			actor.setId(actorResult.getInt("id"));
			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));
			actor.setFilms(findFilmByActorId(actorId));// an actor has films
		}
		// ... conn.close;

		return actor;
	}

	public Actor findActorById(int actorId) {
		Actor actor = null;
		// ...
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, actorId);
		ResultSet actorResult = pstmt.executeQuery();
		if (actorResult.next()) {
			actor = new Actor(); // Create the object
			// Here is our mapping of query columns to our object fields:
			actor.setId(actorResult.getInt("id"));
			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));
			actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films
		}
		// ...
			return actor;
	}

//	public List<Film> findFilmsByActorId(int actorId) {
//		List<Film> films = new ArrayList<>();
//		try {
//			Connection conn = DriverManager.getConnection(URL, user, pass);
//			String sql = "SELECT * FROM film JOIN film_actor ON film.id = film_actor.film_id "
//					+ " WHERE actor_id = ?";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, actorId);
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				int filmId = rs.getInt("id");
//				String title = rs.getString("title");
//				String desc = rs.getString("description");
//				short releaseYear = rs.getShort("release_year");
//				int langId = rs.getInt("language_id");
//				int rentDur = rs.getInt("rental_duration");
//				double rate = rs.getDouble("rental_rate");
//				int length = rs.getInt("length");
//				double repCost = rs.getDouble("replacement_cost");
//				String rating = rs.getString("rating");
//				String features = rs.getString("special_features");
//				Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
//						features);
//				films.add(film);
//			}
//			rs.close();
//			pstmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return films;
	}

}
