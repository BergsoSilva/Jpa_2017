/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

/**
 *
 * @author Administrador
 */
public class TestaTelefone {
    
    public static void main(String[] args) {
        //Cria a expressão regular resumida do cep
        String telefone = "(11) 3445-4222";
        boolean valor = telefone.matches("^\\([1-9]{2}\\) [9][8-9]{1}[0-9]{3}\\-[0-9]{4}$|^\\([1-9]{2}\\) [3][2-5]{1}[0-9]{2}\\-[0-9]{4}$");
        
        System.out.println("telefone: " + valor);
    }
    
}
