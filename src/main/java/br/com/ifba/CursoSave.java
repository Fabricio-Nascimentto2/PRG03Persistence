/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.ifba;

/**
 *
 * @author fabricio
 */
public class CursoSave {

    public static void main(String[] args) {
    // Isso aqui lê o persistence.xml e tenta conectar
    javax.persistence.EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("prg03presistencia");
    
    emf.createEntityManager(); // craia a tabela
    System.out.println("Tabela criada com sucesso no banco bancocurso!");
    
    }
    
}
