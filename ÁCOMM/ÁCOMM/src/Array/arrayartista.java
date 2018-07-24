package Array;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Clases.claseartista;

public class arrayartista {
	
ArrayList<claseartista> ar=new ArrayList<claseartista>();
	
	

	public arrayartista() {
		

		
	}
	
	

	public int tamaño() {
		return ar.size();
	}
	public claseartista obtener(int i){
		return ar.get(i);
	}
	public void eliminarTodo(){
		ar.clear();
	}
	public void agregar(claseartista al){
		ar.add(al);
	}
	public int generar(){
		int codigo=1000;
		if(tamaño()==0){
			codigo=1000;
		}else{
			codigo=(obtener(ar.size()-1).getIDArtista()+1);
		
	
		}
			return codigo;
	}
	
	
	public void modificar(int p,claseartista  u){
		ar.set(p,u);
		
		
	}
	
	public void removerrr(int r){
		ar.remove(r);
	}
	
	

	


}
