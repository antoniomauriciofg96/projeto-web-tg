package br.com.antonio.mauricio.projetoweb.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonAutoDetect
@Entity(name = "resposta_usuario")
public class RespostaUsuario implements Serializable {

	private static final long serialVersionUID = 8281562312417819620L;

	@JsonProperty("id")
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private Long id;

	@JsonProperty("aluno")
	@ManyToOne
	@JoinColumn(name = "id_aluno", foreignKey = @ForeignKey(name = "fk_aluno_resposta_usuario"))
	private Aluno aluno;

	@JsonProperty("pergunta")
	@ManyToOne
	@JoinColumn(name = "id_pergunta", foreignKey = @ForeignKey(name = "fk_pergunta_resposta_usuario"))
	private Pergunta pergunta;

	@JsonProperty("resposta")
	@Column(name = "resposta")
	private String resposta;

	@JsonProperty("correta")
	@Column(name = "correta", nullable = false)
	private boolean correta;

	@JsonProperty("data")
	@Column(name="data")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public boolean isCorreta() {
		return correta;
	}

	public void setCorreta(boolean correta) {
		this.correta = correta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RespostaUsuario [id=" + id + ", aluno=" + aluno + ", pergunta=" + pergunta + ", resposta=" + resposta
				+ ", correta=" + correta + ", data="+data+"]";
	}

}
