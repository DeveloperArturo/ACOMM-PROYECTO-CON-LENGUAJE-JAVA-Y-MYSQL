package Clases;

public class clasedetalle {
	
	private int consumo;
	
	private String fecha,cliente;  private double precioPi,precioBe,total;
private int bebida,piqueo;

	public clasedetalle(int consumo, String cliente, int bebida,double precioBe, int  piqueo,
			double precioPi, String fecha,double total) {
		this.consumo = consumo;
		this.cliente = cliente;
		this.bebida = bebida;
		this.piqueo = piqueo;
		this.fecha = fecha;
		this.precioPi = precioPi;
		this.precioBe = precioBe;
		this.total = total;
	}


	public int getConsumo() {
		return consumo;
	}


	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}



	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public int getBebida() {
		return bebida;
	}


	public void setBebida(int bebida) {
		this.bebida = bebida;
	}


	public int getPiqueo() {
		return piqueo;
	}


	public void setPiqueo(int piqueo) {
		this.piqueo = piqueo;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public double getPrecioPi() {
		return precioPi;
	}


	public void setPrecioPi(double precioPi) {
		this.precioPi = precioPi;
	}


	public double getPrecioBe() {
		return precioBe;
	}


	public void setPrecioBe(double precioBe) {
		this.precioBe = precioBe;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	
	

}
