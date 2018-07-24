package Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;

public class clasecancion {
	private String  estado,nombre,duracion,IDArtista,Album,registroCatalogo; 
	private int IDCancion;
	

	
		public clasecancion() {
		
		}
	public clasecancion(int iDCancion, String nombre, String duracion, String iDArtista, String album,
			String registroCatalogo, String estado) {
		IDCancion = iDCancion;
		this.nombre = nombre;
		this.duracion = duracion;
		IDArtista = iDArtista;
		Album = album;
		this.registroCatalogo = registroCatalogo;
		
		this.estado = estado;
	}






	public int getIDCancion() {
		return IDCancion;
	}



	public void setIDCancion(int iDCancion) {
		IDCancion = iDCancion;
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



	public String getIDArtista() {
		return IDArtista;
	}



	public void setIDArtista(String iDArtista) {
		IDArtista = iDArtista;
	}



	public String getAlbum() {
		return Album;
	}



	public void setAlbum(String album) {
		Album = album;
	}



	public String getRegistroCatalogo() {
		return registroCatalogo;
	}



	public void setRegistroCatalogo(String registroCatalogo) {
		this.registroCatalogo = registroCatalogo;
	}





	public String getEstado() {
		return estado;
	}



	public void setEstado(String  estado) {
		this.estado = estado;
	}
	

	
	public  Date SimpleDateFormatcatalogo(String naci) {
		
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
