/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import java.util.ArrayList;

import Adicionales.Aderezo;
import Adicionales.Crema;
import Adicionales.Frutilla;
import Postres.*;
import Procesos.*;
import Leche.*;
/**
 *
 * @author djurado
 */
public class Sistema {
    /*public static void main(String [ ] args){
        // Producir un helado de vainilla y una torta de chocolate, 
        // a ambos agregarles CREMA y FRUTILLAS
        // y cambiar el tipo de leche por Leche Descremada
        // Finalmente mostrar el precio final de cada uno
        LecheEntera leche = new LecheDeslactosada();	
        ManejadorDeLeche mnj_leche = new ManejadorDeLeche();
        
        // Producir Helado
        Helado helado_vainilla = new Helado("Vainilla");
        //Crema c=new Crema("CREMA");
        //Frutilla f=new Frutilla("FRUTILLA");
        OperacionesAderezo.anadirAderezoPostres(helado_vainilla, new Crema("CREMA"));
        OperacionesAderezo.anadirAderezoPostres(helado_vainilla, new Frutilla("FRUTILLA"));
        System.out.println(helado_vainilla);
        
        mnj_leche.cambiarTipoLeche(leche, helado_vainilla);
        
        System.out.println(helado_vainilla.showPrecioFinal());
        
        // Producir Pastel
        Pastel pastel_chocolate = new Pastel("Chocolate");
        OperacionesAderezo.quitarAderezoPostres(pastel_chocolate, new Crema("CREMA"));
        OperacionesAderezo.anadirAderezoPostres(pastel_chocolate, new Frutilla("FRUTILLA"));
        System.out.println(pastel_chocolate);
        
        mnj_leche.cambiarTipoLeche(leche, pastel_chocolate);
        
        System.out.println(helado_vainilla.showPrecioFinal());
        
        
    }*/
	
	
	
	 public static void main(String [ ] args){
	        // Producir un helado de vainilla y una torta de chocolate, 
	        // a ambos agregarles CREMA y FRUTILLAS
	        // y cambiar el tipo de leche por Leche Deslactosada
	        ArrayList<Postres> arrPostres = new ArrayList<>();
	        //LecheEntera leche = new LecheDeslactosada();
	        ManejadorDeLeche mnj_leche = new ManejadorDeLeche(new LecheDescremada());
	       
	        // Producir Helado
	        Postres helado_vainilla = new Helado("Vainilla");
	        arrPostres.add(helado_vainilla);
	        
	        // Producir Pastel
	        Postres pastel_chocolate = new Pastel("Chocolate");
	        arrPostres.add(pastel_chocolate);
	        
	        arrPostres.forEach(postre -> {
	            postre.addAderezos(new Crema("CREMA"));
	            postre.addAderezos(new Frutilla("FRUTILLA"));
	            System.out.println(postre);
	            mnj_leche.cambiarTipoLeche(postre);
	            System.out.println(ManejadorDePrecio.showPrecioFinal(postre));
	        });
	        }     
	        
	
}
