/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

/**
 * Classe utilitária para manipulação e validação de Strings.
 * @author fabricio
 */
public class StringUtil {
    
    /**
     * Verifica se uma String é nula ou se está vazia (apenas espaços).
     * @param str A string a ser validada.
     * @return true se estiver vazia ou nula, false caso contrário.
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    
}
