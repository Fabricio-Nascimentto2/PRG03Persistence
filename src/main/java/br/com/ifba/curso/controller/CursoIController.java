/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

/**
 * Interface que define o contrato do Controlador para a entidade Curso.
 * Funciona como o ponto de entrada para a View acessar os serviços.
 * @author fabricio
 */
public interface CursoIController {
    
    // Método para salvar um curso
    Curso save(Curso curso) throws RuntimeException;
    
    // Método para atualizar um curso
    void update(Curso curso) throws RuntimeException;
    
    // Método para remover um curso
    void delete(Curso curso) throws RuntimeException;
    
    // Método para buscar todos os cursos
    List<Curso> findAll() throws RuntimeException;
    
    // Método para buscar um curso por ID
    Curso findById(Long id) throws RuntimeException;
    
    // Método para buscar cursos por nome
    List<Curso> findByName(String nome) throws RuntimeException;
    
}
