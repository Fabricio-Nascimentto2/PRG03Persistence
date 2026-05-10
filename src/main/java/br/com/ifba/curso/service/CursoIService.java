/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

/**
 * Interface que define as regras de negócio para a entidade Curso.
 * Funciona como um contrato para o CursoService.
 * @author fabricio
 */
public interface CursoIService {
    
    // Salva um novo curso após as validações
    Curso save(Curso curso);
    
    // Atualiza os dados de um curso existente
    Curso update(Curso curso);
    
    // Remove um curso do sistema
    void delete(Curso curso);
    
    // Retorna todos os cursos cadastrados
    List<Curso> findAll();
    
    // Busca um curso pelo ID
    Curso findById(Long id);
    
    // Busca cursos por nome (específico para esta funcionalidade)
    List<Curso> findByName(String name);
}
