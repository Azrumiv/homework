package com.example.demo.dao;

import com.example.demo.models.WebNote;

import java.util.ArrayList;
import java.util.List;

public class WebNoteDAO {
	private static int NOTES_COUNT;
	private final List<WebNote> notes;

	public WebNoteDAO() {
		// Конструктор класса, инициализирующий список заметок и добавляющий пять заметок по умолчанию.
		notes = new ArrayList<>();

		notes.add(new WebNote(++NOTES_COUNT, "note1"));
		notes.add(new WebNote(++NOTES_COUNT, "note2"));
		notes.add(new WebNote(++NOTES_COUNT, "note3"));
		notes.add(new WebNote(++NOTES_COUNT, "note4"));
		notes.add(new WebNote(++NOTES_COUNT, "note5"));
	}

	public List<WebNote> index() {
		// Метод возвращает список всех заметок.
		return notes;
	}

	public WebNote show(int id) {
		// Метод позволяет найти заметку по заданному ID.
		return notes.stream().filter(n -> n.getId() == id).findAny().orElse(null);
	}

	public void save(WebNote webNote) {
		// Метод для добавления новой заметки в список.
		notes.add(webNote);
	}

	public void update(int id, String note) {
		// Метод для обновления текста заметки по её ID.
		WebNote toUpdateNote = show(id);
		toUpdateNote.setNote(note);
	}

	public void delete(int id) {
		// Метод удаляет заметку по её ID.
		notes.removeIf(n -> n.getId() == id);
	}
}
