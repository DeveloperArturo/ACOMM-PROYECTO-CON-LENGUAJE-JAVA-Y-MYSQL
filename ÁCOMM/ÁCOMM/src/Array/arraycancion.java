package Array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Clases.clasecancion;

public class arraycancion {

	

	ArrayList<clasecancion> cc=new ArrayList<clasecancion>();
	
	public arraycancion() {
		
	}


	public int tamaño() {
		return cc.size();
	}
	public clasecancion obtener(int i){
		return cc.get(i);
	}
	public void eliminarTodo(){
		cc.clear();
	}
	public void agregar(clasecancion al){
		cc.add(al);
	}
	public int generar(){
		int codigo=1000;
		if(tamaño()==0){
			codigo=1000;
		}else{
			codigo=(obtener(cc.size()-1).getIDCancion()+1);
		
	
		}
			return codigo;
	}
	
	
	public void modificar(int p,clasecancion  u){
		cc.set(p,u);
		
		
	}
	
	public void removerrr(int r){
		cc.remove(r);
	}
	
	


	
	
	

	
}
