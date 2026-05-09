/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.turma.dao;

import br.com.ifba.infrastructure.dao.GenericDao;
import br.com.ifba.turma.entity.Turma;

/**
 * Implementação do DAO para a entidade Turma.
 * Ao estender o GenericDao, esta classe herda automaticamente todas as 
 * funcionalidades de CRUD (Salvar, Atualizar, Deletar e Listar), reduzindo
 * drasticamente a repetição de código e facilitando a manutenção.
 * * @author fabricio
 */
public class TurmaDao extends GenericDao<Turma> implements TurmaIDao{

    /**
     * Construtor da classe TurmaDao.
     * Utiliza o método super para passar a classe Turma.class ao GenericDao,
     * permitindo que o motor de persistência genérico saiba qual tabela manipular.
     */ 
    
    public TurmaDao(){
        super(Turma.class);
    }
}
