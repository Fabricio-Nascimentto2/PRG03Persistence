/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;

/**
 *
 * @author fabricio
 */
public class CursoService implements CursoIService {
    
    // O Service agora é o único que "conversa" com o DAO
    private final CursoIDao cursoDao = new CursoDao();
    
    /**
     *
     * @param curso
     */
    @Override
    public Curso save(Curso curso){
    if(curso == null) {
        throw new RuntimeException("Objeto curso nulo!");
    }
    
    if(StringUtil.isEmpty(curso.getNome())) {
        throw new RuntimeException("O nome do curso é obrigatório!");
    }
    
    // Retorne o resultado da chamada do DAO
    return cursoDao.save(curso); 
}

    @Override
    public Curso update(Curso curso) {
        if(curso == null) {
            throw new RuntimeException("Objeto curso nulo!");
        }
        return cursoDao.update(curso);
    }

    @Override
    public void delete(Curso curso) {
        if(curso == null) {
            throw new RuntimeException("Objeto curso nulo!");
        }
        cursoDao.delete(curso);
    }

    @Override
    public List<Curso> findAll() {
        return cursoDao.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return cursoDao.findById(id);
    }

    @Override
    public List<Curso> findByName(String name) {
        return cursoDao.findByName(name);
    }
}