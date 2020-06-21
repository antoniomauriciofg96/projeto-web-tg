package br.com.antonio.mauricio.projetoweb.model;

import br.com.antonio.mauricio.projetoweb.utils.PerguntaConstantes;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

@JsonAutoDetect
@Entity(name = "pergunta")
public class Pergunta implements Serializable {

    private static final long serialVersionUID = 8281562312417819620L;

    @JsonProperty("id")
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @JsonProperty("texto")
    @Column(name = "texto", nullable = false, length = 255)
    @NotBlank(message = PerguntaConstantes.MSG_ERRO_TEXTO_INVALIDO)
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_prova", foreignKey = @ForeignKey(name = "fk_prova_pergunta"))
    private Prova prova;

    @JsonProperty("alternativaCorreta")
    @Column(name = "alternativaCorreta", nullable = false, length = 10)
    private String alternativaCorreta;

    @JsonProperty("alternativaAuxiliar1")
    @Column(name = "alternativaAuxiliar1", nullable = false, length = 10)
    private String alternativaAuxiliar1;

    @JsonProperty("alternativaAuxiliar2")
    @Column(name = "alternativaAuxiliar2", nullable = false, length = 10)
    private String alternativaAuxiliar2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public String getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(String alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    public String getAlternativaAuxiliar1() {
        return alternativaAuxiliar1;
    }

    public void setAlternativaAuxiliar1(String alternativaAuxiliar1) {
        this.alternativaAuxiliar1 = alternativaAuxiliar1;
    }

    public String getAlternativaAuxiliar2() {
        return alternativaAuxiliar2;
    }

    public void setAlternativaAuxiliar2(String alternativaAuxiliar2) {
        this.alternativaAuxiliar2 = alternativaAuxiliar2;
    }

    @Override
    public String toString() {
        return "Pergunta [id=" + id + ", texto=" + texto + ", prova=" + prova + ", alternativaCorreta="
                + alternativaCorreta + ", alternativaAuxiliar1=" + alternativaAuxiliar1 + ", alternativaAuxiliar2="
                + alternativaAuxiliar2 + "]";
    }

}
