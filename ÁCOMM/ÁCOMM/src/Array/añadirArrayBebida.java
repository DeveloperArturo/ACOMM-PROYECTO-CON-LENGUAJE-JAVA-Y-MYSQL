package Array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.claseañadirbebida;

public class añadirArrayBebida {
	
	ArrayList<claseañadirbebida> bebida=new ArrayList<claseañadirbebida>();

				
	
	

	public añadirArrayBebida() {
		
		
		
	}
	
	public int tamaño(){
		return bebida.size();
	}
	public claseañadirbebida Obtener(int i) {
		return bebida.get(i);
		
	}
	
	public void eliminarTodo(){
		bebida.clear();
	}
	public void agregar(claseañadirbebida b){
		bebida.add(b);
	}
	public void modificar(int p,claseañadirbebida u){
		bebida.set(p,u);
		
		
	}
	
	public void remover(int r){
		bebida.remove(r);
	}
	
	
	

	public void eliminarfinal(){
		bebida.remove(tamaño()-1);
	}
	
	

	

	

	
}