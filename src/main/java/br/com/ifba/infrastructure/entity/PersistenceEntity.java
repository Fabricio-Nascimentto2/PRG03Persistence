/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Classe base para todas as entidades persistentes do sistema.
 * A anotação @MappedSuperclass indica ao JPA que esta classe não será uma tabela própria,
 * mas seus atributos (como o ID) serão herdados e mapeados nas tabelas das classes filhas.
 * Isso garante que todas as entidades tenham um identificador único padronizado.
 * * @author fabricio
 */
@MappedSuperclass
public class PersistenceEntity {
    /**
     * Identificador único da entidade (Chave Primária).
     * Gerado automaticamente pelo banco de dados (estratégia IDENTITY),
     * garantindo a integridade e unicidade dos registros.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Métodos de acesso (Getters e Setters)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
