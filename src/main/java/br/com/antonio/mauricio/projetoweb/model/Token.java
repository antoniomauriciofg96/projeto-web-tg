package br.com.antonio.mauricio.projetoweb.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

@JsonAutoDetect
@Entity
@Table(name = "token")
public class Token extends Observable implements Serializable {

	private static final long serialVersionUID = -7867857315781314247L;

	@JsonProperty("id")
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private int id;

	@JsonProperty("aluno")
	@OneToOne()
	@JoinColumn(name = "id_aluno", foreignKey = @ForeignKey(name = "fk_token_aluno"), unique = true)
	private Aluno aluno;

	@JsonProperty("token")
	@Column(name = "token", nullable = false)
	private String token;

	@JsonProperty("dataHoraCadastro")
	@Column(name = "data_hora_cadastro", nullable = false)
	private Date dataHoraCadastro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(Date dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	@Override
	public String toString() {
		return "Token [id=" + id + ", aluno=" + aluno + ", token=" + token + ", dataHoraCadastro=" + dataHoraCadastro
				+ "]";
	}

}
