package Clases;

public class claseañadirbebida {

	private String nombre,marca,IDReserva,tipoBebida,estado;
	   private int IDBebida;   private double precio;

	public claseañadirbebida(String iDReserva, int iDBebida, String nombre, String marca, String tipoBebida, String estado,
			double precio) {
		IDReserva = iDReserva;
		IDBebida = iDBebida;
		this.nombre = nombre;
		this.marca = marca;
		this.tipoBebida = tipoBebida;
		this.estado = estado;
		this.precio = precio;
	}





	public String getIDReserva() {
		return IDReserva;
	}





	public void setIDReserva(String  iDReserva) {
		IDReserva = iDReserva;
	}





	public int getIDBebida() {
		return IDBebida;
	}





	public void setIDBebida(int iDBebida) {
		IDBebida = iDBebida;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getMarca() {
		return marca;
	}





	public void setMarca(String marca) {
		this.marca = marca;
	}





	public String getTipoBebida() {
		return tipoBebida;
	}





	public void setTipoBebida(String tipoBebida) {
		this.tipoBebida = tipoBebida;
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
