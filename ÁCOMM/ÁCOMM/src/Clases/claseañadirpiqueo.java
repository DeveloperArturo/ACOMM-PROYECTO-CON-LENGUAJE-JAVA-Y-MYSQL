package Clases;

public class claseañadirpiqueo {


	private String nombre,IDReserva,tipoPiqueo,estado;
	   private int IDPiqueo;   private double precio;


		
	public claseañadirpiqueo(String iDReserva ,int iDPiqueo,String nombre,  String tipoPiqueo,  String estado , double precio) {
		this.nombre = nombre;
		IDReserva = iDReserva;
		this.tipoPiqueo = tipoPiqueo;
		this.estado = estado;
		IDPiqueo = iDPiqueo;
		this.precio = precio;
	}

	
	

	public String getNombre() {
		return nombre;
	}







	public void setNombre(String nombre) {
		this.nombre = nombre;
	}









	public String getIDReserva() {
		return IDReserva;
	}










	public void setIDReserva(String iDReserva) {
		IDReserva = iDReserva;
	}










	public   String  getTipoPiqueo() {
		return tipoPiqueo;
	}





	public void setTipoPiqueo(  String  tipoPiqueo) {
		this.tipoPiqueo = tipoPiqueo;
	}








	public   String  getEstado() {
		return estado;
	}










	public void setEstado(  String  estado) {
		this.estado = estado;
	}















	public int getIDPiqueo() {
		return IDPiqueo;
	}










	public void setIDPiqueo(int iDPiqueo) {
		IDPiqueo = iDPiqueo;
	}









	public double getPrecio() {
		return precio;
	}







	public void setPrecio(double precio) {
		this.precio = precio;
	}






}
