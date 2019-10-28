package be.afelio.software_academy.jpa.exercice.timesheets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestsFactory {

	private static ApplicationContext ctx
			= new AnnotationConfigApplicationContext(ApplicationConfig.class);
	
	public static TimesheetsRepository createTimesheetsRepository() {
		TimesheetsRepository repository = ctx.getBean(TimesheetsRepository.class);
		return repository;
	}
}
