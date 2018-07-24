package Clases;



public class claseGenero {
	private String descripcion,procedencia,epoca,estado;   private int IDGenero;


	public claseGenero(int iDGenero, String descripcion, String procedencia, String epoca, String estado) {
	
		IDGenero = iDGenero;
		this.descripcion = descripcion;
		this.procedencia = procedencia;
		this.epoca = epoca;
		this.estado = estado;
		
	}



	public int getIDGenero() {
		return IDGenero;
	}



	public void setIDGenero(int iDGenero) {
		IDGenero = iDGenero;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getProcedencia() {
		return procedencia;
	}



	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	



	public String getEpoca() {
		return epoca;
	}



	public void setEpoca(String epoca) {
		this.epoca = epoca;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	
	
	
	
	

}
