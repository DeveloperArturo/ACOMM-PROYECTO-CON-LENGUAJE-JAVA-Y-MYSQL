package Clases;


public class clasePiqueo {

	private String nombres,tipoPiqueo, estado;   private int IDpiqueo;   private double precio ;


	public clasePiqueo(int iDpiqueo, String nombres, String tipoPiqueo, double precio,String estado ) {
		IDpiqueo = iDpiqueo;
		this.nombres = nombres;
		this.tipoPiqueo = tipoPiqueo;
		this.estado = estado;
		this.precio = precio;
	
	}


	


	public int getIDpiqueo() {
		return IDpiqueo;
	}



	public void setIDpiqueo(int iDpiqueo) {
		IDpiqueo = iDpiqueo;
	}



	public String getNombres() {
		return nombres;
	}



	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public String getTipoPiqueo() {
		return tipoPiqueo;
	}



	public void setTipoPiqueo(String tipoPiqueo) {
		this.tipoPiqueo = tipoPiqueo;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
	

}
