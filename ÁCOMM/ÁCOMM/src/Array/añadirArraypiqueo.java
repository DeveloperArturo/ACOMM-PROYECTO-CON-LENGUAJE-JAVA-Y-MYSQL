package Array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.clasea�adirpiqueo;

public class a�adirArraypiqueo {
	
	ArrayList<clasea�adirpiqueo> bebida=new ArrayList<clasea�adirpiqueo>();
	
				
	
	
	public a�adirArraypiqueo() {
		
	}
	


	public int tama�o(){
		return bebida.size();
	}
	public clasea�adirpiqueo Obtener(int i) {
		return bebida.get(i);
		
	}
	
	public void eliminarTodo(){
		bebida.clear();
	}
	public void agregar(clasea�adirpiqueo b){
		bebida.add(b);
	}
	public void modificar(int p,clasea�adirpiqueo u){
		bebida.set(p,u);
		
		
	}
	
	public void remover(int r){
		bebida.remove(r);
	}
	
	
	

	public void eliminarfinal(){
		bebida.remove(tama�o()-1);
	}
	
}