package com.servico.backservico.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "servico")
@Data //O lombok que vai adicionar os get e set.
public class Servico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;
    
    @Column(nullable = true)
    private String descricaoServico;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "valorServico")
    private Double valorServico;

    // @Column(nullable = true)
    // private Double valorTotal;    

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoServico() {
        return this.descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        if(data == null){
            this.data = new Date();
        } else {
            this.data = data;
        }
    }

    public Double getValorServico() {
        return this.valorServico;
    }

    public void setValorServico(Double valorServico) {
        this.valorServico = valorServico;
    }

}
