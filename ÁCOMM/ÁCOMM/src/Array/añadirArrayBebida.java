package Array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.clasea�adirbebida;

public class a�adirArrayBebida {
	
	ArrayList<clasea�adirbebida> bebida=new ArrayList<clasea�adirbebida>();

				
	
	

	public a�adirArrayBebida() {
		
		
		
	}
	
	public int tama�o(){
		return bebida.size();
	}
	public clasea�adirbebida Obtener(int i) {
		return bebida.get(i);
		
	}
	
	public void eliminarTodo(){
		bebida.clear();
	}
	public void agregar(clasea�adirbebida b){
		bebida.add(b);
	}
	public void modificar(int p,clasea�adirbebida u){
		bebida.set(p,u);
		
		
	}
	
	public void remover(int r){
		bebida.remove(r);
	}
	
	
	

	public void eliminarfinal(){
		bebida.remove(tama�o()-1);
	}
	
	

	

	

	
}