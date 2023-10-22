package com.example.MeuProjeto.Models;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_Alunos") 
public class Aluno implements Serializable{

        private static final long serialVersionUID = 1L;
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; 
    private String nome;
    private BigDecimal nota;
    



    /**
     * @return UUID return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return BigDecimal return the nota
     */
    public BigDecimal getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

}


