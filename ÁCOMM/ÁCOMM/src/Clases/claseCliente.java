package Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;

public class claseCliente {
	
	
	
private String usurio,apellidoPaterno,apellidoMaterno,nombres,direccion,estadoCivil,tipodeCliente;  private String fechanacimiento,fechaAfiliacion;
	
	private int iDcliente ;  private int dni,telefono; 	

	public claseCliente() {
	
}

	/*
	 cod_cliente int ,
    nombre varchar(200),
	apellido_paterno varchar(200),
    apellido_materno varchar(200),
    direccion varchar (200),
    fecha_nacimiento  varchar(40),
    fecha_afilicacion varchar(40),
    estado_civil char (1),
    tipo_cliente varchar (2000),
    dni int,
    cod_usuarios varchar(100),
    telefono int,
    image blob
	 */
	

	public claseCliente(int iDcliente,String nombres ,String apellidoPaterno, String apellidoMaterno, 
			String direccion, String fechanacimiento,String fechaAfiliacion,String  estadoCivil,String  tipodeCliente, int dni ,String usurio,int telefono  
			 ) {
		this.iDcliente = iDcliente;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombres = nombres;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
		this.usurio = usurio;
		this.fechanacimiento = fechanacimiento;
		this.fechaAfiliacion = fechaAfiliacion;
		this.estadoCivil = estadoCivil;
		this.tipodeCliente = tipodeCliente;
	
	}




	



	public int getIDcliente() {
		return iDcliente;
	}




	public void setIDcliente(int iDcliente) {
		this.iDcliente = iDcliente;
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




	public String getDireccion() {
		return direccion;
	}




	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	public  int getTelefono() {
		return telefono;
	}




	public void setTelefono( int telefono) {
		this.telefono = telefono;
	}




	public  int getDni() {
		return dni;
	}




	public void setDni( int dni) {
		this.dni = dni;
	}




	public String getUsurio() {
		return usurio;
	}




	public void setUsurio(String usurio) {
		this.usurio = usurio;
	}




	public String getFechanacimiento() {
		return fechanacimiento;
	}




	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}




	public String getFechaAfiliacion() {
		return fechaAfiliacion;
	}




	public void setFechaAfiliacion(String fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}




	public String  getEstadoCivil() {
		return estadoCivil;
	}




	public void setEstadoCivil(String  estadoCivil) {
		this.estadoCivil = estadoCivil;
	}




	public String  getTipodeCliente() {
		return tipodeCliente;
	}




	public void setTipodeCliente(String  tipodeCliente) {
		this.tipodeCliente = tipodeCliente;
	}


	

	public  Date SimpleDateFormatNacimiento(String naci) {
		
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
