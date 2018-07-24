package Array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.claseañadirpiqueo;

public class añadirArraypiqueo {
	
	ArrayList<claseañadirpiqueo> bebida=new ArrayList<claseañadirpiqueo>();
	
				
	
	
	public añadirArraypiqueo() {
		
	}
	


	public int tamaño(){
		return bebida.size();
	}
	public claseañadirpiqueo Obtener(int i) {
		return bebida.get(i);
		
	}
	
	public void eliminarTodo(){
		bebida.clear();
	}
	public void agregar(claseañadirpiqueo b){
		bebida.add(b);
	}
	public void modificar(int p,claseañadirpiqueo u){
		bebida.set(p,u);
		
		
	}
	
	public void remover(int r){
		bebida.remove(r);
	}
	
	
	

	public void eliminarfinal(){
		bebida.remove(tamaño()-1);
	}
	
}