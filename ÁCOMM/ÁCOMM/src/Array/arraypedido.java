package Array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;


import Clases.clasepedido;

public class arraypedido {
	ArrayList<clasepedido> ap=new ArrayList<clasepedido>();

	public arraypedido() {
	
		
	}
	


	public int tamaño() {
		return ap.size();
	}
	public clasepedido obtener(int i){
		return ap.get(i);
	}
	public void eliminarTodo(){
		ap.clear();
	}
	public void agregar(clasepedido al){
		ap.add(al);
	}
	public int generar(){
		int codigo=1000;
		if(tamaño()==0){
			codigo=1000;
		}else{
			codigo=(obtener(ap.size()-1).getIDPedido()+1);
		
	
		}
			return codigo;
	}
	
	
	public void modificar(int p,clasepedido  u){
		ap.set(p,u);
		
		
	}
	
	public void removerrr(int r){
		ap.remove(r);
	}
	
	public void eliminarFinal(){
		ap.remove(tamaño()-1);
	}
	

}
	
	







