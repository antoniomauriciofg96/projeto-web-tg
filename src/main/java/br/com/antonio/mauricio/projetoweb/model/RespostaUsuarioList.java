package br.com.antonio.mauricio.projetoweb.model;

import java.util.List;

public class RespostaUsuarioList {

	private List<RespostaUsuario> respostas;

	public List<RespostaUsuario> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaUsuario> respostas) {
		this.respostas = respostas;
	}

	@Override
	public String toString() {
		return "RespostaUsuarioList [respostas=" + respostas + "]";
	}

}
