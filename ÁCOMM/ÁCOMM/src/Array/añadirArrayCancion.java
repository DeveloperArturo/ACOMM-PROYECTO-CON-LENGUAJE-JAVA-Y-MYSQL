package Array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.clasea�adircancion;

public class a�adirArrayCancion {
	ArrayList<clasea�adircancion> bebida=new ArrayList<clasea�adircancion>();
	
				
	
	

	public a�adirArrayCancion() {
		
		
	}
	
	public int tama�o(){
		return bebida.size();
	}
	public clasea�adircancion Obtener(int i) {
		return bebida.get(i);
		
	}
	
	public void eliminarTodo(){
		bebida.clear();
	}
	public void agregar(clasea�adircancion b){
		bebida.add(b);
	}
	public void modificar(int p,clasea�adircancion u){
		bebida.set(p,u);
		
		
	}
	
	public void remover(int r){
		bebida.remove(r);
	}
	
	
	

	public void eliminarfinal(){
		bebida.remove(tama�o()-1);
	}
	
	
	

	


}
