package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {

private int id;
private String title;
private String descrption;
private short releaseYear;
private int rentalDuration;
private double rentalRate;
private int length;
private double replacementCost;
private String rating;
private String specialFeatures;
private List<Actor> actors;

public Film() {}

public Film(int id, String title, String description, short releaseYear, int rentalDuration, double rentalRate, int length, double replacementCost, String rating, String specialFeatures, List<Actor> actors ) {
	this.id = id;
	this.title = title;
	this.descrption = description;
	this.releaseYear = releaseYear;
	this.rentalDuration = rentalDuration;
	this.rentalRate = rentalRate;
	this.length = length;
	this.replacementCost = replacementCost;
	this.rating = rating;
	this.specialFeatures = specialFeatures;
    this.actors = actors;
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

public String getDescrption() {
	return descrption;
}

public void setDescrption(String descrption) {
	this.descrption = descrption;
}

public short getReleaseYear() {
	return releaseYear;
}

public void setReleaseYear(short releaseYear) {
	this.releaseYear = releaseYear;
}

public int getRentalDuration() {
	return rentalDuration;
}

public void setRentalDuration(int rentalDuration) {
	this.rentalDuration = rentalDuration;
}

public double getRentalRate() {
	return rentalRate;
}

public void setRentalRate(double rentalRate) {
	this.rentalRate = rentalRate;
}

public int getLength() {
	return length;
}

public void setLength(int length) {
	this.length = length;
}

public double getReplacementCost() {
	return replacementCost;
}

public List<Actor> getActors() {
	return actors;
}

public void setActors(List<Actor> actors) {
	this.actors = actors;
}

public void setReplacementCost(double replacementCost) {
	this.replacementCost = replacementCost;
}

public String getRating() {
	return rating;
}

public void setRating(String rating) {
	this.rating = rating;
}

public String getSpecialFeatures() {
	return specialFeatures;
}

public void setSpecialFeatures(String specialFeatures) {
	this.specialFeatures = specialFeatures;
}

@Override
public String toString() {
	return "Film [id=" + id + ", title=" + title + ", descrption=" + descrption + ", releaseYear=" + releaseYear
			+ ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate + ", length=" + length
			+ ", replacementCost=" + replacementCost + ", rating=" + rating + ", specialFeatures=" + specialFeatures
			+ ", actors=" + actors + "]";
}

@Override
public int hashCode() {
	return Objects.hash(actors, descrption, id, length, rating, releaseYear, rentalDuration, rentalRate,
			replacementCost, specialFeatures, title);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Film other = (Film) obj;
	return Objects.equals(actors, other.actors) && Objects.equals(descrption, other.descrption) && id == other.id
			&& length == other.length && Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
			&& rentalDuration == other.rentalDuration
			&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
			&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
			&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
}

}
