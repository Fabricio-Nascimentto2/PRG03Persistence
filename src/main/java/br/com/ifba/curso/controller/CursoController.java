/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import br.com.ifba.curso.service.CursoService;
import java.util.List;

/**
 * Camada de Controle (Controller/Facade) para a entidade Curso.
 * Esta classe atua como intermediária entre a interface gráfica (View) e a 
 * camada de negócios (Service), seguindo o padrão de projeto Facade para 
 * simplificar o acesso aos serviços do sistema.
 * * @author fabricio
 */
public class CursoController implements CursoIController{
    // Instância da camada de serviço para processamento das regras de negócio
    private final CursoIService cursoService = new CursoService();

    /**
     * Solicita a persistência de um novo curso.
     * @param curso Objeto contendo os dados do curso.
     * @return O curso persistido com o ID gerado.
     */
    @Override
    public Curso save(Curso curso) throws RuntimeException {
        return this.cursoService.save(curso);
    }

    /**
     * Solicita a atualização de um curso já existente.
     * @param curso Objeto com os dados atualizados.
     */
    @Override
    public void update(Curso curso) throws RuntimeException {
        this.cursoService.update(curso);
    }

    /**
     * Solicita a remoção de um curso do banco de dados.
     * @param curso O curso a ser removido.
     */
    @Override
    public void delete(Curso curso) throws RuntimeException {
        this.cursoService.delete(curso);
    }

    /**
     * Recupera a lista completa de cursos cadastrados.
     * @return Lista de entidades Curso.
     */
    @Override
    public List<Curso> findAll() throws RuntimeException {
        return this.cursoService.findAll();
    }

    /**
     * Busca um curso específico através de seu identificador único.
     * @param id Identificador do curso.
     * @return Objeto Curso encontrado ou null.
     */
    @Override
    public Curso findById(Long id) throws RuntimeException {
        return this.cursoService.findById(id);
    }

    /**
     * Filtra cursos baseando-se em uma parte do nome.
     * @param nome Termo para pesquisa.
     * @return Lista de cursos que atendem ao critério.
     */
    @Override
    public List<Curso> findByName(String nome) throws RuntimeException {
        return this.cursoService.findByName(nome);
        
    }
    
}