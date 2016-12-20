package com.hand.entity;

public class Filmlang {
	private Film film;
	private Language language;
	public Filmlang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Filmlang(Film film, Language language) {
		super();
		this.film = film;
		this.language = language;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}

}
