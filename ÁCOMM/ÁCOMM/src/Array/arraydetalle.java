package Array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.Icon;

import Clases.clasedetalle;

public class arraydetalle {
	
	ArrayList<clasedetalle> arr=new ArrayList<clasedetalle>();
	
	public arraydetalle() {
		
		

	
	}
	
	
	public int tamaño() {
		return arr.size();
	}
	public clasedetalle obtener(int i){
		return arr.get(i);
	}
	public void eliminarTodo(){
		arr.clear();
	}
	public void agregar(clasedetalle al){
		arr.add(al);
	}
	public int generar(){
		int codigo=1000;
		if(tamaño()==0){
			codigo=1000;
		}else{
			codigo=(obtener(arr.size()-1).getConsumo()+1);
		
	
		}
			return codigo;
	}
	
	
	public void modificar(int p,clasedetalle  u){
		arr.set(p,u);
		
		
	}
	
	public void removerrr(int r){
		arr.remove(r);
	}
	
	public void eliminarFinal(){
		arr.remove(tamaño()-1);
	}
	
	
			
	
	
	



}
