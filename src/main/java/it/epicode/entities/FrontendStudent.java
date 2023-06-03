package it.epicode.entities;

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
public class FrontendStudent implements IStudent {
	private String nome;

	@Override
	public void answerQuestion() {
		log.info("La risposta è blablabla...");
	}

}
