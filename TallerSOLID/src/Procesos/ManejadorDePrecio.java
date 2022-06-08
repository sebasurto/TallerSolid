package Procesos;

import Postres.Postres;

public class ManejadorDePrecio {
	
	Postres postre;
	
	public String showPrecioFinal(){
        return "Precio Final: $ " + calcularPrecioFinal();
    }
	
	public double calcularPrecioFinal(){
        double precioFinal;
        precioFinal=(precioParcial+(precioParcial*0.12))+(aderezos.size()*0.50);
        return precioFinal;
    }
}
