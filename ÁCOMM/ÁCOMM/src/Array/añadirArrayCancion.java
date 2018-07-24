package Array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.claseañadircancion;

public class añadirArrayCancion {
	ArrayList<claseañadircancion> bebida=new ArrayList<claseañadircancion>();
	
				
	
	

	public añadirArrayCancion() {
		
		
	}
	
	public int tamaño(){
		return bebida.size();
	}
	public claseañadircancion Obtener(int i) {
		return bebida.get(i);
		
	}
	
	public void eliminarTodo(){
		bebida.clear();
	}
	public void agregar(claseañadircancion b){
		bebida.add(b);
	}
	public void modificar(int p,claseañadircancion u){
		bebida.set(p,u);
		
		
	}
	
	public void remover(int r){
		bebida.remove(r);
	}
	
	
	

	public void eliminarfinal(){
		bebida.remove(tamaño()-1);
	}
	
	
	

	


}
