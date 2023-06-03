package it.epicode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.entities.FullstackStudent;
import it.epicode.entities.IStudent;
import it.epicode.entities.Interviewer;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class U2W1D1TeoriaApplication {

	public static void main(String[] args) {

		SpringApplication.run(U2W1D1TeoriaApplication.class, args);

		// FrontendStudent f = new FrontendStudent("Aldo");
		// BackendStudent b = new BackendStudent("Giovanni");

		// Interviewer i = new Interviewer("Riccardo", f);

		// i.askQuestion();

		// configWithConfigurationAnnotation();

		configWithComponent();
	}

	public static void configWithConfigurationAnnotation() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U2W1D1TeoriaApplication.class);

		log.info((String) ctx.getBean("getNome"));

		log.info(ctx.getBean("aldo").toString());
		log.info(ctx.getBean("giovanni").toString());
		log.info(ctx.getBean("giacomo").toString());

		log.info(ctx.getBean("ajeje").toString()); // nella classe BeanConfiguration ho definito un bean di tipo
													// IStudent come primary

		log.info(ctx.getBean(IStudent.class).toString());// allo stesso modo posso chiedere di creare un IStudent e
															// prenderà quello definito come Primary

		// Di default il comportamento dei bean è quello di essere unici
		// non importa quante volte io chieda di creare un oggetto partendo dallo stesso
		// bean
		// sarà sempre lo stesso oggetto
		// introduzione al concetto di singleton (singleton è definito di default ma
		// posso anche specificarlo)
		// esiste anche prototype e mi permette di creare oggetti diversi partendo dallo
		// stesso bean
		Interviewer i1 = ctx.getBean(Interviewer.class);
		Interviewer i2 = ctx.getBean(Interviewer.class);

		log.info("" + i1.hashCode());
		log.info("" + i2.hashCode());

		ctx.close();
	}

	public static void configWithComponent() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.scan("it.epicode");
		ctx.refresh();

		FullstackStudent f = ctx.getBean(FullstackStudent.class);
		// f.setNome("Brazof");

		log.info(f.toString());

		ctx.close();
	}

}
