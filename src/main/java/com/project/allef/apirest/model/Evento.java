package com.project.allef.apirest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity // anotacao pois a classe sera uma entidade no banco de dados
public class Evento {
    @Id// nome do campo no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // criando o auto increment do banco de dados
    private long codigo;
    @NotBlank // anotação para evitar notnull
    private String nome;
    @NotBlank // anotação para evitar notnull
    private String local;
    @NotBlank // anotação para evitar notnull
    private String data;
    @NotBlank // anotação para evitar notnull
    private String horario;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
