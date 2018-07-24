package Array;

import java.util.ArrayList;

import Clases.clasedetalle;
import Clases.claseregistro;

public class arrayregistro {

	ArrayList<claseregistro> arr=new ArrayList<claseregistro>();
	private String detal;
	
	public arrayregistro() {
	
	
		
		

		
	}
	
	public String getDetal() {
		return detal;
	}

	public void setDetal(String detal) {
		this.detal = detal;
	}

	public int tamaño() {
		return arr.size();
	}
	public claseregistro obtener(int i){
		return arr.get(i);
	}
	public void eliminarTodo(){
		arr.clear();
	}
	public void agregar(claseregistro al){
		arr.add(al);
	}
	
	
	
	public void modificar(int p,claseregistro  u){
		arr.set(p,u);
		
		
	}
	
	public void removerrr(int r){
		arr.remove(r);
	}
	
	public void eliminarFinal(){
		arr.remove(tamaño()-1);
	}

}
