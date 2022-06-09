package Postres;

import java.util.ArrayList;

import Adicionales.Aderezo;
import Adicionales.Crema;
import Leche.LecheEntera;
import Procesos.ManejadorDePrecio;
import Procesos.OperacionesAderezo;

import java.util.ArrayList;

public abstract class Postres extends ManejadorDePrecio{
	private String sabor;
    protected double precioParcial;
    protected ArrayList<Aderezo> aderezos;
    private LecheEntera tipo_leche  ;

	public abstract ArrayList<Aderezo> getAderezos();
	public abstract String toString();
	
	public double calcularPrecioFinal(){
        double precioFinal;
        precioFinal=(precioParcial+(precioParcial*0.12))+(aderezos.size()*0.50);
        return precioFinal;
    }
	
	public String showPrecioFinal(){
        return "Precio Final: $ " + calcularPrecioFinal();
    }
	public void addAderezos(Aderezo aderezo) {
		OperacionesAderezo.anadirAderezoPostres(this, aderezo);
	}
	
	public void setLeche(LecheEntera tipo_leche ) {
		this.tipo_leche= tipo_leche;
	}
		
}
