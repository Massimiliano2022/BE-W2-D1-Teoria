package it.epicode.entities;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Slf4j

@Component
public class FullstackStudent implements IStudent {
	// @Autowired
	private String nome;

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public void answerQuestion() {
		log.info("Ciao sono uno studente full stack e so tutto");
	}

}
