package Clases;

public class clasereserva {

private String IDPedido,IDUsuario,IDcliente,fecha,hora;	

private int IDReserva;
public clasereserva() {
	
}

	public clasereserva(int iDReserva, String iDPedido, String iDUsuario, String iDcliente, String fecha,
			String hora) {
	
		IDReserva = iDReserva;
		IDPedido = iDPedido;
		IDUsuario = iDUsuario;
		IDcliente = iDcliente;
		this.fecha = fecha;
		this.hora = hora;
		
		
	}




	public int getIDReserva() {
		return IDReserva;
	}




	public void setIDReserva(int iDReserva) {
		IDReserva = iDReserva;
	}




	public String getIDPedido() {
		return IDPedido;
	}




	public void setIDPedido(String iDPedido) {
		IDPedido = iDPedido;
	}




	public String getIDUsuario() {
		return IDUsuario;
	}




	public void setIDUsuario(String iDUsuario) {
		IDUsuario = iDUsuario;
	}




	public String getIDcliente() {
		return IDcliente;
	}




	public void setIDcliente(String iDcliente) {
		IDcliente = iDcliente;
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
