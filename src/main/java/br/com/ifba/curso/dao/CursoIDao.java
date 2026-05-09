/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericIDao; // Importação necessária
import java.util.List;

/**
 * Interface de contrato para as operações de persistência da entidade Curso.
 * Estende a interface genérica GenericIDao para herdar as operações básicas de CRUD
 * e define assinaturas de métodos específicos para a lógica de negócio de cursos.
 * * @author fabricio
 */
public interface CursoIDao extends GenericIDao<Curso> {    
/**
* Define a busca de cursos por nome.
* @param name Nome ou parte do nome.
* @return Lista de cursos.
*/    
    List<Curso> findByName(String name);

    public void remover(Curso selecionado);
/**
* Assinatura para busca por nome em português, facilitando a chamada nas telas.
* @param termo Termo de pesquisa.
* @return Lista de cursos filtrados.
*/
    public List<Curso> buscarPorNome(String termo);
    
}