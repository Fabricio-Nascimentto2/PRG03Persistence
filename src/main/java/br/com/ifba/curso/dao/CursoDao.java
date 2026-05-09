/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

import br.com.ifba.infrastructure.dao.GenericDao;
import br.com.ifba.curso.entity.Curso;
import java.util.List;

/**
 * Implementação específica do DAO para a entidade Curso.
 * Estende GenericDao para utilizar a infraestrutura genérica de persistência
 * e implementa os métodos de busca customizados definidos na interface CursoIDao.
 * @author fabricio
 */
public class CursoDao extends GenericDao<Curso> implements CursoIDao{
   
    // construtos da classe
    public CursoDao(){
        super(Curso.class);
    }
    
    // realiza a busa de cursos pelo nome utilizando jpql
    @Override
    public List<Curso> findByName(String name){
        String jpql = "from Curso c where lower(c.nome) like :name";
        return entityManager.createQuery(jpql, Curso.class)
                            .setParameter("name", "%" + name.toLowerCase() + "%")
                            .getResultList();
    }

    @Override
    public List<Curso> buscarPorNome(String termo){
        return this.findByName(termo);
    }
    
    // remove um curso do banco de dados
    // seleciona o objeto do tipo a ser removido
    @Override
    public void remover(Curso selecionado){
        // Chamamdo o delete no GenericDao
        this.delete(selecionado);
    }
}