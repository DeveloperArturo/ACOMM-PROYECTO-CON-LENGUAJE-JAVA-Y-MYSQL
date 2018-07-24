package Array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Clases.claseGenero;


public class arraygenero {
	ArrayList<claseGenero> genero=new ArrayList<claseGenero>();

	

	public arraygenero() {
		
		
	}

	
	public int tamaño(){
		return genero.size();
	}
	public claseGenero Obtener(int i) {
		return genero.get(i);
		
	}
	
	public void eliminarTodo(){
		genero.clear();
	}
	public void agregar(claseGenero b){
		genero.add(b);
	}
	public void modificar(int p,claseGenero u){
		genero.set(p,u);
		
		
	}
	
	public void remover(int r){
		genero.remove(r);
	}
	public int generar(){
		int codigo=1000;
		if(tamaño()==0){
			codigo=1000;
		}else{
			codigo=(Obtener(genero.size()-1).getIDGenero()+1);
		
	
		}
			return codigo;
	}
	
	
	
	

}
