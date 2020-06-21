package br.com.antonio.mauricio.projetoweb.model;

import br.com.antonio.mauricio.projetoweb.utils.AlunoConstantes;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

@JsonAutoDetect
@Entity(name = "aluno")
public class Aluno implements Serializable {

    private static final long serialVersionUID = 8281562312417819620L;

    @JsonProperty("id")
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @JsonProperty("chaveAluno")
    @Column(name = "chaveAluno", nullable = false, length = 300)
    @NotBlank(message = AlunoConstantes.MSG_ERRO_CHAVE_ALUNO)
    private String chaveAluno;

    @JsonProperty("nomeAluno")
    @Column(name = "nomeAluno", nullable = false, length = 300)
    @NotBlank(message = AlunoConstantes.MSG_ERRO_NOME_ALUNO)
    private String nomeAluno;

    @JsonProperty("usuarioProfessor")
    @ManyToOne
    @JoinColumn(name = "id_usuario_professor", foreignKey = @ForeignKey(name = "fk_usuario_aluno"))
    private User usuarioProfessor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChaveAluno() {
        return chaveAluno;
    }

    public void setChaveAluno(String chaveAluno) {
        this.chaveAluno = chaveAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public User getUsuarioProfessor() {
        return usuarioProfessor;
    }

    public void setUsuarioProfessor(User usuarioProfessor) {
        this.usuarioProfessor = usuarioProfessor;
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", chaveAluno=" + chaveAluno + ", nomeAluno=" + nomeAluno + ", usuarioProfessor="
                + usuarioProfessor + "]";
    }

}
