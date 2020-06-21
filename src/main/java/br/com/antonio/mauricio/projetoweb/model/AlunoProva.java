package br.com.antonio.mauricio.projetoweb.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@JsonAutoDetect
@Entity(name = "alunoprova")
public class AlunoProva implements Serializable {

    private static final long serialVersionUID = 8281562312417819620L;

    @JsonProperty("id")
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @JsonProperty("aluno")
    @ManyToOne
    @JoinColumn(name = "id_aluno", foreignKey = @ForeignKey(name = "fk_aluno_alunoprova"))
    private Aluno aluno;

    @JsonProperty("prova")
    @ManyToOne
    @JoinColumn(name = "id_prova", foreignKey = @ForeignKey(name = "fk_prova_alunoprova"))
    private Prova prova;

    @JsonProperty("usuarioProfessor")
    @ManyToOne
    @JoinColumn(name = "id_usuario_professor", referencedColumnName = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_usuario_alunoprova"))
    private User usuarioProfessor;

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

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public User getUsuarioProfessor() {
        return usuarioProfessor;
    }

    public void setUsuarioProfessor(User usuarioProfessor) {
        this.usuarioProfessor = usuarioProfessor;
    }

    @Override
    public String toString() {
        return "AlunoProva [id=" + id + ", aluno=" + aluno + ", prova=" + prova + ", usuarioProfessor="
                + usuarioProfessor + "]";
    }

}
