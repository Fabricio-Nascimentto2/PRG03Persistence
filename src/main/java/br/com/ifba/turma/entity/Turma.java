/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.turma.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Entidade que representa uma Turma no sistema.
 * Ao herdar de PersistenceEntity, esta classe utiliza o mapeamento genérico de 
 * identificação (ID), seguindo os padrões de persistência definidos na infraestrutura.
 * Implementa Serializable para permitir a correta transmissão e armazenamento de estados.
 * * @author fabricio
 */
@Entity
public class Turma extends PersistenceEntity implements Serializable {  
    private String nome;
    private String codigo;
    
    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o código identificador da turma.
     * @return String contendo o código.
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }   
    
}
