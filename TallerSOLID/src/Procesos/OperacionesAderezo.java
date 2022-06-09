/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Adicionales.Aderezo;
import Postres.Pastel;
import Postres.Postres;
import Postres.Helado;

/**
 *
 * @author Pedro Mendoza
 */
public class OperacionesAderezo {
    
    public static void anadirAderezoPostres(Postres helado,Aderezo aderezo){
    	if(helado.getAderezos()==null)
    		helado.getAderezos().add(aderezo);
    }
    
    public static void quitarAderezoPostres(Postres helado,Aderezo aderezo){
        helado.getAderezos().remove(aderezo);
    }
    
    
    
}
