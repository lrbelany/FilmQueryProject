package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp extends DatabaseAccessorObject {

	public FilmQueryApp() throws ClassNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	DatabaseAccessorObject daObj = new DatabaseAccessorObject();
	DatabaseAccessor db = new DatabaseAccessorObject();
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		FilmQueryApp app = new FilmQueryApp();

		app.launch();
	}

	// private void test() throws SQLException {
	// Film film = db.findFilmById(1);
	//
	// }

	private void launch() throws ClassNotFoundException, SQLException {

		startUserInterface(input);

		input.close();
	}

	private void menuDisplay() {
		System.out.println("\n------Cinema Explorer------");
		System.out.println(" Please Make a Selection (1-3) ");
		System.out.println("1. Find Film By ID");
		System.out.println("2. Find Film By Keyword");
		System.out.println("3. Exit");
	}

	private boolean menuSelect(Scanner input) throws ClassNotFoundException {
		try {
			int choice = input.next().charAt(0);
			switch (choice) {
			case '1':
				System.out.println("Please enter a film id between 1 and 1000.");
				choice = input.nextInt();

				Film filmSearchId = daObj.findFilmById(choice);
				System.out.println("\nTitle: " + filmSearchId.getTitle() + "\n\nRelease year: "
						+ filmSearchId.getReleaseYear() + "\n\nRating : " + filmSearchId.getRating() + "\n\nLanguage : "
						+ filmSearchId.getLanguage() + "\n\nDescription : " + filmSearchId.getDescrption());
				startUserInterface(input);

				break;

			case '2':
				System.out.println("Please enter a key word to search for a movie.");

				String keyWord = input.next();
				List<Film> searchKeyWord = new ArrayList<Film>();
				List<Actor> cast = new ArrayList<Actor>();
				searchKeyWord = daObj.findFilmByKeyWord(keyWord);
				if(searchKeyWord.size()== 0) {
					System.out.println("No films were found containing that word, please try another word");
				}
				else {
					
				for(Film film : searchKeyWord) {
					 System.out.println(film);
					for(Actor actor : cast) {
						System.out.print(actor);
					}
					}
				startUserInterface(input);
				}
				
				break;
			case '3':
				System.out.println("Bye Bye");
				System.exit(choice);
				break;
			default:
				System.err.println("\nInvalid Menu Selection. Try again.\n");
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	private void startUserInterface(Scanner input) throws ClassNotFoundException, SQLException {
		try {
			boolean loop = false;

			do {
				menuDisplay();
				loop = menuSelect(input);

			} while (loop);

		} catch (NullPointerException e) {
			System.out.println("please make a valid selection (1-1000)");
		}catch (InputMismatchException e) {
			startUserInterface(input);
			System.out.println("That wasn't very nice...don't do that. Let's start over and make valid selections");
		}
	}
}
