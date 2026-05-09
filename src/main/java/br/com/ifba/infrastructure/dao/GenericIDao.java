/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import java.util.List;

/**
 * Interface genérica para o padrão de projeto DAO (Data Access Object).
 * Define as operações essenciais de persistência para qualquer entidade do sistema.
 * O uso de Generics (<Entity>) permite que esta interface seja reutilizada por 
 * diferentes classes (Curso, Turma, etc.), garantindo tipagem segura e padronização.
 * * @author fabricio
 */
public interface GenericIDao<Entity>{
    /**
     * Salva uma nova entidade no banco de dados.
     * @param entity Objeto a ser persistido.
     * @return A entidade persistida.
     */
    Entity save(Entity entity);
    
    /**
     * Atualiza os dados de uma entidade já existente.
     * @param entity Objeto com os novos dados.
     * @return A entidade atualizada.
     */
    Entity update(Entity entity);
    
    /**
     * Remove uma entidade do banco de dados.
     * @param entity Objeto a ser removido.
     */
    void delete(Entity entity);
    
    /**
     * Recupera todos os registros da entidade cadastrados no banco.
     * @return Lista contendo todas as instâncias encontradas.
     */
    List<Entity> findAll();
    
    /**
     * Busca uma entidade específica através do seu identificador único.
     * @param id Chave primária do registro.
     * @return A entidade encontrada ou null caso não exista.
     */
    Entity findById(Long id);
}
