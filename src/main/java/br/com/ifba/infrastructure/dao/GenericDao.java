/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Implementação base e genérica para todos os DAOs do sistema.
 * Esta classe utiliza Generics (<Entity>) e reflexão (persistentClass) para 
 * fornecer operações de CRUD automatizadas para qualquer entidade JPA, 
 * centralizando a gestão de transações e o uso do EntityManager.
 * * @author fabricio
 */
public abstract class GenericDao<Entity> implements GenericIDao<Entity> {
    protected static EntityManager entityManager;
    private final Class<Entity> persistentClass;
    
    /**
     * Construtor que recebe a classe da entidade.
     * Necessário para que o JPA saiba qual tipo de objeto manipular nas consultas genéricas.
     * @param persistentClass A classe da entidade (ex: Curso.class).
     */

    public GenericDao(Class<Entity> persistentClass) {
        this.persistentClass = persistentClass;
    }
    
    // Bloco estático para inicializar a fábrica de gerenciamento de entidades
    static {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("prg03presistencia");
        entityManager = factory.createEntityManager();
    }

    //persiste uma nova entidade no banco de dados
    @Override
    public Entity save(Entity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    // atualiza uma entidade existente 
    @Override
    public Entity update(Entity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    /**
     * Remove uma entidade do banco de dados.
     * Utiliza o merge para garantir que o objeto esteja no estado "managed" antes da remoção.
     */
    @Override
    public void delete(Entity entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(entity));
        entityManager.getTransaction().commit();
    }

    /**
     * Busca uma entidade pelo seu identificador único (ID).
     */
    @Override
    public Entity findById(Long id) {
        return entityManager.find(persistentClass, id);
    }

    /**
     * Retorna todos os registros da entidade no banco de dados utilizando JPQL dinâmica.
     */
    @Override
    public List<Entity> findAll() {
        return entityManager.createQuery("from " + persistentClass.getSimpleName(), persistentClass)
                            .getResultList();
    }
}