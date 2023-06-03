package it.epicode.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@ToString
@Slf4j
public class Interviewer {

	public String nome;
	public IStudent student; // E' UNA DIPENDENZA

	public Interviewer(String nome, IStudent student) {
		this.nome = nome;
		this.student = student;
	}

	public void askQuestion() {
		log.warn("hey " + student.getNome() + " risolvimi questa challenge!");
		student.answerQuestion();
	}

}
