package com.company.objective;

public class Auto extends Vehiculo {
	
	private int puertas;

	public Auto() {
		super();
	}

	public Auto(int ano, String marca, String modelo, String color, int ruedas, int puertas) {
		super(ano, marca, modelo, color, ruedas);
		this.puertas = puertas;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	
	@Override
	public void imprimeMarcaModelo() {
		System.out.println("Marca: "+super.getMarca()+" Modelo: "+super.getModelo());
	}
	
	

}
