package Clases;

public class claseregistro {

	private String usuario,fecha,hora;

	public claseregistro(String usuario, String fecha, String hora) {
		
		this.usuario = usuario;
		this.fecha = fecha;
		this.hora = hora;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
}
