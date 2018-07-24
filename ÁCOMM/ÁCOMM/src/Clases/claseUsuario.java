package Clases;

import javax.swing.Icon;
import javax.swing.JOptionPane;

public class claseUsuario {

	
private int codigo;
private String apellidoPaterno,apellidoMaterno,nombres,password;  
private String tipoEmpleado,turno;



	public claseUsuario( int codigo ,String nombres,String apellidoPaterno, String apellidoMaterno, String  tipoEmpleado,String  turno,
		String password ) {
		this.codigo=codigo;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombres = nombres;
		this.password = password;
		this.tipoEmpleado = tipoEmpleado;
		this.turno = turno;
	
	
	
	}
	
	public claseUsuario( int codigo ,String nombres,String apellidoPaterno, String apellidoMaterno, String  tipoEmpleado,String  turno) {
			this.codigo=codigo;
			this.apellidoPaterno = apellidoPaterno;
			this.apellidoMaterno = apellidoMaterno;
			this.nombres = nombres;
			this.tipoEmpleado = tipoEmpleado;
			this.turno = turno;
		
		
		
		}

		


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String  getTipoEmpleado() {
		return tipoEmpleado;
	}
	public void setTipoEmpleado(String  tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
	public String  getTurno() {
		return turno;
	}
	public void setTurno(String  turno) {
		this.turno = turno;
	}
	
	public int getcodigo() {
		return codigo;
	}
	public void setCodigo(int codigo){
		this.codigo=codigo;
	}



	
}
