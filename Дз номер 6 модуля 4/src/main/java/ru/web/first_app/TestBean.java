package ru.web.first_app;

public class TestBean {
	private String name; // Приватное строковое поле для хранения имени

	public TestBean(String name) { // Конструктор класса, устанавливающий значение имени
		this.name = name;
	}

	public String getName() { // Метод для получения имени
		return name;
	}

	public void setName(String name) { // Метод для установки нового значения имени
		this.name = name;
	}
}
