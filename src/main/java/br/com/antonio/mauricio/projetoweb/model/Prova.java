package br.com.antonio.mauricio.projetoweb.model;

import br.com.antonio.mauricio.projetoweb.utils.ProvaConstantes;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

@JsonAutoDetect
@Entity(name = "prova")
public class Prova implements Serializable {

    private static final long serialVersionUID = 8281562312417819620L;

    @JsonProperty("id")
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @JsonProperty("titulo")
    @Column(name = "titulo", nullable = false, length = 300)
    @NotBlank(message = ProvaConstantes.MSG_ERRO_TITULO_INVALIDO)
    private String titulo;

    @JsonProperty("idTipo")
    @Column(name = "id_tipo", nullable = false)
    @NotNull(message = ProvaConstantes.MSG_ERRO_TIPO_INVALIDO)
    private Integer idTipo;

    @JsonProperty("descricao")
    @Column(name = "descricao", nullable = true)
    private String descricao;

    @JsonProperty("data")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = ProvaConstantes.MSG_ERRO_DATA_INVALIDA)
    private Date data;

    @JsonProperty("usuario")
    @ManyToOne
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_usuario_prova"))
    private User usuario;

    public Prova() {
        TimeZone timeZone = TimeZone.getTimeZone("America/Sao_Paulo");
        LocalDateTime localDateTime = new LocalDateTime(DateTimeZone.forID(timeZone.getID()));
        data = localDateTime.toDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Prova [id=" + id + ", titulo=" + titulo + ", idTipo=" + idTipo + ", descricao=" + descricao + ", data="
                + data + ", usuario=" + usuario + "]";
    }

}
