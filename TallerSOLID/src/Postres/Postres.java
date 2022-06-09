package Postres;

import java.util.ArrayList;

import Adicionales.Aderezo;
import Procesos.ManejadorDePrecio;

import java.util.ArrayList;

public abstract class Postres implements ManejadorDePrecio{
	private String sabor;
    protected double precioParcial;
    protected ArrayList<Aderezo> aderezos;

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
	
}
