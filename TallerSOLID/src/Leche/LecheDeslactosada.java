/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leche;

/**
 *
 * @author Pedro Mendoza
 */
public class LecheDeslactosada extends LecheEntera {
    
    @Override
    public void usarHelado() {
        System.out.println("Usando leche deslactosada");
    }

    @Override
    public void usarPastel() {
        // Lanzar error No se puede usar en pastel
        System.out.println("No se puede usar leche deslactosada en este postre");
        //Se debe agregar excepción en otro módulo
        //throw new RuntimeException(this.getClass() + ": No se puede usar en pastel");
    }
        
}
