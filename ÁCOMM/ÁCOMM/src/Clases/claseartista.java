package Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;

public class claseartista {
	
	
	private String estado,Nombreartistico,IDGENERO,registrocatalogo;
	private int IDArtista;



public claseartista() {
	
}


	public claseartista(int iDArtista, String nombreartistico, String iDGENERO, String registrocatalogo,
		String estado) {
	
		IDArtista = iDArtista;
		Nombreartistico = nombreartistico;
		IDGENERO = iDGENERO;
		this.registrocatalogo = registrocatalogo;
		this.estado = estado;
		
	}
	



	public int getIDArtista() {
		return IDArtista;
	}



	public void setIDArtista(int iDArtista) {
		IDArtista = iDArtista;
	}



	public String getNombreartistico() {
		return Nombreartistico;
	}



	public void setNombreartistico(String nombreartistico) {
		Nombreartistico = nombreartistico;
	}



	public String getIDGENERO() {
		return IDGENERO;
	}



	public void setIDGENERO(String iDGENERO) {
		IDGENERO = iDGENERO;
	}



	public String getRegistrocatalogo() {
		return registrocatalogo;
	}



	public void setRegistrocatalogo(String registrocatalogo) {
		this.registrocatalogo = registrocatalogo;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
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