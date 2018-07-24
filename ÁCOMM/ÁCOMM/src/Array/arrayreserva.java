package Array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Clases.claseUsuario;
import Clases.clasereserva;

public class arrayreserva {
	
	ArrayList<clasereserva> arr=new ArrayList<clasereserva>();
	

	public arrayreserva() {
	
		
	}
	
	public int tamaño() {
		return arr.size();
	}
	public clasereserva obtener(int i){
		return arr.get(i);
	}
	public void eliminarTodo(){
		arr.clear();
	}
	public void agregar(clasereserva al){
		arr.add(al);
	}
	public int generar(){
		int codigo=1000;
		if(tamaño()==0){
			codigo=1001;
		}else{
			codigo=(obtener(arr.size()-1).getIDReserva()+1);
		
	
		}
			return codigo;
	}
	
	
	public void modificar(int p,clasereserva  u){
		arr.set(p,u);
		
		
	}
	
	public void removerrr(int r){
		arr.remove(r);
	}
	
	public void eliminarFinal(){
		arr.remove(tamaño()-1);
	}
	
	
			
	
	


}
