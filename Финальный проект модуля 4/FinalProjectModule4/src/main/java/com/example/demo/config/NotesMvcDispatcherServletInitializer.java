package com.example.demo.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class NotesMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// Возвращает конфигурационные классы для корневого контекста
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	// Возвращает конфигурационные классы для сервлета
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { NotesConfig.class };
	}

	// Возвращает URL-мэппинг для сервлета
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	// Выполняет настройку сервлета при запуске
	public void onStartup(ServletContext aServletContext) throws ServletException {
		super.onStartup(aServletContext);
		registerHiddenFieldFilter(aServletContext);
	}

	// Регистрирует фильтр для скрытых HTTP-методов
	private void registerHiddenFieldFilter(ServletContext aContext) {
		aContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true,
				"/*");
	}

}
