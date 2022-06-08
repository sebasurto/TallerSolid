package Postres;

import java.util.ArrayList;

import Adicionales.Aderezo;
import java.util.ArrayList;

public abstract class Postres {
	private String sabor;
    private double precioParcial;
    private ArrayList<Aderezo> aderezos;

	public abstract double calcularPrecioFinal();
	public abstract ArrayList<Aderezo> getAderezos();
	public abstract String toString();
    public abstract String showPrecioFinal();
}
