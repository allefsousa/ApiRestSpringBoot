package com.project.allef.apirest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity // anotacao pois a classe sera uma entidade no banco de dados
@Table(name = "Times")
public class Time {
    @Id// nome do campo no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // criando o auto increment do banco de dados
    private long codigo;
    @NotBlank // anotação para evitar notnull
    private String nomeTime;

    @NotBlank // anotação para evitar notnull
    private String principalJogador;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public String getPrincipalJogador() {
        return principalJogador;
    }

    public void setPrincipalJogador(String principalJogador) {
        this.principalJogador = principalJogador;
    }
}
