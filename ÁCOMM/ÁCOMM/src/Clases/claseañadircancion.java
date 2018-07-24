package Clases;

public class claseañadircancion {

	
	private String nombre ,estado,duracion,album,registro,IDReserva;
	private int IDcancion,IDartista;
	public claseañadircancion(String iDReserva, int iDcancion, String nombre, String duracion, int iDartista,
			String album, String registro, String estado) {

		IDReserva = iDReserva;
		IDcancion = iDcancion;
		this.nombre = nombre;
		this.duracion = duracion;
		IDartista = iDartista;
		this.album = album;
		this.registro = registro;
		this.estado = estado;
	}
	
	
	
	public String getIDReserva() {
		return IDReserva;
	}
	public void setIDReserva(String iDReserva) {
		IDReserva = iDReserva;
	}
	public int getIDcancion() {
		return IDcancion;
	}
	public void setIDcancion(int iDcancion) {
		IDcancion = iDcancion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public int getIDartista() {
		return IDartista;
	}
	public void setIDartista(int iDartista) {
		IDartista = iDartista;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
}
