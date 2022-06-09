/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Leche.LecheDeslactosada;
import Leche.LecheDescremada;
import Leche.LecheEntera;
import Postres.*;

/**
 *
 * @author Pedro Mendoza
 */
public class ManejadorDeLeche {
	private LecheEntera l_e;
	
	public ManejadorDeLeche(LecheEntera l_e) {
		
		this.l_e=l_e;
	}
	
    
    public void cambiarTipoLeche(Postres postre){
        // Cambiar tipo de leche en la preparación de los postres, usar leche deslactosada
        System.out.println(postre.getClass());
        System.out.println(Pastel.class);
        if(postre.getClass() == Pastel.class){
            postre.setLeche(this.l_e);
        }else{
            this.l_e.usarHelado();
        }
    }
    
    
}
