package Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class clasepedido {

	private String fechaPedido,IDUsuario,horaReserva,estado;
	private int IDPedido,canciones,bebidas,piqueos	;


	public clasepedido() {
		
}

	public clasepedido(int iDPedido, String fechaPedido, String iDUsuario, String horaReserva, String estado,
		int canciones, int bebidas, int piqueos) {
		IDPedido = iDPedido;
		this.fechaPedido = fechaPedido;
		IDUsuario = iDUsuario;
		this.horaReserva = horaReserva;
		this.estado = estado;
		this.canciones = canciones;
		this.bebidas = bebidas;
		this.piqueos = piqueos;
		
	}



	public int getIDPedido() {
		return IDPedido;
	}



	public void setIDPedido(int iDPedido) {
		IDPedido = iDPedido;
	}



	public String getFechaPedido() {
		return fechaPedido;
	}



	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}



	public String getIDUsuario() {
		return IDUsuario;
	}



	public void setIDUsuario(String iDUsuario) {
		IDUsuario = iDUsuario;
	}



	public String getHoraReserva() {
		return horaReserva;
	}



	public void setHoraReserva(String horaReserva) {
		this.horaReserva = horaReserva;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public int getCanciones() {
		return canciones;
	}



	public void setCanciones(int canciones) {
		this.canciones = canciones;
	}



	public int getBebidas() {
		return bebidas;
	}



	public void setBebidas(int bebidas) {
		this.bebidas = bebidas;
	}



	public int getPiqueos() {
		return piqueos;
	}



	public void setPiqueos(int piqueos) {
		this.piqueos = piqueos;
	}
	
	
	

public  Date SimpleDateFormat(String naci) {
		
		SimpleDateFormat s=new SimpleDateFormat("dd/MM/yyyy");
		Date nacimiento=null;
		try {
			nacimiento=s.parse(naci);
		} catch (ParseException e) {
	
			e.printStackTrace();
		}
		return nacimiento;
	}
	
	

	



}
