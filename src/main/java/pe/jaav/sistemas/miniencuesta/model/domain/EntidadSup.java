package pe.jaav.sistemas.miniencuesta.model.domain;

import java.io.Serializable;

public class EntidadSup implements Serializable{

	private static final long serialVersionUID = 1L;

	private int inicio;
	private int numeroFilas;			
	private int contadorTotal;	
	
	private String accionDB;
	/*
	private String valorStringSup;
	private Integer valorIntSup;
	private boolean valorBoolSup;
	*/
	
	public int getInicio() {
		return inicio;
	}
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	public int getNumeroFilas() {
		return numeroFilas;
	}
	public void setNumeroFilas(int numeroFilas) {
		this.numeroFilas = numeroFilas;
	}

	public int getContadorTotal() {
		return contadorTotal;
	}
	public void setContadorTotal(int contadorTotal) {
		this.contadorTotal = contadorTotal;
	}
	public String getAccionDB() {
		return accionDB;
	}
	public void setAccionDB(String accionDB) {
		this.accionDB = accionDB;
	}

}
