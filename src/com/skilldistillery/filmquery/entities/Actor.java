package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Actor {
private int id;
String firstName;
String lastName;
private List<Film> films;




public Actor() {}

public Actor(int id, String fn, String ln, List<Film> films) {
this.id = id;
this.firstName = fn;
this.lastName = ln;
this.films = films;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}
public List<Film> getFilms() {
	return films;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public void setFilms(List<Film> films) {
	this.films = films;
}

@Override
public String toString() {
	return "Actor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Actor other = (Actor) obj;
	return id == other.id;
}




}
