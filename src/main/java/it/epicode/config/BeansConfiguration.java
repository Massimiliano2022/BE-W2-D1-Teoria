package it.epicode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import it.epicode.entities.BackendStudent;
import it.epicode.entities.FrontendStudent;
import it.epicode.entities.IStudent;
import it.epicode.entities.Interviewer;

@Configuration
public class BeansConfiguration {

	@Bean(name = "getNome")
	// Obbligatorio usarlo, altrimenti non mi troverà tali bean
	String name() {
		return "Giacomo";
	}

	@Bean
	int age() {
		return 20;
	}

	@Bean("aldo")
	IStudent fe() {
		return new FrontendStudent("Aldo");
	}

	@Bean("giovanni")
	@Primary
	// nel momento in cui creo il @Bean per Interviewer
	// siccome ho più bean di tipo IStudent non sa quale utilizzare per cui lo
	// definisco con @Primary
	IStudent be() {
		return new BackendStudent("Giovanni");
	}

	@Bean("giacomo")
	IStudent fe2() {
		return new FrontendStudent(name());
	}

	@Bean("ajeje")
	// @Scope("prototype")
	Interviewer interviewer(IStudent s) {
		return new Interviewer("Ajeje", s);
	}

}
