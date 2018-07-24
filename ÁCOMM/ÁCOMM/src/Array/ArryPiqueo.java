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
import Clases.clasePiqueo;

public class ArryPiqueo {

	ArrayList<clasePiqueo> piqueo=new ArrayList<clasePiqueo>();
	
	
	public ArryPiqueo() {
	
	}
	


	public int tamaño(){
		return piqueo.size();
	}
	
	public clasePiqueo Obtener(int i) {
		return piqueo.get(i);
		
	}
	public void eliminarTodo(){
		piqueo.clear();
	}
	public void agregar(clasePiqueo a){
		piqueo.add(a);
	}
	public int generar(){
		int codigo=1000;
		if(tamaño()==0){
			codigo=1000;
		}else{
			codigo=(Obtener(piqueo.size()-1).getIDpiqueo()+1);
		
	
		}
			return codigo;
	}
	
	public void modificar(int p,clasePiqueo u){
		piqueo.set(p,u);
		
		
	}
	
	public void remover(int r){
		piqueo.remove(r);
	}
	


	

}
