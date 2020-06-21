package br.com.antonio.mauricio.projetoweb.model;

import org.springframework.stereotype.Component;

@Component
public class UserSession {

	private String token;
	private Aluno aluno;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "UserSession [token=" + token + ", aluno=" + aluno + "]";
	}

}
