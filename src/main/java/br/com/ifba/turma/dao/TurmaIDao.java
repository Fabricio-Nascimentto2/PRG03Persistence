/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.turma.dao;

import br.com.ifba.infrastructure.dao.GenericIDao;
import br.com.ifba.turma.entity.Turma;

/**
 * Interface de contrato para as operações de persistência da entidade Turma.
 * Ao estender GenericIDao<Turma>, esta interface herda automaticamente todas 
 * as assinaturas de métodos genéricos (save, update, delete, findAll, findById),
 * permitindo que a camada de visão manipule dados de Turma de forma padronizada.
 * * @author fabricio
 */
public interface TurmaIDao extends GenericIDao<Turma>{
    
}
